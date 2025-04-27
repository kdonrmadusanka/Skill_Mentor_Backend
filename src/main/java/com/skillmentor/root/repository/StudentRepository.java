package com.skillmentor.root.repository;

import com.skillmentor.root.dto.StudentDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class StudentRepository {

    public List<StudentDTO> students = new ArrayList<>();

    public StudentDTO createStudent(StudentDTO studentDTO){
        students.add(studentDTO);
        return studentDTO;
    }

    public List<StudentDTO> getAllStudents(){
        return students;
    }

    public List<StudentDTO> getStudentsByAge(Integer age){
        List<StudentDTO> studentsByAge = students.stream().filter(stu -> age == null || stu.getAge().equals(age)).toList();
        return studentsByAge;
    }

    public Optional<StudentDTO> getStudentById(String id){
        Optional<StudentDTO> searchStudent = students.stream().filter(stu -> stu.getStudentId().equals(id)).findFirst();
        return searchStudent;
    }

}
