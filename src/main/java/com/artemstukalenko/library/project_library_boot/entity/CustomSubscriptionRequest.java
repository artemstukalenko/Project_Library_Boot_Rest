package com.artemstukalenko.library.project_library_boot.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "custom_subscription_requests")
public class CustomSubscriptionRequest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customSubscriptionId;
    @Column(name = "username")
    private String username;
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "book_title")
    private String title;
    @Column(name = "book_author")
    private String author;
    @Column(name = "start_of_the_period")
    private LocalDate startOfThePeriod;
    @Column(name = "end_of_the_period")
    private LocalDate endOfThePeriod;

    public CustomSubscriptionRequest() {}

    public CustomSubscriptionRequest(String username, int bookId, String title, String author, LocalDate startOfThePeriod, LocalDate endOfThePeriod) {
        this.username = username;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.startOfThePeriod = startOfThePeriod;
        this.endOfThePeriod = endOfThePeriod;
    }

    public int getCustomSubscriptionId() {
        return customSubscriptionId;
    }

    public void setCustomSubscriptionId(int customSubscriptionId) {
        this.customSubscriptionId = customSubscriptionId;
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

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    @Override
    public String toString() {
        return "CustomSubscriptionRequestService{" +
                "customSubscriptionId=" + customSubscriptionId +
                ", username='" + username + '\'' +
                ", bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", startOfThePeriod=" + startOfThePeriod +
                ", endOfThePeriod=" + endOfThePeriod +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomSubscriptionRequest that = (CustomSubscriptionRequest) o;
        return customSubscriptionId == that.customSubscriptionId && bookId == that.bookId && username.equals(that.username) && title.equals(that.title) && author.equals(that.author) && startOfThePeriod.equals(that.startOfThePeriod) && endOfThePeriod.equals(that.endOfThePeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customSubscriptionId, username, bookId, title, author, startOfThePeriod, endOfThePeriod);
    }
}
