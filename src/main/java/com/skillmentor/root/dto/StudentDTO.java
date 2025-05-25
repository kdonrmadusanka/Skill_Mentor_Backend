package com.skillmentor.root.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {
    @JsonProperty("student_id")
    private Integer studentId;
    @NotBlank(message = "First name must not be blank")
    @JsonProperty("first_name")
    private String firstName;
    @NotBlank(message = "Last name must not be blank")
    @JsonProperty("last_name")
    private String lastName;
    @NotBlank(message = "Email must not be blank")
    @JsonProperty("email")
    private String email;
    @NotBlank(message = "Phone number must not be blank")
    @JsonProperty("phone_number")
    private String phoneNumber;
    @NotBlank(message = "Address must not be blank")
    @JsonProperty("address")
    private String address;
    @NotNull(message = "Age must not be null")
    @Min(value = 18, message = "Age must be at least 18")
    @JsonProperty("age")
    private Integer age;

}