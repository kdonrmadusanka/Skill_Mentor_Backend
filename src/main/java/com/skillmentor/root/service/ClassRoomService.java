package com.skillmentor.root.service;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClassRoomService {
    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO);

    public ClassRoomDTO getClassRoomById(String id);
}
