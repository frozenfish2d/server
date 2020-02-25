package org.frozenfish.controller;

import org.frozenfish.enums.Role;
import org.frozenfish.models.CaptchaResponseDto;
import org.frozenfish.models.User;
import org.frozenfish.repos.UserRepo;
import org.frozenfish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    @Autowired
    UserRepo userRepo;
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recaptcha.secret}")
    private String secret;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(
            @RequestParam String passwordConfirm,
            @RequestParam("g-recaptcha-response") String captchaResponse,
            @Valid User user,
            BindingResult bindingResult,
            Model model
    ) {
        String url = String.format(CAPTCHA_URL,secret,captchaResponse);
        CaptchaResponseDto responseDto = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);

        boolean isConfirmEmpty = passwordConfirm.isEmpty();
        if (isConfirmEmpty) {
            model.addAttribute("password2Error", "Введите подтверждение пароля");
        }

        if (user.getPassword() != null && !user.getPassword().equals(passwordConfirm)) {
            model.addAttribute("passwordError", "Пароли должны совпадать!");
        }


        if (isConfirmEmpty || bindingResult.hasErrors() || !responseDto.isSuccess()) {
            Map<String, String> errorMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorMap);
            model.addAttribute(user);
            return "registration";
        }

        if (!userService.addUser(user)) {
            model.addAttribute("usernameError", "Такое имя пользователя существует");
            return "registration";
        }

        return "redirect:/login";

    }


}
