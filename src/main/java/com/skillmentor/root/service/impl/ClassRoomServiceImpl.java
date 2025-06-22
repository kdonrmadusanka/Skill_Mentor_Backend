package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;
import com.skillmentor.root.exception.ClassRoomException;
import com.skillmentor.root.mapper.ClassRoomEntityDTOMapper;
import com.skillmentor.root.repository.ClassRoomRepository;
import com.skillmentor.root.repository.MentorRepository;
import com.skillmentor.root.service.ClassRoomService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    public ClassRoomRepository classRoomRepository;

    @Autowired
    public MentorRepository mentorRepository;


    @Override
    @Transactional
    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO) {
        Integer mentorId = classRoomDTO.getMentorId();

        if (mentorId == null) {
            throw new ClassRoomException("mentorId must not be null.");
        }

        try {
            MentorEntity mentor = mentorRepository.findById(mentorId)
                    .orElseThrow(() -> new ClassRoomException("Mentor not found with ID: " + mentorId));

            ClassRoomEntity newClassRoom = ClassRoomEntityDTOMapper.map(classRoomDTO, mentor);
            ClassRoomEntity savedClassRoom = classRoomRepository.save(newClassRoom);

            return ClassRoomEntityDTOMapper.map(savedClassRoom, false, false);

        } catch (ClassRoomException e) {
            throw e; // Rethrow known domain-specific exception
        } catch (Exception e) {
            throw new ClassRoomException("Failed to create classroom: " + e.getMessage(), e);
        }
    }

    @Override
    public ClassRoomDTO getClassRoomById(Integer classRoomId) {
        try {
            Optional<ClassRoomEntity> searchedClassRoom = classRoomRepository.findById(classRoomId);

            if (searchedClassRoom.isPresent()) {
                return ClassRoomEntityDTOMapper.map(searchedClassRoom.get(), false, false);
            }

            throw new ClassRoomException("ClassRoom not found with ID: " + classRoomId);

        } catch (NumberFormatException e) {
            throw new ClassRoomException("Invalid classroom ID format: " + classRoomId, e);
        } catch (ClassRoomException e) {
            throw e; // rethrow known domain-specific exception
        } catch (Exception e) {
            throw new ClassRoomException("Failed to fetch classroom: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public ClassRoomDTO updateClassRoom(Integer classRoomId, ClassRoomDTO updatedDTO) {
        try {
            ClassRoomEntity existingClassRoom = classRoomRepository.findById(classRoomId)
                    .orElseThrow(() -> new ClassRoomException("Classroom not found with ID: " + classRoomId));

            // Update only provided (non-null / non-blank) fields
            if (updatedDTO.getTitle() != null && !updatedDTO.getTitle().isBlank()) {
                existingClassRoom.setTitle(updatedDTO.getTitle());
            }

            if (updatedDTO.getEnrolledStudentCount() != null) {
                existingClassRoom.setEnrolledStudentCount(updatedDTO.getEnrolledStudentCount());
            }

            // Update mentor only if mentorId is provided (non-null)
            if (updatedDTO.getMentorId() != null) {
                MentorEntity mentor = mentorRepository.findById(updatedDTO.getMentorId())
                        .orElseThrow(() -> new ClassRoomException("Mentor not found with ID: " + updatedDTO.getMentorId()));
                existingClassRoom.setMentor(mentor);
            }

            ClassRoomEntity savedClassRoom = classRoomRepository.save(existingClassRoom);
            return ClassRoomEntityDTOMapper.map(savedClassRoom, false, false);

        } catch (ClassRoomException e) {
            throw e; // Re-throw domain-specific exception
        } catch (Exception e) {
            throw new ClassRoomException("Failed to update classroom: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void deleteClassRoom(Integer classRoomId) {
        try {
            ClassRoomEntity existingClassRoom = classRoomRepository.findById(classRoomId)
                    .orElseThrow(() -> new ClassRoomException("Classroom not found with ID: " + classRoomId));

            classRoomRepository.delete(existingClassRoom);

        } catch (ClassRoomException e) {
            throw e; // Re-throw domain-specific exception
        } catch (Exception e) {
            throw new ClassRoomException("Failed to delete classroom: " + e.getMessage(), e);
        }
    }

}
