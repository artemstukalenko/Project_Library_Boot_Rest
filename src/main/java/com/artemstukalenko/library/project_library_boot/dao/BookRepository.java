package com.artemstukalenko.library.project_library_boot.dao;

import com.artemstukalenko.library.project_library_boot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

//    public boolean setTakenValue(int bookId);

}
