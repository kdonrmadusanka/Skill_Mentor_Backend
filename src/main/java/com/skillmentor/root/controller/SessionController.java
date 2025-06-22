package com.skillmentor.root.controller;

import com.skillmentor.root.dto.SessionDTO;
import com.skillmentor.root.exception.SessionException;
import com.skillmentor.root.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping
    public ResponseEntity<SessionDTO> createSession(@RequestBody SessionDTO sessionDTO) {
        try {
            SessionDTO createdSession = sessionService.createSession(sessionDTO);
            return new ResponseEntity<>(createdSession, HttpStatus.CREATED); // 201 Created
        } catch (SessionException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // Optionally send e.getMessage()
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionDTO> getSessionById(@PathVariable("id") Integer id) {
        try {
            SessionDTO sessionDTO = sessionService.getSessionById(id);
            return new ResponseEntity<>(sessionDTO, HttpStatus.OK);
        } catch (SessionException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Session not found
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SessionDTO> updateSession(@PathVariable("id") Integer id, @RequestBody SessionDTO sessionDTO) {
        try {
            SessionDTO updatedSession = sessionService.updateSession(id, sessionDTO);
            return new ResponseEntity<>(updatedSession, HttpStatus.OK);
        } catch (SessionException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Session or related entities not found
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSessionById(@PathVariable("id") Integer id) {
        try {
            sessionService.deleteSessionById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 No Content on successful deletion
        } catch (SessionException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Session not found
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
