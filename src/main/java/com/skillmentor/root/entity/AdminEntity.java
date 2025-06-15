package com.skillmentor.root.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity implements UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer adminId;

    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First name must not be blank")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    @NotBlank(message = "Username must not be blank")
    private String username;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password must not be blank")
    private String password;

    @Column(name = "phone_number", nullable = false)
    @NotBlank(message = "Phone number must not be blank")
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    @NotBlank(message = "Address must not be blank")
    private String address;

    @Column(name = "admin_code", nullable = false)
    @NotNull(message = "Admin code must not be null")
    private Integer adminCode;

    // === Role Relationship ===
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    @JsonBackReference
    private RoleEntity role;

    @Override
    public Integer getId() {
        return adminId;
    }

    @Override
    public RoleEntity getRole() {
        return role;
    }
}
