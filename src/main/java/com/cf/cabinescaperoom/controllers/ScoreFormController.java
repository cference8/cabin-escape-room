package com.cf.cabinescaperoom.controllers;


import com.cf.cabinescaperoom.models.ScoreForm;
import com.cf.cabinescaperoom.models.User;
import com.cf.cabinescaperoom.service.ScoreFormService;
import com.cf.cabinescaperoom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ScoreFormController {

    @Autowired
    ScoreFormService service;

    @Autowired
    UserService userService;

    @GetMapping("form")
    public String displayScoreForm(Model model) {
        List<ScoreForm> scoreFormList = service.getAll();
        model.addAttribute("scores", scoreFormList);
        return "form";
    }

    @GetMapping("scoreForm")
    public String displayScoreForm() {
        return "scoreForm";
    }

    @PostMapping("addScoreForm")
    public String addScoreForm(HttpServletRequest request) {

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();

        User scoreFormUser = userService.getUserByUsername(user.getUsername());

        String name1 = request.getParameter("name1");
        String name2 = request.getParameter("name2");
        String name3 = request.getParameter("name3");
        String name4 = request.getParameter("name4");
        String name5 = request.getParameter("name5");
        String name6 = request.getParameter("name6");
        String activity_name = request.getParameter("activity_name");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        int minutes = Integer.parseInt(request.getParameter("minutes"));
        int help_cards = Integer.parseInt(request.getParameter("help_cards"));

        ScoreForm scoreForm = new ScoreForm();
        scoreForm.setName1(name1);
        scoreForm.setName2(name2);
        scoreForm.setName3(name3);
        scoreForm.setName4(name4);
        scoreForm.setName5(name5);
        scoreForm.setName6(name6);
        scoreForm.setActivity_name(activity_name);
        scoreForm.setDate(date);
        scoreForm.setMinutes(minutes);
        scoreForm.setHelp_cards(help_cards);
        scoreForm.setUser(scoreFormUser);

        service.addScoreForm(scoreForm);

        return "redirect:/form";
    }

    @GetMapping("viewAllScores")
    public String viewAllScores(Model model) {

        List<ScoreForm> scoreFormList = service.getAll();
        model.addAttribute("scores", scoreFormList);

        return "viewScores";
    }


/**
 * Save for addScore
 *          String name1 = request.getParameter("name1");
 *         String name2 = request.getParameter("name2");
 *         String name3 = request.getParameter("name3");
 *         String name4 = request.getParameter("name4");
 *         String name5 = request.getParameter("name5");
 *         String name6 = request.getParameter("name6");
 *         String activity_name = request.getParameter("activity_name");
 *         LocalDate date = LocalDate.parse(request.getParameter("date"), formatter);
 *         int minutes = Integer.parseInt(request.getParameter("minutes"));
 *         int help_cards = Integer.parseInt(request.getParameter("help_cards"));
 *
 *         ScoreForm scoreForm = new ScoreForm();
 *         scoreForm.setName1(name1);
 *         scoreForm.setName2(name2);
 *         scoreForm.setName3(name3);
 *         scoreForm.setName4(name4);
 *         scoreForm.setName5(name5);
 *         scoreForm.setName6(name6);
 *         scoreForm.setActivity_name(activity_name);
 *         scoreForm.setDate(date);
 *         scoreForm.setMinutes(minutes);
 *         scoreForm.setHelp_cards(help_cards);
 *         scoreForm.setUser(scoreFormUser);
 */
}
