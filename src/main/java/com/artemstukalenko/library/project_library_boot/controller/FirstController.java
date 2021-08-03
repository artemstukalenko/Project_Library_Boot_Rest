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
public class FirstController {

    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    FirstView controlledView = new FirstView();

    @RequestMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout,
                               Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        model.addAttribute("locale", controlledView);
        return "login";
    }

    @RequestMapping("/logout")
    public String whenLoggedOut() {
        return "redirect:/login";
    }

    @RequestMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("locale", controlledView);
        return "register-page";
    }

    @RequestMapping("/")
    public String getChangeLanguagePage(Model model) {
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
