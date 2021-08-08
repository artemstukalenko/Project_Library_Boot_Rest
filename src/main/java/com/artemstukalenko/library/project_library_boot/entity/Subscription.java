package com.artemstukalenko.library.project_library_boot.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

//@Component
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriptionId;
    @Column(name = "username")
    private String username;
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "book_title")
    private String title;
    @Column(name = "book_author")
    private String author;
    @Column(name = "start_of_the_period")
    private final LocalDate startOfThePeriod;
    @Column(name = "end_of_the_period")
    private final LocalDate endOfThePeriod;
    @Column(name = "expired")
    private boolean expired;

    public Subscription() {
        this.startOfThePeriod = LocalDate.now();
        this.endOfThePeriod = LocalDate.now().plusMonths(1);
    }

    public Subscription(String username, int bookId, String title, String author) {
        this.username = username;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.startOfThePeriod = LocalDate.now();
        this.endOfThePeriod = LocalDate.now().plusMonths(1);
    }

    public Subscription(String username, int bookId, String title, String author,
                        LocalDate startOfThePeriod, LocalDate endOfThePeriod) {
        this.username = username;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.startOfThePeriod = startOfThePeriod;
        this.endOfThePeriod = endOfThePeriod;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBook(Book book) {
        this.bookId = book.getBookId();
    }

    public LocalDate getStartOfThePeriod() {
        return startOfThePeriod;
    }

    public LocalDate getEndOfThePeriod() {
        return endOfThePeriod;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public boolean getExpired() {
        return LocalDate.now().isAfter(endOfThePeriod);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "username='" + username + '\'' +
                ", bookId=" + bookId +
                ", startOfThePeriod=" + startOfThePeriod +
                ", endOfThePeriod=" + endOfThePeriod +
                '}';
    }
}
