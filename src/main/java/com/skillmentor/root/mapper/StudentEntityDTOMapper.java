package com.skillmentor.root.mapper;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.entity.StudentEntity;

public class StudentEntityDTOMapper {

    public static StudentDTO map(StudentEntity studentEntity){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(studentEntity.getStudentId());
        studentDTO.setFirstName(studentEntity.getFirstName());
        studentDTO.setLastname(studentEntity.getLastName());
        studentDTO.setEmail(studentEntity.getEmail());
        studentDTO.setPhoneNumber(studentEntity.getPhoneNumber());
        studentDTO.setAddress(studentEntity.getAddress());
        studentDTO.setAge(studentEntity.getAge());
        return studentDTO;
    }

    public static StudentEntity map(StudentDTO studentDTO) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(studentDTO.getStudentId());
        studentEntity.setFirstName(studentDTO.getFirstName());
        studentEntity.setLastName(studentDTO.getLastName());
        studentEntity.setEmail(studentDTO.getEmail());
        studentEntity.setPhoneNumber(studentDTO.getPhoneNumber());
        studentEntity.setAddress(studentDTO.getAddress());
        studentEntity.setAge(studentDTO.getAge());
        return studentEntity;
    }

}
