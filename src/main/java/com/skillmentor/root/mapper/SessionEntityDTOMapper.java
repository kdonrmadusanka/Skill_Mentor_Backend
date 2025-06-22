package com.skillmentor.root.mapper;

import com.skillmentor.root.dto.SessionDTO;
import com.skillmentor.root.entity.SessionEntity;
import com.skillmentor.root.entity.StudentEntity;
import com.skillmentor.root.entity.MentorEntity;
import com.skillmentor.root.entity.ClassRoomEntity;

public class SessionEntityDTOMapper {

    // DTO to Entity
    public static SessionEntity map(SessionDTO dto, StudentEntity studentEntity, ClassRoomEntity classRoomEntity, MentorEntity mentorEntity) {
        if (dto == null) return null;

        SessionEntity entity = new SessionEntity();
        entity.setSessionId(dto.getSessionId());
        entity.setStudentEntity(studentEntity);
        entity.setClassRoomEntity(classRoomEntity);
        entity.setMentorEntity(mentorEntity);
        entity.setTopic(dto.getTopic());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());

        return entity;
    }

    // Entity to DTO
    public static SessionDTO map(SessionEntity entity, boolean skipStudent, boolean skipMentor, boolean skipClassRoom) {
        if (entity == null) return null;

        SessionDTO dto = new SessionDTO();
        dto.setSessionId(entity.getSessionId());
        dto.setStudentId(entity.getStudentEntity().getStudentId());
        dto.setMentorId(entity.getMentorEntity().getMentorId());
        dto.setClassRoomId(entity.getClassRoomEntity().getClassRoomId());
        dto.setTopic(entity.getTopic());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());

        if (!skipStudent) {
            dto.setStudentDTO(StudentEntityDTOMapper.map(entity.getStudentEntity(), true));
        }
        if (!skipMentor) {
            dto.setMentorDTO(MentorEntityDTOMapper.map(entity.getMentorEntity(), true, true));
        }
        if (!skipClassRoom) {
            dto.setClassRoomDTO(ClassRoomEntityDTOMapper.map(entity.getClassRoomEntity(), true, true));
        }

        return dto;
    }
}
