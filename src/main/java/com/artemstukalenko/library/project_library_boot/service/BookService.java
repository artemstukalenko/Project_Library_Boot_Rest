package com.artemstukalenko.library.project_library_boot.service;

import com.artemstukalenko.library.project_library_boot.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();

    public void deleteBook(int bookId);

    public void addNewBook(Book bookToAdd);

}
