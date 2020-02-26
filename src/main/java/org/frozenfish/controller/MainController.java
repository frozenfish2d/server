package org.frozenfish.controller;

import org.frozenfish.repos.UserRepo;
import org.frozenfish.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @GetMapping("/main/edit")
    public String editPatient(
            @AuthenticationPrincipal User user,
            Model model) {
        model.addAttribute("user", user);
        return "patientEdit";
    }

    @PostMapping("main/save")
    public String saveInfo(
            @RequestParam String phoneNumber,
            @RequestParam String address,
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam("userId") User user

    ) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            user.setPhoneNumber(phoneNumber);
        }
        if (address != null && !address.isEmpty()) {
            user.setAddress(address);
        }
        if (username != null && !username.isEmpty()) {
            user.setUsername(username);
        }
        if (email != null && !email.isEmpty()) {
            user.setEmail(email);
        }
        if (password != null && !password.isEmpty()) {
            user.setPassword(passwordEncoder.encode(password));
        }
        userRepo.save(user);


        return "redirect:/login?logout";
    }

}