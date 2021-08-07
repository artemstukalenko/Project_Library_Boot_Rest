package com.artemstukalenko.library.project_library_boot.utility;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Searcher {
    String userInput;

    public Searcher() {}

    public List<Book> getResultOfTheBookSearch(List<Book> allBooksList) {
        return allBooksList.stream().filter(book -> {return book.getBookTitle().contains(userInput);})
                .collect(Collectors.toList());
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
}
