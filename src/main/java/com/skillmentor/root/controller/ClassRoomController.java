package com.skillmentor.root.controller;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;
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

    @PostMapping()
    public ResponseEntity<?> createClassRoom(@RequestBody ClassRoomDTO classRoomDTO){
        if(classRoomDTO != null){
            return new ResponseEntity<>(classRoomService.createClassRoom(classRoomDTO), HttpStatus.CREATED);
        }
        Map<String, String> errorEntity = new HashMap<>();
        errorEntity.put("error", "No class room has created");
        return new ResponseEntity<>(errorEntity, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMentorById(@PathVariable String id){
        try{
            ClassRoomDTO classRoomById = classRoomService.getClassRoomById(id);
            return new ResponseEntity<>(classRoomById, HttpStatus.OK);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
