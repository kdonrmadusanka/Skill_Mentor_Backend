package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.repository.StudentRepository;
import com.skillmentor.root.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        StudentDTO newStudent = studentRepository.createStudent(studentDTO);
        return newStudent;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> allStudents = studentRepository.getAllStudents();
        return allStudents;
    }

    @Override
    public List<StudentDTO> getStudentsByAge(Integer age) {
        List<StudentDTO> studentsByAge = studentRepository.getStudentsByAge(age);
        return studentsByAge;
    }
}
