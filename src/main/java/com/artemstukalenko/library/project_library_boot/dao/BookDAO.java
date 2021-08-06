package com.artemstukalenko.library.project_library_boot.dao;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import java.util.List;

public interface BookDAO {

    public List<Book> getAllBooks();

    public void deleteBook(int bookId);

    public void addNewBook(Book bookToAdd);

    public Book findBookById(int bookId);

    public void setTaken(int id, boolean taken);
}
