package com.skillmentor.root.service.impl;

import com.skillmentor.root.DAO.StudentDAO;
import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.repository.StudentRepository;
import com.skillmentor.root.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        StudentDTO newStudent = studentDAO.createStudent(studentDTO);
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

    @Override
    public Optional<StudentDTO> getStudentById(String id) {
        Optional<StudentDTO> studentById = studentRepository.getStudentById(id);
        return studentById;
    }

    @Override
    public Optional<StudentDTO> updateStudent(String id, StudentDTO studentDTO) {
        Optional<StudentDTO> searchStudent = getStudentById(id);

        if (searchStudent.isPresent()){
            StudentDTO updateStudent = searchStudent.get();
            if (studentDTO.getFirstName() != null){
                updateStudent.setFirstName(studentDTO.getFirstName());
            }

            if (studentDTO.getLastname()!= null){
                updateStudent.setLastname(studentDTO.getLastname());
            }

            if (studentDTO.getAge() != null){
                updateStudent.setAge(studentDTO.getAge());
            }

            if (studentDTO.getEmail() != null){
                updateStudent.setEmail(studentDTO.getEmail());
            }

            if (studentDTO.getPhoneNumber() != null){
                updateStudent.setPhoneNumber(studentDTO.getPhoneNumber());
            }

            if (studentDTO.getAddress() != null) {
                updateStudent.setAddress(studentDTO.getAddress());
            }

            Optional<StudentDTO> updatedStudent = studentRepository.updateStudent(updateStudent);
            return updatedStudent;
        }
        return Optional.empty();
    }

    @Override
    public Optional<StudentDTO> deleteStudent(String id) {
        Optional<StudentDTO> deletedStudent = studentRepository.deleteStudent(id);
        if(deletedStudent.isPresent()){
            return deletedStudent;
        }
        return Optional.empty();
    }

}
