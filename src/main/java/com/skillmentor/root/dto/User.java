package com.skillmentor.root.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skillmentor.root.enums.UserType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
    @NotNull(message = "User type must be provided")
    @JsonProperty("user_type")
    private UserType userType;

    @JsonProperty("admin")
    private AdminDTO adminDTO;

    @JsonProperty("mentor")
    private MentorDTO mentorDTO;

    @JsonProperty("student")
    private StudentDTO studentDTO;
}
