package com.skillmentor.root.controller;

import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.entity.MentorEntity;
import com.skillmentor.root.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/mentor")
public class MentorController {

    @Autowired
    MentorService mentorService;

    @PostMapping()
    public ResponseEntity<?> createMentor(@RequestBody MentorDTO mentorDTO){
        MentorDTO newMentor = mentorService.createMentor(mentorDTO);

        if (newMentor != null){
            return new ResponseEntity<>(newMentor, HttpStatus.CREATED);
        }
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Mentor has not created");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}