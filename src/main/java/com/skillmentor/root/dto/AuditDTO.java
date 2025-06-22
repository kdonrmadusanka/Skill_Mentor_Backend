package com.skillmentor.root.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditDTO {
    @JsonProperty("session_id")
    private Integer sessionId;
    @NotNull(message = "Student ID must not be null")
    @JsonProperty("student_id")
    private Integer studentId;
    @NotBlank(message = "Student first name must not be blank")
    @JsonProperty("student_first_name")
    private String studentFirstName;
    @NotBlank(message = "Student last name must not be blank")
    @JsonProperty("student_last_name")
    private String studentLastName;
    @NotBlank(message = "Student email must not be blank")
    @JsonProperty("student_email")
    private String studentEmail;
    @NotBlank(message = "Student phone number must not be blank")
    @JsonProperty("student_phone_number")
    private String studentPhoneNumber;
    @NotBlank(message = "Class title must not be blank")
    @JsonProperty("class_title")
    private String classTitle;
    @NotNull(message = "Mentor ID must not be null")
    @JsonProperty("mentor_id")
    private Integer mentorId;
    @NotBlank(message = "Mentor first name must not be blank")
    @JsonProperty("mentor_first_name")
    private String mentorFirstName;
    @NotBlank(message = "Mentor last name must not be blank")
    @JsonProperty("mentor_last_name")
    private String mentorLastName;
    @NotBlank(message = "Mentor phone number must not be blank")
    @JsonProperty("mentor_phone_number")
    private String mentorPhoneNumber;
    @NotNull(message = "Fee must not be null")
    @JsonProperty("fee")
    private Double fee;
    @NotNull(message = "Start time must not be null")
    @JsonProperty("start_time")
    private Instant startTime;
    @NotNull(message = "End time must not be null")
    @JsonProperty("end_time")
    private Instant endTime;
    @NotBlank(message = "Topic must not be blank")
    @JsonProperty("topic")
    private String topic;
}
