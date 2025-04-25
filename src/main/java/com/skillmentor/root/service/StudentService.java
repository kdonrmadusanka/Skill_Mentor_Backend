package com.skillmentor.root.service;

import com.skillmentor.root.dto.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    public StudentDTO createStudent(StudentDTO studentDTO);

}
