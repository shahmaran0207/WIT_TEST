package com.location.location.Controller;

import com.location.location.Service.FirebaseService;
import com.location.location.Service.KakaoService;
import com.location.location.VO.KakaoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private KakaoService kakaoService;

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/kakaoLogin")
    public ResponseEntity<?> kakaoLogin(@RequestBody Map<String, String> payload) {
        try {
            String accessToken = payload.get("accessToken");
            KakaoUser kakaoUser = kakaoService.getUserInfo(accessToken);

            // Firebase 커스텀 토큰 생성
            String firebaseToken = firebaseService.createCustomToken(kakaoUser.getId());

            Map<String, String> response = new HashMap<>();
            response.put("firebaseToken", firebaseToken);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("카카오 로그인 실패: " + e.getMessage());
        }
    }
}
