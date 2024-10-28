package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.client.UserClient;
import com.ecom.model.UserDtls;
import com.ecom.service.SessionService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    @Autowired
    private UserClient userClient;
    
    @Autowired
    private SessionService sessionService;


//    @RequestMapping("/login")
//    public ResponseEntity<?> signin(
//            @RequestParam String username, 
//            @RequestParam String password, 
//            HttpServletResponse response) {
//
//        // Step 1: Validate User Credentials
//        UserDtls user = userClient.getUserByEmail(username);
//        
//
//        if (user == null) {
//            // If credentials are invalid, return an error response
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//        }
//
//        // Step 2: Generate Session ID
//        String sessionId = sessionService.createSession(user.getId());
////        sessionService.storeSession(sessionId, user.getId());
//
//        // Step 3: Set session ID in a cookie
//        Cookie sessionCookie = new Cookie("sessionId", sessionId);
//        sessionCookie.setHttpOnly(true);
//        sessionCookie.setPath("/");
//        sessionCookie.setMaxAge(24 * 60 * 60); // 24 hours
//        response.addCookie(sessionCookie);
//
//        // Step 4: Redirect the user back to the main service after successful login
//        String redirectUrl = "http://localhost:8090/home";  // Adjust this to your main service URL
//        
//		return ResponseEntity.status(HttpStatus.FOUND)
//        		.header("Location", redirectUrl)
//        		.header("sessionId", sessionId)
//        		.build();
//    }
    
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
//        // Retrieve session ID from cookies
//        String sessionId = getSessionIdFromCookies(request.getCookies());
//
//        if (sessionId != null) {
//            sessionService.invalidateSession(sessionId);
//
//            // Clear the session cookie
//            Cookie sessionCookie = new Cookie("sessionId", null);
//            sessionCookie.setPath("/");
//            sessionCookie.setMaxAge(0);
//            response.addCookie(sessionCookie);
//        }
//
//        return ResponseEntity.ok("Logged out successfully.");
//    }
//
//    private String getSessionIdFromCookies(Cookie[] cookies) {
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("sessionId".equals(cookie.getName())) {
//                    return cookie.getValue();
//                }
//            }
//        }
//        return null;
//    }
}
