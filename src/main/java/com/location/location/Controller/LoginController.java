package com.location.location.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/oauth/kakao/callback")
    public String kakaoLogin(@AuthenticationPrincipal OAuth2AuthenticationToken authentication, HttpSession session) {
        // 유저 정보 추출
        var attributes = authentication.getPrincipal().getAttributes();
        String email = (String) attributes.get("kakao_account.email");
        String nickname = (String) attributes.get("properties.nickname");

        // 세션에 유저 정보 저장
        session.setAttribute("userEmail", email);
        session.setAttribute("userNickname", nickname);

        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        model.addAttribute("email", session.getAttribute("userEmail"));
        model.addAttribute("nickname", session.getAttribute("userNickname"));
        return "home";
    }
}

