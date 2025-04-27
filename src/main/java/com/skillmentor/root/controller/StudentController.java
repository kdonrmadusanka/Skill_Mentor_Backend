package com.skillmentor.root.controller;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/student")
public class StudentController {

    public StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO newStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List<StudentDTO> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<List<StudentDTO>> getStudentsById(@RequestParam(required = false) Integer age){
        List<StudentDTO> studentsById = studentService.getStudentsByAge(age);
        return new ResponseEntity<>(studentsById, HttpStatus.OK);
    }



}
