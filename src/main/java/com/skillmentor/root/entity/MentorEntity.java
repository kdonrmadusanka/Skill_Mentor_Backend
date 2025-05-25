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
@Table(name = "mentor")
@NoArgsConstructor
@AllArgsConstructor
public class MentorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_id")
    private Integer mentorId;
    @NotBlank(message = "First name must not be blank")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NotBlank(message = "Last name must not be blank")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @NotBlank(message = "Address must not be blank")
    @Column(name = "address", nullable = false)
    private String address;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email must not be blank")
    @Column(name = "email", nullable = false)
    private String email;
    @NotBlank(message = "Title must not be blank")
    @Column(name = "title", nullable = false)
    private String title;
    @NotBlank(message = "Phone number must not be blank")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @NotBlank(message = "Profession must not be blank")
    @Column(name = "profession", nullable = false)
    private String profession;
    @NotNull(message = "Session fee must not be null")
    @Min(value = 0, message = "Session fee must be non-negative")
    @Column(name = "session_fee", nullable = false)
    private Double sessionFee;
    @NotBlank(message = "Subject must not be blank")
    @Column(name = "subject", nullable = false)
    private String subject;
    @NotBlank(message = "Qualification must not be blank")
    @Column(name = "qualification", nullable = false)
    private String qualification;
    @OneToMany(mappedBy = "mentorEntity", fetch = FetchType.EAGER)
    private List<SessionEntity> sessionEntityList = new ArrayList<>();
}
