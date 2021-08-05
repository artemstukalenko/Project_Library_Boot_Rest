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

    @RequestMapping("/homepage")
    public String getHomePage(Model model, HttpServletRequest request) {
        model.addAttribute("locale", controlledView);
        String currentUsername = request.getParameter("username");
        model.addAttribute("currentUsername", currentUsername);
        model.addAttribute("currentAuthority", getUserAuthorityString(
                userService.getUserRole(currentUsername)));

        return "homepage";
    }

    private String getUserAuthorityString(String userAuthorityFromDB) {
        switch (userAuthorityFromDB) {
            case "ROLE_ADMIN":
                return ", admin";
            case "ROLE_LIBRARIAN":
                return ", librarian";
            default:
                return "";
        }
    }

    @RequestMapping("en")
    public String getPageWithEnLang(Model model) {
        model.addAttribute("locale", controlledView);

        FirstView.changeLanguageToEn();

        return "redirect:/";
    }

    @RequestMapping("ua")
    public String getPageWithUaLang(Model model) {
        model.addAttribute("locale", controlledView);

        FirstView.changeLanguageToUa();

        return "redirect:/";
    }

    @RequestMapping("/booksList")
    public String getUserEntryPage(Model model) {
        model.addAttribute("locale", controlledView);
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooks);

        return "user-entry-page";
    }



    


}
