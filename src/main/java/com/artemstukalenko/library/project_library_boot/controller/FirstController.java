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

import java.util.List;

@Controller
public class FirstController {

    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    FirstView controlledView = new FirstView();

    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("locale", controlledView);
//        String userRole = userService.getUserRole(username);
//        model.addAttribute("userRole", userRole);
        return "homepage";
    }

    @RequestMapping("en")
    public String getPageWithEnLang(Model model) {
        model.addAttribute("locale", controlledView);

        FirstView.changeLanguageToEn();

        //return "homepage";
        return "redirect:/";
    }

    @RequestMapping("ua")
    public String getPageWithUaLang(Model model) {
        model.addAttribute("locale", controlledView);

        FirstView.changeLanguageToUa();

        //return "homepage";
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
