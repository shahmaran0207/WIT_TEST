package com.location.location.Controller;

import com.location.location.dto.LoginRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@Controller
public class MemberController {

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpSession session, @RequestBody LoginRequest loginRequest) {
        String token = loginRequest.getToken();

        // Firebase 토큰 검증 로직 추가 (생략)
        boolean isAuthenticated = true; // 검증 성공 여부

        if (isAuthenticated) {
            session.setAttribute("authToken", token);
            session.setAttribute("userEmail", loginRequest.getEmail());
            return ResponseEntity.ok("/Board");  // 성공 시 Board로 리디렉션
        } else {
            return ResponseEntity.status(401).body("로그인 실패");
        }
    }

    @GetMapping("/myPage")
    public String myPage(HttpSession session) {
        // 세션에서 특정 값을 가져옴 (예: authToken)
        String authToken = (String) session.getAttribute("authToken");

        if (authToken != null) {
            // 세션에 authToken이 있을 경우 "join" 페이지로 이동
            return "join";
        } else {
            // 세션에 authToken이 없을 경우 "Board" 페이지로 리디렉션
            return "redirect:/Board";
        }
    }

}
