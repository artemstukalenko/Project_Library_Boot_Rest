package com.artemstukalenko.library.project_library_boot.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int bookId;
    @Column(name = "title")
    private String bookTitle;
    @Column(name = "author")
    private String bookAuthor;
    @Column(name = "year_of_publishing")
    private String bookYearOfPublishing;


    public Book() {}

    public Book(String bookTitle, String bookAuthor, String bookYearOfPublishing) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYearOfPublishing = bookYearOfPublishing;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookYearOfPublishing() {
        return bookYearOfPublishing;
    }

    public void setBookYearOfPublishing(String bookYearOfPublishing) {
        this.bookYearOfPublishing = bookYearOfPublishing;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", booksYearOfPublishing=" + bookYearOfPublishing +
                '}';
    }
}
