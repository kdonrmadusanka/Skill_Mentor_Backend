package com.skillmentor.root.service.impl;

import com.skillmentor.root.entity.RoleEntity;
import com.skillmentor.root.repository.RoleRepository;
import com.skillmentor.root.service.RoleService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    private final Map<String, RoleEntity> roleCache = new HashMap<>();

    @Override
    @PostConstruct
    public void initializeRoles() {

        List<RoleEntity> roles = roleRepository.findAll();

        for (RoleEntity role : roles) {
            roleCache.put(role.getName(), role);
        }

    }

    public RoleEntity getRoleByName(String roleName) {

        RoleEntity role = roleCache.get(roleName);
        if (role == null) {
            throw new RuntimeException("Role not found: " + roleName);
        }
        return role;

    }
}
