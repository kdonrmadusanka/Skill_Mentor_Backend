package com.skillmentor.root.service.impl;

import com.skillmentor.root.dto.SessionDTO;
import com.skillmentor.root.entity.ClassRoomEntity;
import com.skillmentor.root.entity.MentorEntity;
import com.skillmentor.root.entity.SessionEntity;
import com.skillmentor.root.entity.StudentEntity;
import com.skillmentor.root.exception.SessionException;
import com.skillmentor.root.mapper.SessionEntityDTOMapper;
import com.skillmentor.root.repository.ClassRoomRepository;
import com.skillmentor.root.repository.MentorRepository;
import com.skillmentor.root.repository.SessionRepository;
import com.skillmentor.root.repository.StudentRepository;
import com.skillmentor.root.service.SessionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Autowired
    private MentorRepository mentorRepository;

    @Transactional
    @Override
    public SessionDTO createSession(SessionDTO sessionDTO) {
        try {
            // Fetch related entities by ID
            StudentEntity student = studentRepository.findById(sessionDTO.getStudentId())
                    .orElseThrow(() -> new SessionException("Student not found with ID: " + sessionDTO.getStudentId()));

            MentorEntity mentor = mentorRepository.findById(sessionDTO.getMentorId())
                    .orElseThrow(() -> new SessionException("Mentor not found with ID: " + sessionDTO.getMentorId()));

            ClassRoomEntity classRoom = classRoomRepository.findById(sessionDTO.getClassRoomId())
                    .orElseThrow(() -> new SessionException("Classroom not found with ID: " + sessionDTO.getClassRoomId()));

            // Map DTO to entity
            SessionEntity sessionEntity = SessionEntityDTOMapper.map(sessionDTO, student, classRoom, mentor);

            // Save the session
            SessionEntity savedSession = sessionRepository.save(sessionEntity);

            // Return mapped DTO
            return SessionEntityDTOMapper.map(savedSession, false, false, false);

        } catch (Exception e) {
            throw new SessionException("Failed to create session", e);
        }
    }

    @Override
    public SessionDTO getSessionById(Integer sessionId) {
        try {
            SessionEntity sessionEntity = sessionRepository.findById(sessionId)
                    .orElseThrow(() -> new SessionException("Session not found with ID: " + sessionId));

            // Map to DTO with all related entities included
            return SessionEntityDTOMapper.map(sessionEntity, false, false, false);

        } catch (SessionException e) {
            throw e; // Rethrow if it's already a known exception
        } catch (Exception e) {
            throw new SessionException("Failed to fetch session with ID: " + sessionId, e);
        }
    }

    @Transactional
    @Override
    public SessionDTO updateSession(Integer sessionId, SessionDTO sessionDTO) {
        try {
            // Fetch the existing session
            SessionEntity existingSession = sessionRepository.findById(sessionId)
                    .orElseThrow(() -> new SessionException("Session not found with ID: " + sessionId));

            // Fetch related entities
            StudentEntity student = studentRepository.findById(sessionDTO.getStudentId())
                    .orElseThrow(() -> new SessionException("Student not found with ID: " + sessionDTO.getStudentId()));

            MentorEntity mentor = mentorRepository.findById(sessionDTO.getMentorId())
                    .orElseThrow(() -> new SessionException("Mentor not found with ID: " + sessionDTO.getMentorId()));

            ClassRoomEntity classRoom = classRoomRepository.findById(sessionDTO.getClassRoomId())
                    .orElseThrow(() -> new SessionException("Classroom not found with ID: " + sessionDTO.getClassRoomId()));

            // Update fields
            existingSession.setStudentEntity(student);
            existingSession.setMentorEntity(mentor);
            existingSession.setClassRoomEntity(classRoom);
            existingSession.setTopic(sessionDTO.getTopic());
            existingSession.setStartTime(sessionDTO.getStartTime());
            existingSession.setEndTime(sessionDTO.getEndTime());

            // Save the updated session
            SessionEntity updatedSession = sessionRepository.save(existingSession);

            return SessionEntityDTOMapper.map(updatedSession, false, false, false);

        } catch (SessionException e) {
            throw e;
        } catch (Exception e) {
            throw new SessionException("Failed to update session with ID: " + sessionId, e);
        }
    }

    @Transactional
    @Override
    public void deleteSessionById(Integer sessionId) {
        try {
            SessionEntity sessionEntity = sessionRepository.findById(sessionId)
                    .orElseThrow(() -> new SessionException("Session not found with ID: " + sessionId));

            sessionRepository.delete(sessionEntity);

        } catch (SessionException e) {
            throw e;
        } catch (Exception e) {
            throw new SessionException("Failed to delete session with ID: " + sessionId, e);
        }
    }

}
