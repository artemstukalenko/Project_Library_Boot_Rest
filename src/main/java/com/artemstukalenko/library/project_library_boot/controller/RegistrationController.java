package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.entity.UserDetails;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    FirstView controlledView;

    @Autowired
    User potentialUser;

    private boolean detailsAreNotValid;

    @RequestMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("potentialUser", potentialUser);

        return "register-page";
    }

    @RequestMapping("/registerDetails")
    public String registerDetails(@Valid @ModelAttribute("newUserDetails") UserDetails newUserDetails,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            detailsAreNotValid = true;
            return "register-details-page";
        }
        detailsAreNotValid = false;
        newUserDetails.setUsername(potentialUser.getUsername());
        potentialUser.setUserDetails(newUserDetails);
        userService.updateUser(potentialUser);

        if(detailsAreNotValid) {
            userService.deleteUser(potentialUser.getUsername());
        }

        return "redirect:/login";
    }

    @RequestMapping("/deletePotentialUser")
    public String deletePotentialUser() {
        userService.deleteUser(potentialUser.getUsername());

        return "redirect:/login";
    }

    @PostMapping("/registerNewUser")
    public List<User> registerNewUser(@RequestBody User potentialUser1) {

        userService.registerUser(potentialUser1);

        potentialUser1.setUserDetails(new UserDetails(potentialUser1));

        potentialUser = potentialUser1;

        return userService.getAllUsers();
    }

}
