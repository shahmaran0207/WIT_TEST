package com.location.location.VO;

import lombok.Getter;

@Getter
public class KakaoUser {
    private String id;
    private String email;

    public KakaoUser(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
