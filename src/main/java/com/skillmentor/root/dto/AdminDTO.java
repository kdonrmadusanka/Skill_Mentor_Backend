package com.skillmentor.root.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    @JsonProperty("first_name")
    @NotBlank(message = "First name must not be blank")
    private String firstName;

    @JsonProperty("last_name")
    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    @JsonProperty("email")
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email must not be blank")
    private String email;

    @JsonProperty("username")
    @NotBlank(message = "Username must not be blank")
    private String username;

    @JsonProperty("password")
    @NotBlank(message = "Password must not be blank")
    private String password;

    @JsonProperty("phone_number")
    @NotBlank(message = "Phone number must not be blank")
    private String phoneNumber;

    @JsonProperty("address")
    @NotBlank(message = "Address must not be blank")
    private String address;

    @JsonProperty("admin_code")
    @NotNull(message = "Admin code must not be null")
    private Integer adminCode;

}
