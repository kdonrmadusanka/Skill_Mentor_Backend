package com.skillmentor.root.service;

import com.skillmentor.root.dto.StudentDTO;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {

    public StudentDTO createStudent(StudentDTO studentDTO);

    public List<StudentDTO> getAllStudents();

    public List<StudentDTO> getStudentsByAge(Integer age);

    public Optional<StudentDTO> getStudentById(String id);

}
