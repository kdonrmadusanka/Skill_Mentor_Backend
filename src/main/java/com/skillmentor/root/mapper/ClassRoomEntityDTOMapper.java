package com.skillmentor.root.mapper;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.entity.ClassRoomEntity;

import java.util.stream.Collectors;

public class ClassRoomEntityDTOMapper {

    public static ClassRoomEntity map(ClassRoomDTO classRoomDTO){

        ClassRoomEntity classRoomEntity = new ClassRoomEntity();

        classRoomEntity.setObjectId(classRoomDTO.getObjectId());
        classRoomEntity.setClassRoomId(classRoomDTO.getClassRoomId());
        classRoomEntity.setTitle(classRoomDTO.getTitle());
        classRoomEntity.setSessionFee(classRoomDTO.getSessionFee());
        classRoomEntity.setEnrolledStudentCount(classRoomDTO.getEnrolledStudentCount());

        return classRoomEntity;
    }

    public static ClassRoomDTO map(ClassRoomEntity classRoomEntity){

        ClassRoomDTO classRoomDTO = new ClassRoomDTO();

        classRoomDTO.setObjectId(classRoomEntity.getObjectId());
        classRoomDTO.setClassRoomId(classRoomEntity.getClassRoomId());
        classRoomDTO.setTitle(classRoomEntity.getTitle());
        classRoomDTO.setSessionFee(classRoomEntity.getSessionFee());
        classRoomDTO.setEnrolledStudentCount(classRoomEntity.getEnrolledStudentCount());

        classRoomDTO.setMentorDTO(classRoomEntity.getMentorEntities().stream().map(MentorEntityDTOMapper::map).collect(Collectors.toList()));

        return classRoomDTO;
    }
}
