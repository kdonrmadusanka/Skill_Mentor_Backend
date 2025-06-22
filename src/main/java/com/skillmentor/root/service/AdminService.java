package com.skillmentor.root.service;

import com.skillmentor.root.dto.AdminDTO;
import com.skillmentor.root.dto.RegistrationResponseDTO;
import com.skillmentor.root.entity.AdminEntity;

public interface AdminService {
    public RegistrationResponseDTO createAdmin(AdminDTO adminDTO);

    AdminDTO getAdminById(Integer id);
}
