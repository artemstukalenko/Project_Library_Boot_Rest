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

    @Autowired
    FirstView controlledView;

    private List<User> allUsersList;

    private List<User> getUpdatedUserList() {
        return userService.getAllUsers();
    }

    @ModelAttribute
    public void addTextInformation(Model model) {
        model.addAttribute("locale", controlledView);
    }

    @RequestMapping("/asAdmin")
    public String getAdminEntryPage(Model model) {
        model.addAttribute("allUsers", getUpdatedUserList());

        return "user-list-page";
    }

    @RequestMapping("/blockUser")
    public String blockUser(@RequestParam("userName") String username, Model model) {
        userService.blockUser(username);
        model.addAttribute("allUsers", getUpdatedUserList());

        return "user-list-page";
    }

    @RequestMapping("/unblockUser")
    public String unblockUser(@RequestParam("userName") String username, Model model) {
        userService.unblockUser(username);
        model.addAttribute("allUsers", getUpdatedUserList());

        return "user-list-page";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userName") String username, Model model) {
        userService.deleteUser(username);
        model.addAttribute("allUsers", getUpdatedUserList());

        return "user-list-page";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int bookId) {
        bookService.deleteBook(bookId);

        return "book-list-page";
    }

    @RequestMapping("/enterInfoForNewBook")
    public String enterInfoForNewBook(Model model) {
        model.addAttribute("newBook", new Book());

        return "enter-info-for-new-book";
    }

    @RequestMapping("/addNewBook")
    public String addNewBook(@ModelAttribute("newBook") Book bookToAdd) {
        bookService.addNewBook(bookToAdd);

        return "book-list-page";
    }
}
