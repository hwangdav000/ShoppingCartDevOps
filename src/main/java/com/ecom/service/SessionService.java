package com.ecom.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class SessionService {

    // In-memory store for session management; replace with a persistent store in production.
    private final Map<String, Integer> sessionStore = new HashMap<>();

    // Generate a new session ID and store it with the user ID
    public String createSession(Integer userId) {
        String sessionId = UUID.randomUUID().toString(); // Generate unique session ID
        sessionStore.put(sessionId, userId); // Map session ID to the user ID
        return sessionId;
    }

    // Validate the session ID by checking if it exists in the store
    public boolean isValidSession(String sessionId) {
        return sessionStore.containsKey(sessionId);
    }

    // Retrieve user ID associated with a session ID, if needed for authorization
    public Integer getUserIdBySession(String sessionId) {
        return sessionStore.get(sessionId);
    }

    // Invalidate session by removing it from the store
    public void invalidateSession(String sessionId) {
        sessionStore.remove(sessionId);
    }
}
