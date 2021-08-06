package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.entity.UserDetails;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    FirstView controlledView = new FirstView();

    @Autowired
    User potentialUser;

    @RequestMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("locale", controlledView);
        model.addAttribute("potentialUser", potentialUser);

        return "register-page";
    }

    @RequestMapping("/registerDetails")
    public String registerDetails(@Valid @ModelAttribute("newUserDetails") UserDetails newUserDetails,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            userService.deleteUser(potentialUser.getUsername());
            return "register-details-page";
        }

        newUserDetails.setUsername(potentialUser.getUsername());
        potentialUser.setUserDetails(newUserDetails);
        userService.updateUser(potentialUser);

        return "redirect:/login";
    }

    @RequestMapping("/registerNewUser")
    public String registerNewUser(@ModelAttribute("potentialUser") User potentialUser1, Model model) {
        model.addAttribute("locale", controlledView);
        userService.registerUser(potentialUser1);

        potentialUser1.setUserDetails(new UserDetails(potentialUser1));

        potentialUser = potentialUser1;

        model.addAttribute("newUserDetails", potentialUser.getUserDetails());

        return "register-details-page";
    }

}
