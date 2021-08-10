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
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public void deleteBook(int bookId) {
        bookDAO.deleteBook(bookId);
    }

    @Override
    public void addNewBook(Book bookToAdd) {
        bookDAO.addNewBook(bookToAdd);
    }

    @Override
    public Book findBookById(int bookId) {
        return bookDAO.findBookById(bookId);
    }

    @Override
    public void setTaken(int id, boolean taken) {
        bookDAO.setTaken(id, taken);
    }
}
