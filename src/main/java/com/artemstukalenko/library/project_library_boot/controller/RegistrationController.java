package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.entity.UserDetails;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/registerDetails")
    public String registerDetails(@ModelAttribute("potentialUser") User potentialUser,
                                      @ModelAttribute("newUserDetails") UserDetails newUserDetails) {
//        System.out.println("DETAILS: " + newUserDetails);
//        System.out.println("USER: " + potentialUser);
        userService.updateUser(potentialUser);

        return "redirect:/login";
    }

    @RequestMapping("/registerNewUser")
    public String registerNewUser(@ModelAttribute("potentialUser") User potentialUser, Model model) {
        System.out.println("USER: " + potentialUser);
        userService.registerUser(potentialUser);
        System.out.println("USER: " + potentialUser);
        potentialUser.setUserDetails(new UserDetails(potentialUser));
        System.out.println("DETAILS: " + potentialUser.getUserDetails());
        model.addAttribute("potentialUser", potentialUser);
        model.addAttribute("newUserDetails", potentialUser.getUserDetails());

        return "register-details-page";
    }

}
