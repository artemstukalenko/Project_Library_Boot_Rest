package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import com.artemstukalenko.library.project_library_boot.service.UserService;
import com.artemstukalenko.library.project_library_boot.utility.Searcher;
import com.artemstukalenko.library.project_library_boot.utility.Sorter;
import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @Autowired
    FirstView controlledView;

    @Autowired
    Sorter sorter;

    @Autowired
    Searcher searcher;

    List<Book> currentBookList;

//    @ModelAttribute
//    public void addEssentialAttributes(Model model) {
//        model.addAttribute("locale", controlledView);
//        model.addAttribute("listSorter", sorter);
//        model.addAttribute("allBooks", currentBookList);
//        model.addAttribute("searcher", searcher);
//    }

    @GetMapping("/booksList")
    public List<Book> getUserEntryPage() {
        currentBookList = bookService.getAllBooks();

        return currentBookList;
    }

    @GetMapping("/getSortedBooksList/{sortMethod}")
    public List<Book> getSortedPage(@PathVariable("sortMethod") String sortMethod) {
        this.sorter.setSortMethod(sortMethod);
        return sorter.sortList(bookService.getAllBooks());
    }

    @GetMapping("/searchBook/{searchCriteria}/{searchString}")
    public List<Book> searchForBooks(@PathVariable("searchCriteria") String searchCriteria,
                                 @PathVariable("searchString") String searchString) {
        searcher.setSearchCriteria(searchCriteria);
        searcher.setUserInput(searchString);

        currentBookList = searcher
                .getResultOfTheBookSearch(bookService.getAllBooks());

        return currentBookList;
    }

    @RequestMapping("/changeTakenValue")
    public String changeTakenValueOfBook(@RequestParam("bookId") int bookId,
                                         Model model) {

        Book currentBook = bookService.findBookById(bookId);

        bookService.setTaken(currentBook.getBookId(), !currentBook.getTaken());

        model.addAttribute("allBooks", bookService.getAllBooks());

        return "book-list-page";
    }

    @RequestMapping("/addNewBook")
    public String addNewBook(@ModelAttribute("newBook") Book bookToAdd, Model model) {
        bookService.addNewBook(bookToAdd);

        model.addAttribute("allBooks", bookService.getAllBooks());

        return "book-list-page";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int bookId, Model model) {
        bookService.deleteBook(bookId);

        model.addAttribute("allBooks", bookService.getAllBooks());

        return "book-list-page";
    }
}
