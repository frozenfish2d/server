package org.frozenfish.controller;

import org.frozenfish.models.User;
import org.frozenfish.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String showRecord(
            @AuthenticationPrincipal User user,
            Model model

    ){

        return "records";
    }


}
