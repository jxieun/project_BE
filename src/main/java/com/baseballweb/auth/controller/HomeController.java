package com.baseballweb.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/api/team")
    public String showTeamPage(Model model) {
        model.addAttribute("playerName", "Lee Seung Yul");
        model.addAttribute("teamName", "Doosan Bears");
        return "team";  // templates/team.html을 반환
    }
}
