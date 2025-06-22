package com.skillmentor.root.mapper;

import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MentorEntityDTOMapper {

    // DTO to Entity
    public static MentorEntity map(MentorDTO mentorDTO) {
        if (mentorDTO == null) return null;

        MentorEntity entity = new MentorEntity();
        entity.setMentorId(mentorDTO.getMentorId());
        entity.setFirstName(mentorDTO.getFirstName());
        entity.setLastName(mentorDTO.getLastName());
        entity.setAddress(mentorDTO.getAddress());
        entity.setEmail(mentorDTO.getEmail());
        entity.setTitle(mentorDTO.getTitle());
        entity.setSessionFee(mentorDTO.getSessionFee());
        entity.setProfession(mentorDTO.getProfession());
        entity.setSubject(mentorDTO.getSubject());
        entity.setPhoneNumber(mentorDTO.getPhoneNumber());
        entity.setQualification(mentorDTO.getQualification());

        // sessionEntityList and classRoom will be handled separately if needed
        return entity;
    }

    // Entity to DTO
    public static MentorDTO map(MentorEntity mentorEntity, boolean skipClassRoom, boolean skipSessions) {
        if (mentorEntity == null) return null;

        MentorDTO dto = new MentorDTO();
        dto.setMentorId(mentorEntity.getMentorId());
        dto.setFirstName(mentorEntity.getFirstName());
        dto.setLastName(mentorEntity.getLastName());
        dto.setAddress(mentorEntity.getAddress());
        dto.setEmail(mentorEntity.getEmail());
        dto.setTitle(mentorEntity.getTitle());
        dto.setSessionFee(mentorEntity.getSessionFee());
        dto.setProfession(mentorEntity.getProfession());
        dto.setSubject(mentorEntity.getSubject());
        dto.setPhoneNumber(mentorEntity.getPhoneNumber());
        dto.setQualification(mentorEntity.getQualification());

        // Include sessions
        if (!skipSessions) {
            dto.setSessionDTO(
                    Optional.ofNullable(mentorEntity.getSessionEntityList())
                            .orElse(List.of())
                            .stream()
                            .map(session -> SessionEntityDTOMapper.map(session, true, true, false)) // skipMentor = true
                            .collect(Collectors.toList())
            );
        }

        // ClassRoom inclusion is optional
        if (!skipClassRoom) {
            // You should ensure in your service logic to fetch the classroom where this mentor is assigned
            // and set it into the DTO
            ClassRoomEntity classRoom = findClassRoomForMentor(mentorEntity); // Stub
            if (classRoom != null) {
                dto.setClassRoomDTO(ClassRoomEntityDTOMapper.map(classRoom, true, true));
            }
        }

        return dto;
    }

    // Stub method to fetch the classroom for a mentor (actual logic should be in service/repo layer)
    private static ClassRoomEntity findClassRoomForMentor(MentorEntity mentorEntity) {
        // You'd typically have this resolved at service layer or via bi-directional mapping
        return null;
    }
}
