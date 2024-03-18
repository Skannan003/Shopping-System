package com.yourname.shoppingsystem.auth;

import auth.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {
    
    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = new AuthService();
    }

    @Test
    void testUserRegistrationAndLogin() {
        String username = "testUser";
        String password = "testPass";
        authService.registerUser(username, password); // Correctly use the authService instance
        
        assertTrue(authService.login(username, password));
    }

    @Test
    void testLoginFailureForUnregisteredUser() {
        assertFalse(authService.login("nonExistentUser", "password"));
    }
}