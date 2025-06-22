package com.skillmentor.root.repository;

import com.skillmentor.root.entity.RoleEntity;
import org.hibernate.sql.model.internal.OptionalTableUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    @Query("SELECT r FROM RoleEntity r WHERE r.name = :name")
    Optional<RoleEntity> findByName(@Param("name") String name);

}
