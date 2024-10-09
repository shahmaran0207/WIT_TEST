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

    @GetMapping("/Board")
    public String Board() {
        return "Board";
    }
}
