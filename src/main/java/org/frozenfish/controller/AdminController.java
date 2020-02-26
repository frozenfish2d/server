package org.frozenfish.controller;

import org.frozenfish.models.*;
import org.frozenfish.repos.*;
import org.frozenfish.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PositionsRepo positionsRepo;

    @Autowired
    private DiseasesRepo diseasesRepo;

    @Autowired
    private ServicesRepo servicesRepo;

    @Autowired
    private SpecialisationsRepo specialisationsRepo;

    @GetMapping
    public String admin() {
        return "admin";
    }

    @GetMapping("patients")
    public String patientsList(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "patientsList";
    }

    @GetMapping("doctors")
    public String doctorsList(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "doctorsList";
    }

    @GetMapping("positions")
    public String positionList(Model model) {
        model.addAttribute("positions", positionsRepo.findAll());
        return "positionsList";
    }

    @GetMapping("diseases")
    public String diseaseList(Model model) {
        model.addAttribute("diseases", diseasesRepo.findAll());
        return "diseasesList";
    }

    @GetMapping("services")
    public String servicesList(Model model) {
        model.addAttribute("services", servicesRepo.findAll());
        return "servicesList";
    }

    @GetMapping("specialisations")
    public String specialisationsList(Model model) {
        model.addAttribute("specialisations", specialisationsRepo.findAll());
        return "specialisationsList";
    }

    @GetMapping("uid_{user}")
    public String userEdit(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping("add_position")
    public String addPosition(@RequestParam String positionName) {
        if (positionName != null && !positionName.isEmpty()) {
            positionsRepo.save(new Position(positionName));
        }
        return "redirect:/admin/positions";
    }

    @PostMapping("add_disease")
    public String addDisease(@RequestParam String diseaseName) {
        if (diseaseName != null && !diseaseName.isEmpty()) {
            diseasesRepo.save(new Disease(diseaseName));
        }
        return "redirect:/admin/diseases";
    }

    @PostMapping("add_service")
    public String addService(@RequestParam String serviceName,
                             @RequestParam Double servicePrice) {
        if (serviceName != null && !serviceName.isEmpty()) {
            servicesRepo.save(new Service(serviceName, servicePrice));
        }
        return "redirect:/admin/services";
    }

    @PostMapping("add_specialisation")
    public String addSpecialisation(@RequestParam String specialisationName) {
        if (specialisationName != null && !specialisationName.isEmpty()) {
            specialisationsRepo.save(new Specialization(specialisationName));
        }
        return "redirect:/admin/specialisations";
    }


    @PostMapping
    public String userSave(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String secondName,
            @RequestParam(required = false) String middleName,
            @RequestParam(required = false) String bDay,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String omsNumber,
            @RequestParam(required = false) String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        if (firstName != null && !firstName.isEmpty()) {
            user.setFirstName(firstName);
        }
        if (secondName != null && !secondName.isEmpty()) {
            user.setSecondName(secondName);
        }
        if (middleName != null && !middleName.isEmpty()) {
            user.setMiddleName(middleName);
        }
/*        if (bDay != null && user.getbDay().compareTo(Date.valueOf(bDay)) != 1) {
            user.setbDay(Date.valueOf(bDay));
        }*/
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            user.setPhoneNumber(phoneNumber);
        }
        if (address != null && !address.isEmpty()) {
            user.setAddress(address);
        }
        if (email != null && !email.isEmpty()) {
            user.setEmail(email);
        }
        if (omsNumber != null && !omsNumber.isEmpty()) {
            user.setOmsNumber(omsNumber);
        }
        if (username != null && !username.isEmpty()) {
            user.setUsername(username);
        }

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);
        return "redirect:/admin";
    }


}
