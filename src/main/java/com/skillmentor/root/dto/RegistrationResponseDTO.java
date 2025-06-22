package com.skillmentor.root.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationResponseDTO {
    private StudentDTO student;
    private AdminDTO admin;
    private MentorDTO mentor;
    private String token;

    public RegistrationResponseDTO(StudentDTO student, String token){
        this.student = student;
        this.token = token;
    }

    public RegistrationResponseDTO(AdminDTO admin, String token){
        this.admin = admin;
        this.token = token;
    }

    public RegistrationResponseDTO(MentorDTO mentor, String token){
        this.mentor = mentor;
        this.token = token;
    }

}
