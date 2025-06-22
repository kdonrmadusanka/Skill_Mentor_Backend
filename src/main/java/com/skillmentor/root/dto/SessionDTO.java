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
public class SessionDTO {
    @JsonProperty("session_id")
    private Integer sessionId;
    @NotNull(message = "Student must not be null")
    @JsonProperty(value = "student", access = JsonProperty.Access.WRITE_ONLY)
    private Integer studentId;
    @JsonProperty(value = "studentClass", access = JsonProperty.Access.READ_ONLY)
    private StudentDTO studentDTO;
    @NotNull(message = "Classroom must not be null")
    @JsonProperty(value = "class_room", access = JsonProperty.Access.WRITE_ONLY)
    private Integer classRoomId;
    @JsonProperty(value = "classRoomClass", access = JsonProperty.Access.READ_ONLY)
    private ClassRoomDTO classRoomDTO;
    @NotNull(message = "Mentor must not be null")
    @JsonProperty(value = "mentor", access = JsonProperty.Access.WRITE_ONLY)
    private Integer mentorId;
    @JsonProperty(value = "mentorClass", access = JsonProperty.Access.READ_ONLY)
    private MentorDTO mentorDTO;
    @NotBlank(message = "Topic must not be blank")
    @JsonProperty("topic")
    private String topic;
    @NotNull(message = "Start time must not be null")
    @JsonProperty("start_time")
    private Instant startTime;
    @NotNull(message = "End time must not be null")
    @JsonProperty("end_time")
    private Instant endTime;
}
