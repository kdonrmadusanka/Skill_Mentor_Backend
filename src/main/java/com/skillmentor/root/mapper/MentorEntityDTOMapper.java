package com.skillmentor.root.mapper;

import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;

import java.util.Optional;

public class MentorEntityDTOMapper {
    public static MentorEntity map(MentorDTO mentorDTO, ClassRoomEntity classRoomEntity){
        MentorEntity mentorEntity = new MentorEntity();
        mentorEntity.setObjectId(mentorDTO.getObjectId());
        mentorEntity.setMentorId(mentorDTO.getMentorId());
        mentorEntity.setFirstName(mentorDTO.getFirstName());
        mentorEntity.setLastName(mentorDTO.getLastName());
        mentorEntity.setEmail(mentorDTO.getEmail());
        mentorEntity.setPhoneNumber(mentorDTO.getPhoneNumber());
        mentorEntity.setAddress(mentorDTO.getAddress());
        mentorEntity.setAge(mentorDTO.getAge());
        mentorEntity.setClassRoomEntity(classRoomEntity);

        return mentorEntity;
    }


    public static MentorDTO map(MentorEntity mentorEntity){
        MentorDTO mentorDTO = new MentorDTO();
        mentorDTO.setObjectId(mentorEntity.getObjectId());
        mentorDTO.setMentorId(mentorEntity.getMentorId());
        mentorDTO.setFirstName(mentorEntity.getFirstName());
        mentorDTO.setLastName(mentorEntity.getLastName());
        mentorDTO.setEmail(mentorEntity.getEmail());
        mentorDTO.setPhoneNumber(mentorEntity.getPhoneNumber());
        mentorDTO.setAddress(mentorEntity.getAddress());
        mentorDTO.setAge(mentorEntity.getAge());

        return mentorDTO;
    }

}
