package com.skillmentor.root.controller;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;
import com.skillmentor.root.exception.ClassRoomException;
import com.skillmentor.root.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/classRoom")
public class ClassRoomController {

    @Autowired
    public ClassRoomService classRoomService;

    @PostMapping
    public ResponseEntity<ClassRoomDTO> createClassRoom(@RequestBody ClassRoomDTO classRoomDTO) {
        try {
            ClassRoomDTO created = classRoomService.createClassRoom(classRoomDTO);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (ClassRoomException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // Optional: send error message in body
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRoomDTO> getClassRoomById(@PathVariable("id") Integer id) {
        try {
            ClassRoomDTO classRoomDTO = classRoomService.getClassRoomById(id);
            return new ResponseEntity<>(classRoomDTO, HttpStatus.OK);
        } catch (ClassRoomException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Optionally return e.getMessage()
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassRoomDTO> updateClassRoom(
            @PathVariable("id") Integer id,
            @RequestBody ClassRoomDTO updatedDTO) {
        try {
            ClassRoomDTO updatedClassRoom = classRoomService.updateClassRoom(id, updatedDTO);
            return new ResponseEntity<>(updatedClassRoom, HttpStatus.OK);
        } catch (ClassRoomException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // or BAD_REQUEST based on your needs
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassRoom(@PathVariable("id") Integer id) {
        try {
            classRoomService.deleteClassRoom(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content indicates successful deletion
        } catch (ClassRoomException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
