package com.cf.cabinescaperoom.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScoreFormController {

    @GetMapping("/score-form")
    public String displayScoreForm() {

        return "scoreForm";
    }
}
