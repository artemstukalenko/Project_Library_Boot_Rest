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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Controller
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
    String currentUserUsername;

    @Autowired
    PenaltyCalculator penaltyCalculator;

    @ModelAttribute
    public void addTextInformation(Model model) {
        model.addAttribute("locale", controlledView);
        model.addAttribute("listSorter", sorter);
    }

    @RequestMapping("/homepage")
    public String getHomePage(Model model, HttpServletRequest request) {
        currentUserUsername = request.getParameter("username");
        currentUser = userService.findUserByUsername(currentUserUsername);

        currentUser.getUserDetails().setPenalty(penaltyCalculator.calculateUsersPenalty(currentUser));
        currentUser.getUserDetails().setAuthorityString(userService.getUserRole(currentUser.getUsername()));

        model.addAttribute("currentUser", currentUser);

        return "homepage";
    }

    @RequestMapping("/homepage_again")
    public String getHomePageAgain(Model model) {
        model.addAttribute("currentUser", userService.findUserByUsername(currentUserUsername));

        return "homepage";
    }

    @RequestMapping("en")
    public String getPageWithEnLang(Model model) {
        model.addAttribute("currentUser", userService.findUserByUsername(currentUserUsername));

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
        return userService.findUserByUsername(currentUserUsername);
    }

}
