package com.skillmentor.root.service;

import com.skillmentor.root.dto.SessionDTO;

public interface SessionService {

    public SessionDTO createSession(SessionDTO sessionDTO);

    public SessionDTO getSessionById(Integer sessionId);

    public SessionDTO updateSession(Integer sessionId, SessionDTO sessionDTO);

    public void deleteSessionById(Integer sessionId);
}
