package com.ecom.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.model.Session;
import com.ecom.repository.SessionRepository;

@Service
public class SessionService {

	@Autowired SessionRepository sRepo;
    // In-memory store for session management; replace with a persistent store in production.
//    private final Map<String, Integer> sessionStore = new HashMap<>();

    // Generate a new session ID and store it with the user ID
    public String createSession(Integer userId) {
    	
    	Session s = new Session();
    	
    	s.setCreatedAt(LocalDateTime.now());
        s.setExpiresAt(s.getCreatedAt().plusHours(24)); // expires 24h after
        s.setSessionId(UUID.randomUUID().toString());
        s.setUserId(userId);
        Session savedSession = sRepo.save(s);
        
        return savedSession.getSessionId();
    }

    // Validate the session ID by checking if it exists in the store
    public boolean isValidSession(String sessionId) {
    	
    	return sRepo.findBySessionId(sessionId).isPresent();
    }

    // Retrieve user ID associated with a session ID, if needed for authorization
    public Integer getUserIdBySession(String sessionId) {
    	
    	Session s = sRepo.findBySessionId(sessionId).get();
    	
    	if (s != null) {
    		return s.getUserId();
    	}
        return null;
    }

    // Invalidate session by removing it from the store
    public void invalidateSession(String sessionId) {
        Session s = sRepo.findBySessionId(sessionId).get();
        if (s != null) {
        	sRepo.deleteById(s.getId());
        }
    }
}
