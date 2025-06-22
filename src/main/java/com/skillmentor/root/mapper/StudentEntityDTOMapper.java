package com.skillmentor.root.mapper;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.entity.StudentEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentEntityDTOMapper {

    // DTO to Entity
    public static StudentEntity map(StudentDTO studentDTO) {
        if (studentDTO == null) return null;

        StudentEntity entity = new StudentEntity();
        entity.setStudentId(studentDTO.getStudentId());
        entity.setFirstName(studentDTO.getFirstName());
        entity.setLastName(studentDTO.getLastName());
        entity.setEmail(studentDTO.getEmail());
        entity.setPhoneNumber(studentDTO.getPhoneNumber());
        entity.setAddress(studentDTO.getAddress());
        entity.setAge(studentDTO.getAge());

        // sessionEntityList will be handled elsewhere (e.g. in service logic)
        return entity;
    }

    // Entity to DTO
    public static StudentDTO map(StudentEntity studentEntity, boolean skipSessions) {
        if (studentEntity == null) return null;

        StudentDTO dto = new StudentDTO();
        dto.setStudentId(studentEntity.getStudentId());
        dto.setFirstName(studentEntity.getFirstName());
        dto.setLastName(studentEntity.getLastName());
        dto.setEmail(studentEntity.getEmail());
        dto.setPhoneNumber(studentEntity.getPhoneNumber());
        dto.setAddress(studentEntity.getAddress());
        dto.setAge(studentEntity.getAge());

        if (!skipSessions) {
            dto.setSessionDTO(
                    Optional.ofNullable(studentEntity.getSessionEntityList())
                            .orElse(List.of())
                            .stream()
                            .map(session -> SessionEntityDTOMapper.map(session, true, true, true)) // skipStudent = true
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }
}
