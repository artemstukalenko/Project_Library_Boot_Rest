package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.utility.PenaltyCalculator;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    FirstView controlledView;

    @Autowired
    PenaltyCalculator penaltyCalculator;

    private List<User> getUpdatedUserList() {
        return userService.getAllUsers();
    }

    private List<User> getUserListWithUpdatedPenalty() {
        return userService.getAllUsers().stream().peek(user -> {user.getUserDetails()
                .setPenalty(penaltyCalculator.calculateUsersPenalty(user));})
                .collect(Collectors.toList());
    }

    @RequestMapping("/getAllUsers")
    public List<User> getAdminEntryPage(Model model) {
        return getUserListWithUpdatedPenalty();
    }

    @RequestMapping("/blockUser/{username}")
    public User blockUser(@PathVariable("username") String username) {
        userService.blockUser(username);

        return userService.findUserByUsername(username);
    }

    @RequestMapping("/unblockUser/{username}")
    public User unblockUser(@PathVariable("username") String username) {
        userService.unblockUser(username);

        return userService.findUserByUsername(username);
    }

    @RequestMapping("/deleteUser/{username}")
    public List<User> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);

        return userService.getAllUsers();
    }



    @RequestMapping("/enterInfoForNewBook")
    public String enterInfoForNewBook(Model model) {
        model.addAttribute("newBook", new Book());

        return "enter-info-for-new-book";
    }



    @RequestMapping("/makeUserLibrarian/{username}")
    public User makeUserLibrarian(@PathVariable("username") String username) {

        User currentUser = userService.findUserByUsername(username);

        userService.makeUserLibrarian(currentUser.getUsername());
        currentUser.setAuthorityString("ROLE_LIBRARIAN");

        return currentUser;
    }

    @RequestMapping("/depriveLibrarianRole/{username}")
    public User depriveLibrarianPrivilegesFromUser(@PathVariable("username") String username) {

        User currentUser = userService.findUserByUsername(username);

        userService.depriveLibrarianPrivileges(username);
        currentUser.setAuthorityString("ROLE_USER");

        return currentUser;
    }
}
