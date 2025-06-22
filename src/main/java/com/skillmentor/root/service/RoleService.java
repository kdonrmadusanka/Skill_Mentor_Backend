package com.skillmentor.root.service;

import com.skillmentor.root.entity.RoleEntity;

public interface RoleService {

    public void initializeRoles();

    public RoleEntity getRoleByName(String roleName);

}
