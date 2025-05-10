package com.skillmentor.root.service;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public StudentEntity createStudent(StudentDTO studentDTO);

    public List<StudentEntity> getAllStudents();

    public List<StudentEntity> getStudentsByAge(Integer age);

    public StudentEntity getStudentById(Integer ObjectId);
//
//    public Optional<StudentDTO> updateStudent(String id, StudentDTO studentDTO);
//
//    public Optional<StudentDTO> deleteStudent(String id);

}
