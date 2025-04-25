package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl {

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentDTO createStudent(StudentDTO studentDTO){
        StudentDTO newStudent = studentRepository.createStudent(studentDTO);
        return newStudent;
    }

}
