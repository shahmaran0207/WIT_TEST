package com.location.location.Controller;

import com.location.location.config.KakaoProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Controller
public class KakaoAuthController {

    private final KakaoProperties kakaoProperties;

    public KakaoAuthController(KakaoProperties kakaoProperties) {
        this.kakaoProperties = kakaoProperties;
    }

    @GetMapping("/auth/kakao/callback")
    public String kakaoCallback(@RequestParam String code) {
        // Kakao Access Token 요청
        String accessToken = getKakaoAccessToken(code);

        // Firebase Custom Token 생성
        String firebaseToken = createFirebaseToken(accessToken);

        // Firebase 인증 완료 후 리디렉션 (필요에 따라 변경 가능)
        return "redirect:/";
    }

    private String getKakaoAccessToken(String code) {
        // Kakao 토큰 요청 API 설정
        String tokenRequestUrl = "https://kauth.kakao.com/oauth/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // 토큰 요청을 위한 파라미터 설정
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", kakaoProperties.getClient().getId());
        params.add("redirect_uri", kakaoProperties.getRedirect().getUrl());
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        // Kakao API에 요청
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.postForEntity(tokenRequestUrl, request, Map.class);

        // Access Token 추출
        return response.getBody().get("access_token").toString();
    }

    private String createFirebaseToken(String kakaoAccessToken) {
        // 이 함수는 Firebase 커스텀 토큰을 Kakao에서 받아온 Access Token을 통해 생성합니다
        // Firebase Custom Token 생성 로직 작성
        return "firebase_custom_token";
    }

    @GetMapping("/auth/kakao")
    public String kakaoLogin() {
        String loginUrl = kakaoProperties.getAuth().getUrl()
                + "?client_id=" + kakaoProperties.getClient().getId()
                + "&redirect_uri=" + kakaoProperties.getRedirect().getUrl()
                + "&response_type=code";
        return "redirect:" + loginUrl;
    }
}