package com.skillmentor.root.repository;

import com.skillmentor.root.entity.MentorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<MentorEntity, Long> {
}
