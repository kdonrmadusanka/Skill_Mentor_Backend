package com.skillmentor.root.controller;

import com.skillmentor.root.dto.*;
import com.skillmentor.root.exception.UserRegistrationException;
import com.skillmentor.root.service.AdminService;
import com.skillmentor.root.service.MentorService;
import com.skillmentor.root.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private MentorService mentorService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody User registrationDTO) {
        try {
            return switch (registrationDTO.getUserType()) {
                case MENTOR -> {
                    MentorDTO createdMentor = mentorService.createMentor(registrationDTO.getMentorDTO());
                    yield new ResponseEntity<>(createdMentor, HttpStatus.CREATED);
                }
                case STUDENT -> {
                    StudentDTO createdStudent = studentService.createStudent(registrationDTO.getStudentDTO());
                    yield new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
                }
                case ADMIN -> {
                    RegistrationResponseDTO createdAdmin = adminService.createAdmin(registrationDTO.getAdminDTO());
                    yield new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
                }
                default -> throw new UserRegistrationException("Unsupported user type");
            };
        } catch (UserRegistrationException e) {
            log.error("User registration error: {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Server error during user registration", e);
            return new ResponseEntity<>("Server error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
