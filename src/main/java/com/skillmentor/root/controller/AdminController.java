package com.skillmentor.root.controller;

import com.skillmentor.root.dto.AdminDTO;
import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.exception.MentorException;
import com.skillmentor.root.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> getAdminById(@PathVariable("id") Integer id) {
        try {
            AdminDTO adminDTO = adminService.getAdminById(id);
            return new ResponseEntity<>(mentorDTO, HttpStatus.OK);
        } catch (MentorException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Optionally include e.getMessage()
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
