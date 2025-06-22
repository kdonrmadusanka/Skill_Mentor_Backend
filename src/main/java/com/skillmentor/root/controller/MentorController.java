package com.skillmentor.root.controller;

import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.exception.MentorException;
import com.skillmentor.root.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping("/{id}")
    public ResponseEntity<MentorDTO> getMentorById(@PathVariable("id") Integer id) {
        try {
            MentorDTO mentorDTO = mentorService.getMentorById(id);
            return new ResponseEntity<>(mentorDTO, HttpStatus.OK);
        } catch (MentorException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Optionally include e.getMessage()
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentorDTO> updateMentor(@PathVariable("id") Integer id, @RequestBody MentorDTO updatedDTO) {
        try {
            MentorDTO updatedMentor = mentorService.updateMentor(id, updatedDTO);
            return new ResponseEntity<>(updatedMentor, HttpStatus.OK);
        } catch (MentorException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Could include e.getMessage() in body if needed
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMentor(@PathVariable("id") Integer id) {
        try {
            mentorService.deleteMentor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 No Content on successful deletion
        } catch (MentorException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);    // 404 if mentor not found
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}