package com.skillmentor.root.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle DTO field validation errors from @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        }

        return buildDetailedError(
                HttpStatus.BAD_REQUEST,
                "Validation failed",
                "One or more fields have invalid values",
                fieldErrors
        );
    }

    // Handle @RequestParam, @PathVariable, etc. constraint violations
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleConstraintViolation(ConstraintViolationException ex) {
        return buildSimpleError(
                HttpStatus.BAD_REQUEST,
                "Constraint violation",
                ex.getMessage()
        );
    }

    // Custom application-specific exceptions
    @ExceptionHandler(StudentException.class)
    public ResponseEntity<Map<String, Object>> handleStudentException(StudentException ex) {
        return buildSimpleError(HttpStatus.NOT_FOUND, "Student error", ex.getMessage());
    }

    @ExceptionHandler(MentorException.class)
    public ResponseEntity<Map<String, Object>> handleMentorException(MentorException ex) {
        return buildSimpleError(HttpStatus.NOT_FOUND, "Mentor error", ex.getMessage());
    }

    @ExceptionHandler(SessionException.class)
    public ResponseEntity<Map<String, Object>> handleSessionException(SessionException ex) {
        return buildSimpleError(HttpStatus.NOT_FOUND, "Session error", ex.getMessage());
    }

    @ExceptionHandler(AuditException.class)
    public ResponseEntity<Map<String, Object>> handleAuditException(AuditException ex) {
        return buildSimpleError(HttpStatus.INTERNAL_SERVER_ERROR, "Audit error", ex.getMessage());
    }

    @ExceptionHandler(ClassRoomException.class)
    public ResponseEntity<Map<String, Object>> handleClassroomException(ClassRoomException ex) {
        return buildSimpleError(HttpStatus.NOT_FOUND, "Classroom error", ex.getMessage());
    }

    @ExceptionHandler(AdminException.class)
    public ResponseEntity<Map<String, Object>> handleClassroomException(AdminException ex) {
        return buildSimpleError(HttpStatus.NOT_FOUND, "Classroom error", ex.getMessage());
    }

    // Handle bad input arguments
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException ex) {
        return buildSimpleError(HttpStatus.BAD_REQUEST, "Invalid input", ex.getMessage());
    }

    // Catch-all for uncaught exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        return buildSimpleError(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", ex.getMessage());
    }

    @ExceptionHandler(JWTException.class)
    public ResponseEntity<Map<String, Object>> handleJWTExceptionException(JWTException ex) {
        return buildSimpleError(HttpStatus.NOT_FOUND, "Classroom error", ex.getMessage());
    }

    // === Helper Methods ===

    private ResponseEntity<Map<String, Object>> buildSimpleError(HttpStatus status, String error, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now());
        body.put("status", status.value());
        body.put("error", error);
        body.put("message", message);
        return new ResponseEntity<>(body, status);
    }

    private ResponseEntity<Map<String, Object>> buildDetailedError(HttpStatus status, String error, String message, Map<String, ?> details) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now());
        body.put("status", status.value());
        body.put("error", error);
        body.put("message", message);
        body.put("details", details);
        return new ResponseEntity<>(body, status);
    }
}

