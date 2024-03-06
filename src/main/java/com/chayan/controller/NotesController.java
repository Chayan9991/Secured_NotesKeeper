package com.chayan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotesController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/notes")
    public String notes(){
        return "user-notes";
    }
    @GetMapping("/card")
    public String card(){
        return "card";
    }

}
