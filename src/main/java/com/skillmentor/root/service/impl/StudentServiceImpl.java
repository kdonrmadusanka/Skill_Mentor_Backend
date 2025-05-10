package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.entity.StudentEntity;
import com.skillmentor.root.mapper.StudentEntityDTOMapper;
import com.skillmentor.root.repository.StudentRepository;
import com.skillmentor.root.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentEntity createStudent(StudentDTO studentDTO) {
        StudentEntity newStudent = StudentEntityDTOMapper.map(studentDTO);
        studentRepository.save(newStudent);
        return newStudent;
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> allStudents = studentRepository.findAll();
        return allStudents;
    }

    @Override
    public List<StudentEntity> getStudentsByAge(Integer age) {
        if(age == null){
            return Collections.emptyList();
        }
        List<StudentEntity> allStudents = studentRepository.findAll();
        List<StudentEntity> studentsByAge = allStudents.stream().filter(stu -> age.equals(stu.getAge())).collect(Collectors.toList());
        return studentsByAge;
    }

    @Override
    public StudentEntity getStudentById(Integer ObjectId) {
        if(ObjectId == null){
            return null;
        }
        Optional<StudentEntity> studentById = studentRepository.findById(ObjectId);
        return studentById.orElse(null);
    }

//    @Override
//    public Optional<StudentDTO> updateStudent(String id, StudentDTO studentDTO) {
//        Optional<StudentDTO> searchStudent = getStudentById(id);
//
//        if (searchStudent.isPresent()){
//            StudentDTO updateStudent = searchStudent.get();
//            if (studentDTO.getFirstName() != null){
//                updateStudent.setFirstName(studentDTO.getFirstName());
//            }
//
//            if (studentDTO.getLastname()!= null){
//                updateStudent.setLastname(studentDTO.getLastname());
//            }
//
//            if (studentDTO.getAge() != null){
//                updateStudent.setAge(studentDTO.getAge());
//            }
//
//            if (studentDTO.getEmail() != null){
//                updateStudent.setEmail(studentDTO.getEmail());
//            }
//
//            if (studentDTO.getPhoneNumber() != null){
//                updateStudent.setPhoneNumber(studentDTO.getPhoneNumber());
//            }
//
//            if (studentDTO.getAddress() != null) {
//                updateStudent.setAddress(studentDTO.getAddress());
//            }
//
//            Optional<StudentDTO> updatedStudent = studentRepository.updateStudent(updateStudent);
//            return updatedStudent;
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<StudentDTO> deleteStudent(String id) {
//        Optional<StudentDTO> deletedStudent = studentRepository.deleteStudent(id);
//        if(deletedStudent.isPresent()){
//            return deletedStudent;
//        }
//        return Optional.empty();
//    }
//
}
