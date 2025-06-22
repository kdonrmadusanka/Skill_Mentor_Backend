package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.AdminDTO;
import com.skillmentor.root.dto.RegistrationResponseDTO;
import com.skillmentor.root.entity.AdminEntity;
import com.skillmentor.root.entity.RoleEntity;
import com.skillmentor.root.exception.AdminException;
import com.skillmentor.root.exception.MentorException;
import com.skillmentor.root.mapper.AdminEntityDTOMapper;
import com.skillmentor.root.repository.AdminRepository;
import com.skillmentor.root.repository.RoleRepository;
import com.skillmentor.root.service.AdminService;
import com.skillmentor.root.service.RoleService;
import com.skillmentor.root.util.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public RegistrationResponseDTO createAdmin(AdminDTO adminDTO) {
        try {
            if (adminDTO == null) {
                throw new AdminException("Admin data cannot be null");
            }
            if (adminDTO.getPassword() == null || adminDTO.getPassword().trim().isEmpty()) {
                throw new AdminException("Password cannot be null or empty");
            }

            adminDTO.setPassword(passwordEncoder.encode(adminDTO.getPassword()));

            RoleEntity adminRole = roleService.getRoleByName("ROLE_ADMIN");

            AdminEntity newAdmin = AdminEntityDTOMapper.map(adminDTO);
            newAdmin.setRole(adminRole);
            AdminEntity savedAdmin = adminRepository.save(newAdmin);

            String token = jwtUtil.generateJWTToken(savedAdmin, newAdmin.getUsername());

            AdminDTO mappedAdmin = AdminEntityDTOMapper.map(savedAdmin);

            return new RegistrationResponseDTO(mappedAdmin, token);

        } catch (AdminException e) {
            log.error("Admin creation error: {}", e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error("Failed to create admin", e);
            throw new AdminException("Failed to create admin: " + e.getMessage(), e);
        }

    }

    @Override
    public AdminDTO getAdminById(Integer id) {
        return null;
    }
}
