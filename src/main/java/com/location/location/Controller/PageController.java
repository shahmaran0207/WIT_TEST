package com.location.location.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/Location")
    public String location() {
        return "Location";
    }

    @GetMapping("/Alert")
    public String Alert() {
        return "Alert";
    }

    @GetMapping("/Map")
    public String Map() {
        return "Map";
    }

    @GetMapping("/option")
    public String option() {
        return "option";
    }

    @GetMapping("/option2")
    public String option2() {
        return "option2";
    }

    @GetMapping("/Board")
    public String Board() {
        return "Board";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @GetMapping("/login2")
    public String Social_Login(){
        return "login2";
    }

    @GetMapping("/kakao")
    public String kakao() {
        return "kakao";
    }
}
