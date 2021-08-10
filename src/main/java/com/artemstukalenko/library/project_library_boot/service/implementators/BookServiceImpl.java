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
    public boolean deleteBook(int bookId) {
        return bookDAO.deleteBook(bookId);
    }

    @Override
    public boolean addNewBook(Book bookToAdd) {
        return bookDAO.addNewBook(bookToAdd);
    }

    @Override
    public Book findBookById(int bookId) {
        return bookDAO.findBookById(bookId);
    }

    @Override
    public boolean setTaken(int id, boolean taken) {
        return bookDAO.setTaken(id, taken);
    }
}
