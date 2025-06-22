package com.skillmentor.root.config;

import com.skillmentor.root.entity.RoleEntity;
import com.skillmentor.root.repository.MentorRepository;
import com.skillmentor.root.repository.RoleRepository;
import com.skillmentor.root.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) {
        List<String> roles = List.of("ROLE_STUDENT", "ROLE_MENTOR", "ROLE_ADMIN");

        for (String roleName : roles) {
            roleRepository.findByName(roleName).ifPresentOrElse(
                    r -> {}, // already exists
                    () -> roleRepository.save(new RoleEntity(null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), roleName))
            );
        }
    }

}
