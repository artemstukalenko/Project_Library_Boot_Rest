package com.artemstukalenko.library.project_library_boot.service.implementators;

import com.artemstukalenko.library.project_library_boot.dao.BookDAO;
import com.artemstukalenko.library.project_library_boot.entity.Book;
import com.artemstukalenko.library.project_library_boot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDAO bookDAO;

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    @Transactional
    public void deleteBook(int bookId) {
        bookDAO.deleteBook(bookId);
    }

    @Override
    @Transactional
    public void addNewBook(Book bookToAdd) {
        bookDAO.addNewBook(bookToAdd);
    }

    @Override
    @Transactional
    public Book findBookById(int bookId) {
        return bookDAO.findBookById(bookId);
    }

    @Override
    @Transactional
    public void setTaken(int id, boolean taken) {
        bookDAO.setTaken(id, taken);
    }
}
