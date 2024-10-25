package com.location.location.dto;  // 패키지 구조에 맞게 수정

public class LoginRequest {
    private String email;
    private String token;  // Firebase에서 받은 토큰

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
