package com.artemstukalenko.library.project_library_boot.controller;


import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FirstController {

    @Autowired
    UserService userService;

    FirstView controlledView = new FirstView();

    @RequestMapping("/")
    public String getChangeLanguagePage(Model model) {
        model.addAttribute("locale", controlledView);
        return "homepage";
    }

    @RequestMapping("en")
    public String getPageWithEnLang(Model model) {
        model.addAttribute("locale", controlledView);

        FirstView.changeLanguageToEn();

        return "homepage";
    }

    @RequestMapping("ua")
    public String getPageWithUaLang(Model model) {
        model.addAttribute("locale", controlledView);

        FirstView.changeLanguageToUa();

        return "homepage";
    }

    @RequestMapping("/booksList")
    public String getUserEntryPage(Model model) {
        model.addAttribute("locale", controlledView);

        return "user-entry-page";
    }

    @RequestMapping("/asAdmin")
    public String getAdminEntryPage(Model model) {
        model.addAttribute("locale", controlledView);
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "admin-entry-page";
    }

    @RequestMapping("/asLibrarian")
    public String getLibrarianEntryPage(Model model) {
        model.addAttribute("locale", controlledView);

        return "librarian-entry-page";
    }

    @RequestMapping("/blockUser")
    public String blockUser(@RequestParam("userName") String username) {
        userService.blockUser(username);

        return "redirect:/";
    }

    @RequestMapping("/unblockUser")
    public String unblockUser(@RequestParam("userName") String username) {
        userService.unblockUser(username);

        return "redirect:/";
    }

}
