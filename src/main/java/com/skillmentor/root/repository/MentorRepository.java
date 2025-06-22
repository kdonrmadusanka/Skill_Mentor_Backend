package com.skillmentor.root.repository;

import com.skillmentor.root.entity.MentorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MentorRepository extends JpaRepository<MentorEntity, Integer> {
}
