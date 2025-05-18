package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;
import com.skillmentor.root.mapper.MentorEntityDTOMapper;
import com.skillmentor.root.repository.ClassRoomRepository;
import com.skillmentor.root.repository.MentorRepository;
import com.skillmentor.root.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        try {
            Optional<ClassRoomEntity> classRoomEntity = classRoomRepository.findById(mentorDTO.getClassRoomId());
            if(classRoomEntity.isPresent()) {
                MentorEntity newMentorEntity = MentorEntityDTOMapper.map(mentorDTO, classRoomEntity.get());
                MentorEntity savedMentorEntity = mentorRepository.save(newMentorEntity);
                return MentorEntityDTOMapper.map(savedMentorEntity);
            }
            throw new RuntimeException("ClassRoom not found with ID: " + mentorDTO.getClassRoomId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
