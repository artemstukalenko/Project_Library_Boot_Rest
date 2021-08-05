package com.artemstukalenko.library.project_library_boot.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
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
    @Column(name = "start_of_period")
    private LocalDate startOfThePeriod;
    @Column(name = "end_of_period")
    private LocalDate endOfThePeriod;

    public Subscription() {}

    public Subscription(Book book, LocalDate startOfThePeriod, LocalDate endOfThePeriod) {
        this.bookId = book.getBookId();
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

    public void setStartOfThePeriod(LocalDate startOfThePeriod) {
        this.startOfThePeriod = startOfThePeriod;
    }

    public LocalDate getEndOfThePeriod() {
        return endOfThePeriod;
    }

    public void setEndOfThePeriod(LocalDate endOfThePeriod) {
        this.endOfThePeriod = endOfThePeriod;
    }

    public int getSubscriptionId() {
        return subscriptionId;
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
