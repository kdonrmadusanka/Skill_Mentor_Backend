package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.ClassRoomDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.mapper.ClassRoomEntityDTOMapper;
import com.skillmentor.root.repository.ClassRoomRepository;
import com.skillmentor.root.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    public ClassRoomRepository classRoomRepository;


    @Override
    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO) {
        try{
            ClassRoomEntity mappedClassRoom = ClassRoomEntityDTOMapper.map(classRoomDTO);
            ClassRoomEntity newClassRoomEntity= classRoomRepository.save(mappedClassRoom);

            return ClassRoomEntityDTOMapper.map(newClassRoomEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ClassRoomDTO getClassRoomById(String id) {
        try{
            Optional<ClassRoomEntity> searchedClassRoom = classRoomRepository.findByClassRoomId(id);
            if(searchedClassRoom.isPresent()){
                return ClassRoomEntityDTOMapper.map(searchedClassRoom.get());
            }
            throw new RuntimeException("ClassRoom not found");
        }catch (Exception e) {
                throw new RuntimeException(e);
        }
    }

}
