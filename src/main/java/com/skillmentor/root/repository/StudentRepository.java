package com.skillmentor.root.repository;

import com.skillmentor.root.dto.StudentDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepository {

    public List<StudentDTO> students = new ArrayList<>();

    public StudentDTO createStudent(StudentDTO studentDTO){
        students.add(studentDTO);
        return studentDTO;
    }

}
