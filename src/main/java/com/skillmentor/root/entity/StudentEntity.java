package com.skillmentor.root.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;
    @NotBlank(message = "First name must not be blank")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NotBlank(message = "Last name must not be blank")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Email(message = "Email must be valid")
    @NotBlank(message = "Email must not be blank")
    @Column(name = "email", nullable = false)
    private String email;
    @NotBlank(message = "Phone number must not be blank")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @NotBlank(message = "Address must not be blank")
    @Column(name = "address", nullable = false)
    private String address;
    @NotNull(message = "Age must not be null")
    @Min(value = 1, message = "Age must be at least 1")
    @Column(name = "age", nullable = false)
    private Integer age;
    @OneToMany(mappedBy = "studentEntity", fetch = FetchType.EAGER)
    private List<SessionEntity> sessionEntityList = new ArrayList<>();
}
