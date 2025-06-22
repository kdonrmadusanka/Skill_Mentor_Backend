package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.entity.RoleEntity;
import com.skillmentor.root.entity.StudentEntity;
import com.skillmentor.root.exception.MentorException;
import com.skillmentor.root.exception.StudentException;
import com.skillmentor.root.mapper.StudentEntityDTOMapper;
import com.skillmentor.root.repository.RoleRepository;
import com.skillmentor.root.repository.StudentRepository;
import com.skillmentor.root.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public StudentDTO createStudent(StudentDTO studentDTO) {
        try {
            // Validate input
            if (studentDTO == null) {
                throw new StudentException("Student data cannot be null");
            }
            if (studentDTO.getPassword() == null || studentDTO.getPassword().trim().isEmpty()) {
                throw new StudentException("Password cannot be null or empty");
            }

            // Encode password
            studentDTO.setPassword(passwordEncoder.encode(studentDTO.getPassword()));

            // Find role
            RoleEntity studentRole = roleRepository.findByName("ROLE_STUDENT")
                    .orElseThrow(() -> new StudentException("ROLE_STUDENT not found in Role table"));

            // Map DTO to Entity
            StudentEntity newStudent = StudentEntityDTOMapper.map(studentDTO);
            if (newStudent == null) {
                throw new StudentException("Failed to map StudentDTO to StudentEntity");
            }

            newStudent.setRole(studentRole);

            // Save entity
            StudentEntity savedStudent = studentRepository.save(newStudent);

            // Map Entity to DTO
            StudentDTO result = StudentEntityDTOMapper.map(savedStudent, false); // skip sessionDTOs
            if (result == null) {
                throw new StudentException("Failed to map StudentEntity to StudentDTO");
            }

            return result;
        } catch (StudentException e) {
            throw e;
        } catch (Exception e) {
            throw new StudentException("Failed to create student: " + e.getMessage(), e);
        }
    }



    @Override
    public StudentDTO getStudentById(Integer studentId) {
        try {
            StudentEntity studentEntity = studentRepository.findById(studentId)
                    .orElseThrow(() -> new StudentException("Student not found with ID: " + studentId));
            return StudentEntityDTOMapper.map(studentEntity, false); // include sessions in response
        } catch (MentorException e) {
            throw e;
        } catch (Exception e) {
            throw new StudentException("Failed to fetch student: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public StudentDTO updateStudent(Integer studentId, StudentDTO updatedDTO) {
        try {
            StudentEntity existingStudent = studentRepository.findById(studentId)
                    .orElseThrow(() -> new StudentException("Student not found with ID: " + studentId));

            // Update only non-null and valid fields
            if (updatedDTO.getFirstName() != null && !updatedDTO.getFirstName().isBlank()) {
                existingStudent.setFirstName(updatedDTO.getFirstName());
            }

            if (updatedDTO.getLastName() != null && !updatedDTO.getLastName().isBlank()) {
                existingStudent.setLastName(updatedDTO.getLastName());
            }

            if (updatedDTO.getEmail() != null && !updatedDTO.getEmail().isBlank()) {
                existingStudent.setEmail(updatedDTO.getEmail());
            }

            if (updatedDTO.getPhoneNumber() != null && !updatedDTO.getPhoneNumber().isBlank()) {
                existingStudent.setPhoneNumber(updatedDTO.getPhoneNumber());
            }

            if (updatedDTO.getAddress() != null && !updatedDTO.getAddress().isBlank()) {
                existingStudent.setAddress(updatedDTO.getAddress());
            }

            if (updatedDTO.getAge() != null) {
                if (updatedDTO.getAge() < 18) {
                    throw new StudentException("Age must be at least 18");
                }
                existingStudent.setAge(updatedDTO.getAge());
            }

            StudentEntity savedStudent = studentRepository.save(existingStudent);
            return StudentEntityDTOMapper.map(savedStudent, false);

        } catch (StudentException e){
            throw e;
        } catch (Exception e) {
            throw new StudentException("Failed to update student: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void deleteStudent(Integer studentId) {
        try {
            StudentEntity existingStudent = studentRepository.findById(studentId)
                    .orElseThrow(() -> new StudentException("Student not found with ID: " + studentId));

            studentRepository.delete(existingStudent);
        } catch (StudentException e) {
            throw e;
        } catch (Exception e) {
            throw new StudentException("Failed to delete student: " + e.getMessage(), e);
        }
    }

}
