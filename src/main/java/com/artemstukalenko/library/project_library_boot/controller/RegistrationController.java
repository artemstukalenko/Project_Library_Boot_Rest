package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.entity.UserDetails;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("potentialUser", potentialUser);

        return "register-page";
    }

    @PostMapping("/registerNewUser")
    public List<User> registerNewUser(@RequestBody User potentialUser) {

        userService.registerUser(potentialUser);

        return userService.getAllUsers();
    }

    @PostMapping("/registerNewDetails/{username}")
    public User registerUserDetails(@RequestBody UserDetails newUserDetails,
                                    @PathVariable("username") String username) {

        User currentUser = userService.findUserByUsername(username);
        currentUser.setUserDetails(newUserDetails);

        userService.updateUser(currentUser);

        return currentUser;
    }
}
