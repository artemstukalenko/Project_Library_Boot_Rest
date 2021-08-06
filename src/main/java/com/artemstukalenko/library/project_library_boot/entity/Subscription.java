package com.artemstukalenko.library.project_library_boot.entity;

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

    public Subscription(String username, int bookId) {
        this.username = username;
        this.bookId = bookId;
        this.startOfThePeriod = LocalDate.now();
        this.endOfThePeriod = LocalDate.now().plusMonths(1);
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
