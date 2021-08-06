package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    FirstView controlledView = new FirstView();

    @RequestMapping("/asAdmin")
    public String getAdminEntryPage(Model model) {
        model.addAttribute("locale", controlledView);
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "user-list-page";
    }

    @RequestMapping("/blockUser")
    public String blockUser(@RequestParam("userName") String username) {
        userService.blockUser(username);

        return "homepage";
    }

    @RequestMapping("/unblockUser")
    public String unblockUser(@RequestParam("userName") String username) {
        userService.unblockUser(username);

        return "homepage";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userName") String username) {
        userService.deleteUser(username);

        return "homepage";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int bookId) {
        bookService.deleteBook(bookId);

        return "homepage";
    }

    @RequestMapping("/enterInfoForNewBook")
    public String enterInfoForNewBook(Model model) {
        model.addAttribute("newBook", new Book());
        model.addAttribute("locale", controlledView);

        return "enter-info-for-new-book";
    }

    @RequestMapping("/addNewBook")
    public String addNewBook(@ModelAttribute("newBook") Book bookToAdd) {
        bookService.addNewBook(bookToAdd);

        return "homepage";
    }
}
