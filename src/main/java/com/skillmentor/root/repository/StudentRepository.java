package com.skillmentor.root.repository;

import com.skillmentor.root.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    Optional<StudentEntity> findByObjectId(Integer id);
}