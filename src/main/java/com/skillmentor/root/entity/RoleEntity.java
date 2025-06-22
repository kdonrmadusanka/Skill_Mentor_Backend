package com.skillmentor.root.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "role_id")
        private Integer roleId;

        @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
        @JsonManagedReference
        List<MentorEntity> mentorEntities = new ArrayList<>();

        @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
        @JsonManagedReference
        List<StudentEntity> studentEntities = new ArrayList<>();

        @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
        @JsonManagedReference
        List<AdminEntity> adminEntities = new ArrayList<>();

        @Column(name = "name", nullable = false, unique = true)
        private String name; // e.g., ROLE_STUDENT, ROLE_MENTOR, ROLE_ADMIN

}
