package com.artemstukalenko.library.project_library_boot.service;

import com.artemstukalenko.library.project_library_boot.dao.BookDAO;
import com.artemstukalenko.library.project_library_boot.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookDAO bookDAO;

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }
}
