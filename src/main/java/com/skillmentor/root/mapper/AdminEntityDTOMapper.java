package com.skillmentor.root.mapper;

import com.skillmentor.root.dto.AdminDTO;
import com.skillmentor.root.entity.AdminEntity;
import com.skillmentor.root.entity.RoleEntity;

public class AdminEntityDTOMapper {
    public static AdminEntity map(AdminDTO dto) {
        if (dto == null) return null;

        AdminEntity entity = new AdminEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setAddress(dto.getAddress());
        entity.setAdminCode(dto.getAdminCode());

        return entity;
    }

    // Entity to DTO (role skipped optionally)
    public static AdminDTO map(AdminEntity entity) {
        if (entity == null) return null;

        AdminDTO dto = new AdminDTO();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setAddress(entity.getAddress());
        dto.setAdminCode(entity.getAdminCode());

        return dto;
    }
}
