package com.artemstukalenko.library.project_library_boot.dao;

import com.artemstukalenko.library.project_library_boot.entity.Book;

import javax.persistence.EntityManager;
import java.util.List;

public interface BookDAO {

    public List<Book> getAllBooks();

    public boolean deleteBook(int bookId);

    public boolean addNewBook(Book bookToAdd);

    public Book findBookById(int bookId);

    public boolean setTaken(int id, boolean taken);
}
