package com.artemstukalenko.library.project_library_boot.controller;


import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.utility.PenaltyCalculator;
import com.artemstukalenko.library.project_library_boot.utility.Sorter;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Autowired
    static User currentUser;

    @Autowired
    PenaltyCalculator penaltyCalculator;

    @ModelAttribute
    public void addTextInformation(Model model) {
        model.addAttribute("locale", controlledView);
        model.addAttribute("listSorter", sorter);
    }

    @RequestMapping("/homepage")
    public String getHomePage(Model model, HttpServletRequest request) {

        currentUser = userService.findUserByUsername(request.getParameter("username"));
        currentUser.getUserDetails().setPenalty(penaltyCalculator.calculateUsersPenalty(currentUser));
        currentUser.getUserDetails().setAuthorityString(userService.getUserRole(currentUser.getUsername()));

        model.addAttribute("currentUser", currentUser);

        return "homepage";
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




    public static User getCurrentUser() {
        return currentUser;
    }

}
