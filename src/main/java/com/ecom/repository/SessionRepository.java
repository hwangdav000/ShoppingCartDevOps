package com.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer>{
	Optional<Session> findBySessionId(String sessionId);
	
	
}
