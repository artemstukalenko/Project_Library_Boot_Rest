package com.artemstukalenko.library.project_library_boot.controller;


import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.utility.PenaltyCalculator;
import com.artemstukalenko.library.project_library_boot.utility.Sorter;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @Autowired
    FirstView controlledView;

    @Autowired
    Sorter sorter;

    User currentUser;

    @Autowired
    PenaltyCalculator penaltyCalculator;

    @ModelAttribute
    public void addEssentialAttributes(Model model) {
        model.addAttribute("locale", controlledView);
        model.addAttribute("listSorter", sorter);
    }

    @RequestMapping("/homepage/{username}")
    public User getHomePage(@PathVariable String username) {

        currentUser = userService.findUserByUsername(username);

        currentUser.getUserDetails().setPenalty(penaltyCalculator.calculateUsersPenalty(currentUser));
        currentUser.getUserDetails().setAuthorityString(userService.getUserRole(currentUser.getUsername()));


        return currentUser;
    }

    @RequestMapping("/homepage_again")
    public String getHomePageAgain(Model model) {
        model.addAttribute("currentUser", currentUser);

        return "homepage";
    }

    @RequestMapping("en")
    public String getPageWithEnLang(Model model) {
        model.addAttribute("currentUser", currentUser);

        FirstView.changeLanguageToEn();

        return "homepage";
    }

    @RequestMapping("ua")
    public String getPageWithUaLang(Model model) {
        model.addAttribute("currentUser", currentUser);

        FirstView.changeLanguageToUa();

        return "homepage";
    }

    public User getCurrentUser() {
        return currentUser;
    }

}
