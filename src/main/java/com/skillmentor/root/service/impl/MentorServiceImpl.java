package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;
import com.skillmentor.root.entity.RoleEntity;
import com.skillmentor.root.exception.MentorException;
import com.skillmentor.root.mapper.MentorEntityDTOMapper;
import com.skillmentor.root.repository.ClassRoomRepository;
import com.skillmentor.root.repository.MentorRepository;
import com.skillmentor.root.repository.RoleRepository;
import com.skillmentor.root.service.MentorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        try {
            // Validate input
            if (mentorDTO == null) {
                throw new MentorException("Mentor data cannot be null");
            }
            if (mentorDTO.getPassword() == null || mentorDTO.getPassword().trim().isEmpty()) {
                throw new MentorException("Password cannot be null or empty");
            }

            // Encode password
            mentorDTO.setPassword(passwordEncoder.encode(mentorDTO.getPassword()));

            // Find role
            RoleEntity mentorRole = roleRepository.findByName("ROLE_MENTOR")
                    .orElseThrow(() -> new MentorException("ROLE_MENTOR not found in Role table"));

            // Map DTO to Entity
            MentorEntity newMentor = MentorEntityDTOMapper.map(mentorDTO);
            if (newMentor == null) {
                throw new MentorException("Failed to map MentorDTO to MentorEntity");
            }

            newMentor.setRole(mentorRole);

            // Save entity
            MentorEntity savedMentor = mentorRepository.save(newMentor);

            // Map Entity to DTO
            MentorDTO result = MentorEntityDTOMapper.map(savedMentor, false, false);
            if (result == null) {
                throw new MentorException("Failed to map MentorEntity to MentorDTO");
            }

            return result;
        } catch (MentorException e) {
            throw e; // Custom exception propagation
        } catch (Exception e) {
            throw new MentorException("Failed to create mentor: " + e.getMessage(), e);
        }
    }


    @Override
    public MentorDTO getMentorById(Integer mentorId) {
        try {
            Optional<MentorEntity> searchedMentor = mentorRepository.findById(mentorId);

            if (searchedMentor.isPresent()) {
                MentorEntity mentorEntity = searchedMentor.get();

                // Convert to DTO with sessions and classroom included
                return MentorEntityDTOMapper.map(mentorEntity, false, false);
            }

            throw new MentorException("Mentor not found with ID: " + mentorId);

        } catch (MentorException e) {
            throw e; // Re-throw custom exception without wrapping
        } catch (Exception e) {
            throw new MentorException("Failed to fetch mentor with ID: " + mentorId, e);
        }
    }


    @Override
    @Transactional
    public MentorDTO updateMentor(Integer mentorId, MentorDTO updatedDTO) {
        try {
            MentorEntity existingMentor = mentorRepository.findById((mentorId))
                    .orElseThrow(() -> new MentorException("Mentor not found with ID: " + mentorId));

            // Update only if values are not null or blank
            if (updatedDTO.getFirstName() != null && !updatedDTO.getFirstName().isBlank()) {
                existingMentor.setFirstName(updatedDTO.getFirstName());
            }

            if (updatedDTO.getLastName() != null && !updatedDTO.getLastName().isBlank()) {
                existingMentor.setLastName(updatedDTO.getLastName());
            }

            if (updatedDTO.getAddress() != null && !updatedDTO.getAddress().isBlank()) {
                existingMentor.setAddress(updatedDTO.getAddress());
            }

            if (updatedDTO.getEmail() != null && !updatedDTO.getEmail().isBlank()) {
                existingMentor.setEmail(updatedDTO.getEmail());
            }

            if (updatedDTO.getTitle() != null && !updatedDTO.getTitle().isBlank()) {
                existingMentor.setTitle(updatedDTO.getTitle());
            }

            if (updatedDTO.getSessionFee() != null) {
                existingMentor.setSessionFee(updatedDTO.getSessionFee());
            }

            if (updatedDTO.getProfession() != null && !updatedDTO.getProfession().isBlank()) {
                existingMentor.setProfession(updatedDTO.getProfession());
            }

            if (updatedDTO.getSubject() != null && !updatedDTO.getSubject().isBlank()) {
                existingMentor.setSubject(updatedDTO.getSubject());
            }

            if (updatedDTO.getPhoneNumber() != null && !updatedDTO.getPhoneNumber().isBlank()) {
                existingMentor.setPhoneNumber(updatedDTO.getPhoneNumber());
            }

            if (updatedDTO.getQualification() != null && !updatedDTO.getQualification().isBlank()) {
                existingMentor.setQualification(updatedDTO.getQualification());
            }

            MentorEntity savedMentor = mentorRepository.save(existingMentor);
            return MentorEntityDTOMapper.map(savedMentor, false, false);

        } catch (MentorException e) {
            throw e;
        } catch (Exception e) {
            throw new MentorException("Failed to update mentor with ID: " + mentorId, e);
        }
    }

    @Override
    @Transactional
    public void deleteMentor(Integer mentorId) {
        try {
            MentorEntity existingMentor = mentorRepository.findById(mentorId)
                    .orElseThrow(() -> new MentorException("Mentor not found with ID: " + mentorId));

            mentorRepository.delete(existingMentor);
        } catch (MentorException e) {
            throw e;
        } catch (Exception e) {
            throw new MentorException("Failed to delete mentor with ID: " + mentorId, e);
        }
    }


}
