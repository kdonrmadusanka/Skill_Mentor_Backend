package com.skillmentor.root.mapper;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.dto.MentorDTO;
import com.skillmentor.root.dto.SessionDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClassRoomEntityDTOMapper {

    public static ClassRoomEntity map(ClassRoomDTO classRoomDTO, MentorEntity mentorEntity) {
        if (classRoomDTO == null) return null;

        ClassRoomEntity classRoomEntity = new ClassRoomEntity();
        classRoomEntity.setClassRoomId(classRoomDTO.getClassRoomId());
        classRoomEntity.setTitle(classRoomDTO.getTitle());
        classRoomEntity.setEnrolledStudentCount(classRoomDTO.getEnrolledStudentCount());
        classRoomEntity.setMentor(mentorEntity);

        // Sessions will be set separately if needed
        return classRoomEntity;
    }

    public static ClassRoomDTO map(ClassRoomEntity classRoomEntity, boolean skipMentor, boolean skipSessions) {
        if (classRoomEntity == null) return null;

        ClassRoomDTO classRoomDTO = new ClassRoomDTO();
        classRoomDTO.setClassRoomId(classRoomEntity.getClassRoomId());
        classRoomDTO.setTitle(classRoomEntity.getTitle());
        classRoomDTO.setEnrolledStudentCount(classRoomEntity.getEnrolledStudentCount());

        if (!skipMentor && classRoomEntity.getMentor() != null) {
            MentorDTO mentorDTO = MentorEntityDTOMapper.map(classRoomEntity.getMentor(), true, true);
            classRoomDTO.setMentorDTO(mentorDTO);
        }

        if (!skipSessions && classRoomEntity.getSessionEntityList() != null) {
            List<SessionDTO> sessions = classRoomEntity.getSessionEntityList()
                    .stream()
                    .map(session -> SessionEntityDTOMapper.map(session, true, true, true)) // skipClassRoom=true to avoid recursion
                    .collect(Collectors.toList());
            classRoomDTO.setSessionDTOList(sessions);
        }

        return classRoomDTO;
    }
}
