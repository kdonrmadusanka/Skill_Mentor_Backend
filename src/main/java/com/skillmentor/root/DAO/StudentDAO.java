package com.skillmentor.root.DAO;

import com.skillmentor.root.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    public StudentDTO createStudent(StudentDTO studentDTO);

    public List<StudentDTO> getAllStudents();

    public List<StudentDTO> getStudentsByAge(Integer age);

    public Optional<StudentDTO> getStudentById(String id);

    public Optional<StudentDTO> updateStudent(String id, StudentDTO studentDTO);

    public Optional<StudentDTO> deleteStudent(String id);
}
