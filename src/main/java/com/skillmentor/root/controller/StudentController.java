package com.skillmentor.root.controller;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.entity.StudentEntity;
import com.skillmentor.root.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    public StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentDTO studentDTO){
        StudentEntity newStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<StudentEntity>> getAllStudents(){
        List<StudentEntity> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/age")
    public ResponseEntity<List<StudentEntity>> getStudentsById(@RequestParam(required = false) Integer age){
        List<StudentEntity> studentsById = studentService.getStudentsByAge(age);
        return new ResponseEntity<>(studentsById, HttpStatus.OK);
    }

    @GetMapping("/{ObjectId}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer ObjectId){
        StudentEntity studentById = studentService.getStudentById(ObjectId);

        if(studentById != null) {
            return new ResponseEntity<>(studentById, HttpStatus.OK);
        }
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Student with id - '" + ObjectId + "' is not exists");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO){
//        Optional<StudentDTO> updatedStudent = studentService.updateStudent(id, studentDTO);
//
//        if(updatedStudent.isPresent()){
//            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
//        }
//        Map<String, String> errorResponse = new HashMap<>();
//        errorResponse.put("error", "The student does not exist");
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteStudent(@PathVariable String id){
//        Optional<StudentDTO> deletedStudent = studentService.deleteStudent(id);
//
//        if(deletedStudent.isPresent()){
//            return new ResponseEntity<>(deletedStudent, HttpStatus.OK);
//        }
//        Map<String, String> errorResponse = new HashMap<>();
//        errorResponse.put("error", "The student does not exist");
//        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
//    }

}
