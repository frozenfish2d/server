package org.frozenfish.controller;

import org.frozenfish.repos.UserRepo;
import org.frozenfish.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/main")
    public String main(
            @AuthenticationPrincipal User user,
            Model model) {
        model.addAttribute("user", user);
        return "main";
    }
}