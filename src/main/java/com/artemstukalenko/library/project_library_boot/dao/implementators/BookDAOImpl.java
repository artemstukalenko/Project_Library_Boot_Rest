package com.artemstukalenko.library.project_library_boot.dao.implementators;

import com.artemstukalenko.library.project_library_boot.dao.BookDAO;
import com.artemstukalenko.library.project_library_boot.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Book> getAllBooks() {
        Query queryForGettingAllBooks = entityManager.createQuery("from Book");

        return queryForGettingAllBooks.getResultList();
    }

    @Override
    @Transactional
    public boolean deleteBook(int bookId) {
        Query queryForDeletingBook = entityManager.createQuery("delete from Book where bookId =: bookId");
        queryForDeletingBook.setParameter("bookId", bookId);

        queryForDeletingBook.executeUpdate();
        return true;
    }

    @Override
    @Transactional
    public boolean addNewBook(Book bookToAdd) {
        entityManager.persist(bookToAdd);
        return true;
    }

    @Override
    public Book findBookById(int bookId) {
        return entityManager.find(Book.class, bookId);
    }

    @Override
    @Transactional
    public boolean setTaken(int id, boolean takenToSet) {
        Query queryForSettingTaken = entityManager.createQuery("update Book set taken =: takenToSet where bookId =: id");
        queryForSettingTaken.setParameter("takenToSet", takenToSet);
        queryForSettingTaken.setParameter("id", id);

        queryForSettingTaken.executeUpdate();
        return findBookById(id).getTaken();
    }
}
