package com.artemstukalenko.library.project_library_boot.utility;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Sorter {

    private String sortMethod;

    private Comparator<Book> byTitle = (b1, b2) -> {return b1.getBookTitle().compareTo(b2.getBookTitle());};
    private Comparator<Book> byAuthor = (b1, b2) -> {return b1.getBookAuthor().compareTo(b2.getBookAuthor());};
    private Comparator<Book> byYear = (b1, b2) -> {return b1.getBookYearOfPublishing().compareTo(b2.getBookYearOfPublishing());};

    public Sorter() {}

    public List<Book> sortList(List<Book> listToSort) {
        switch (sortMethod) {
            case "byTitle":
                return listToSort.stream().sorted(byTitle)
                        .collect(Collectors.toList());
            case "byAuthor":
                return listToSort.stream().sorted(byAuthor)
                        .collect(Collectors.toList());
            case "byYear":
                return listToSort.stream().sorted(byYear)
                        .collect(Collectors.toList());
            default:
                return listToSort.stream().sorted(byTitle)
                        .collect(Collectors.toList());
        }
    }

    public String getSortMethod() {
        return sortMethod;
    }

    public void setSortMethod(String sortMethod) {
        this.sortMethod = sortMethod;
    }
}
