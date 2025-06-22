package com.skillmentor.root.service;

import com.skillmentor.root.dto.MentorDTO;
import org.springframework.stereotype.Service;

@Service
public interface MentorService {

    public MentorDTO createMentor(MentorDTO mentorDTO);

    public MentorDTO getMentorById(Integer mentorId);

    public MentorDTO updateMentor(Integer mentorId, MentorDTO updatedDTO);

    public void deleteMentor(Integer mentorId);

}
