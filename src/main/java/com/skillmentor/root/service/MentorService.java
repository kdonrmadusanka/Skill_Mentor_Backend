package com.skillmentor.root.service;

import com.skillmentor.root.dto.MentorDTO;
import org.springframework.stereotype.Service;

@Service
public interface MentorService {

    public MentorDTO createMentor(MentorDTO mentorDTO);

}
