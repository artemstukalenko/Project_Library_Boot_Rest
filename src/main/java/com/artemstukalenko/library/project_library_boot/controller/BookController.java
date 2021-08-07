package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.utility.Sorter;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @Autowired
    FirstView controlledView;

    @Autowired
    Sorter sorter;

    @ModelAttribute
    public void addTextInformation(Model model) {
        model.addAttribute("locale", controlledView);
        model.addAttribute("listSorter", sorter);
        model.addAttribute("allBooks", bookService.getAllBooks());
    }

    @RequestMapping("/booksList")
    public String getUserEntryPage(Model model) {
//        List<Book> allBooks = ;
//        model.addAttribute("allBooks", bookService.getAllBooks());

        return "book-list-page";
    }

    @RequestMapping("/filter")
    public String getFilteredPage(@ModelAttribute("listSorter") Sorter sorter,
                                  Model model) {

        model.addAttribute("allBooks", sorter.sortList(bookService.getAllBooks()));
        return "book-list-page";
    }
}
