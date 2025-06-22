package com.skillmentor.root.service;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public StudentDTO createStudent(StudentDTO studentDTO);

    public StudentDTO getStudentById(Integer studentId);

    public StudentDTO updateStudent(Integer studentId, StudentDTO updatedDTO);

    public void deleteStudent(Integer studentId);
}
