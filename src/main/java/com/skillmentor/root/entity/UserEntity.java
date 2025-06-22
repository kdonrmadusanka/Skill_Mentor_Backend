package com.skillmentor.root.entity;

public interface UserEntity {
    Integer getId(); // Or String, depending on your ID type
    RoleEntity getRole();
}
