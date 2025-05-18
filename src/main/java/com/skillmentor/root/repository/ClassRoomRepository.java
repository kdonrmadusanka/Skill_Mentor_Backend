package com.skillmentor.root.repository;

import com.skillmentor.root.entity.ClassRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassRoomRepository extends JpaRepository<ClassRoomEntity, Integer> {
    Optional<ClassRoomEntity> findByClassRoomId(String classRoomId);
}
