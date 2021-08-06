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

    FirstView controlledView = new FirstView();

    User currentUser;

    String currentUserAuthority;

    @RequestMapping("/homepage")
    public String getHomePage(Model model, HttpServletRequest request) {
        model.addAttribute("locale", controlledView);

        currentUser = userService.findUserByUsername(request.getParameter("username"));

        model.addAttribute("currentUsername", currentUser.getUsername());
        currentUserAuthority = getUserAuthorityString(
                userService.getUserRole(currentUser.getUsername()));
        model.addAttribute("currentAuthority", currentUserAuthority);
        model.addAttribute("currentUser", currentUser);

        return "homepage";
    }

    @RequestMapping("/homepage_again")
    public String getHomePageAgain(Model model) {
        model.addAttribute("locale", controlledView);
        model.addAttribute("currentUsername", currentUser.getUsername());
        model.addAttribute("currentAuthority", currentUserAuthority);

        return "homepage";
    }

    private String getUserAuthorityString(String userAuthorityFromDB) {
        switch (userAuthorityFromDB) {
            case "ROLE_ADMIN":
                return "ADMIN";
            case "ROLE_LIBRARIAN":
                return "LIBRARIAN";
            default:
                return "";
        }
    }

    @RequestMapping("en")
    public String getPageWithEnLang(Model model) {
        model.addAttribute("locale", controlledView);

        FirstView.changeLanguageToEn();

        return "redirect:/.";
    }

    @RequestMapping("ua")
    public String getPageWithUaLang(Model model) {
        model.addAttribute("locale", controlledView);

        FirstView.changeLanguageToUa();

        return "redirect:/.";
    }

    @RequestMapping("/booksList")
    public String getUserEntryPage(Model model) {
        model.addAttribute("locale", controlledView);
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooks);

        return "book-list-page";
    }



    


}
