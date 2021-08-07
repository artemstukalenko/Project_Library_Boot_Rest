package com.artemstukalenko.library.project_library_boot.controller;


import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
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
    static User currentUser;

    @RequestMapping("/homepage")
    public String getHomePage(Model model, HttpServletRequest request) {
        model.addAttribute("locale", controlledView);
        currentUser = userService.findUserByUsername(request.getParameter("username"));
        currentUser.getUserDetails().setAuthorityString(userService.getUserRole(currentUser.getUsername()));

        model.addAttribute("currentUsername", currentUser.getUsername());
        model.addAttribute("currentAuthority", currentUser.getAuthorityString());
        model.addAttribute("currentUser", currentUser);

        return "homepage";
    }

    @RequestMapping("/homepage_again")
    public String getHomePageAgain(Model model) {
        model.addAttribute("locale", controlledView);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("currentUsername", currentUser.getUsername());
        model.addAttribute("currentAuthority", currentUser.getAuthorityString());

        return "homepage";
    }

    @RequestMapping("en")
    public String getPageWithEnLang(Model model) {
        model.addAttribute("locale", controlledView);
        model.addAttribute("currentUser", currentUser);

        FirstView.changeLanguageToEn();

        return "homepage";
    }

    @RequestMapping("ua")
    public String getPageWithUaLang(Model model) {
        model.addAttribute("locale", controlledView);
        model.addAttribute("currentUser", currentUser);

        FirstView.changeLanguageToUa();

        return "homepage";
    }

    @RequestMapping("/booksList")
    public String getUserEntryPage(Model model) {
        model.addAttribute("locale", controlledView);
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooks);

        return "book-list-page";
    }

    
    public static User getCurrentUser() {
        return currentUser;
    }

}
