package com.artemstukalenko.library.project_library_boot.dao;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<Book> getAllBooks() {
        Query queryForGettingAllBooks = entityManager.createQuery("from Book");

        return queryForGettingAllBooks.getResultList();
    }
}
