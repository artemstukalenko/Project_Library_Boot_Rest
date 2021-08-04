package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    FirstView controlledView = new FirstView();

    @RequestMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("locale", controlledView);
        model.addAttribute("potentialUser", new User());

        return "register-page";
    }

    @RequestMapping("/registerNewUser")
    public String registerNewUser(@ModelAttribute("potentialUser") User potentialUser) {
        userService.registerUser(potentialUser);
        return "redirect:/login";
    }

}
