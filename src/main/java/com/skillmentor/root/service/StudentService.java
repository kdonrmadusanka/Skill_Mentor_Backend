package com.skillmentor.root.service;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.entity.StudentEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {

    public StudentEntity createStudent(StudentDTO studentDTO);

//    public List<StudentDTO> getAllStudents();
//
//    public List<StudentDTO> getStudentsByAge(Integer age);
//
//    public Optional<StudentDTO> getStudentById(String id);
//
//    public Optional<StudentDTO> updateStudent(String id, StudentDTO studentDTO);
//
//    public Optional<StudentDTO> deleteStudent(String id);

}
