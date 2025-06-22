package com.skillmentor.root.repository;

import com.skillmentor.root.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionEntity, Integer> {
}
