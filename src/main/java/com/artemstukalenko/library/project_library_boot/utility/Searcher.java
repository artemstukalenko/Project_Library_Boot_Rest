package com.artemstukalenko.library.project_library_boot.utility;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class Searcher {
    String userInput;
    String searchCriteria;

    private Predicate <Book> searchByTitle = book -> {return book.getBookTitle().toLowerCase().contains(userInput.toLowerCase());};
    private Predicate <Book> searchByAuthor = book -> {return book.getBookAuthor().toLowerCase().contains(userInput.toLowerCase());};
    private Predicate <Book> searchByYear = book -> {return book.getBookYearOfPublishing().toLowerCase().contains(userInput.toLowerCase());};

    public Searcher() {}

    public List<Book> getResultOfTheBookSearch(List<Book> allBooksList) {
        switch (searchCriteria) {
            case "byTitle":
                return allBooksList.stream().filter(searchByTitle)
                        .collect(Collectors.toList());
            case "byAuthor":
                return allBooksList.stream().filter(searchByAuthor)
                        .collect(Collectors.toList());
            case "byYear":
                return allBooksList.stream().filter(searchByYear)
                        .collect(Collectors.toList());
            default:
                return allBooksList.stream().filter(searchByTitle)
                        .collect(Collectors.toList());
        }

    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
}
