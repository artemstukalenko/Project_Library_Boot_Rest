package com.artemstukalenko.library.project_library_boot.view;

import org.springframework.stereotype.Component;

import static com.artemstukalenko.library.project_library_boot.view.TextConstants.*;

import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class FirstView {

    public static final String RESOURCE_BUNDLE_NAME = "messages";
    public static ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, new Locale("en", "EN"));

    public static String usersListString = bundle.getString(USERS_LIST_STRING);
    public static String seeUsersList = bundle.getString(SEE_USERS_LIST);
    public static String seeBooksList = bundle.getString(SEE_BOOK_LIST);
    public static String booksListString = bundle.getString(BOOK_LIST_STRING);
    public static String toHomePage = bundle.getString(TO_HOME_PAGE);
    public static String seeSubscriptionsList = bundle.getString(SEE_SUBSCRIPTIONS_LIST);
    public static String subscriptionsListString = bundle.getString(SUBSCRIPTIONS_LIST_STRING);

    public static String deleteUserButton = bundle.getString(DELETE_USER_BUTTON);
    public static String blockButton = bundle.getString(BLOCK_BUTTON);
    public static String unblockButton = bundle.getString(UNBLOCK_BUTTON);
    public static String usernameTableHeader = bundle.getString(USERNAME_TABLE_HEADER);
    public static String statusTableHeader = bundle.getString(STATUS_TABLE_HEADER);
    public static String userBlocked = bundle.getString(USER_BLOCKED);
    public static String userNotBlocked = bundle.getString(USER_NOT_BLOCKED);
    public static String userFirstName = bundle.getString(USER_FIRST_NAME);
    public static String userLastName = bundle.getString(USER_LAST_NAME);
    public static String userEmail = bundle.getString(USER_EMAIL);
    public static String userPhoneNumber = bundle.getString(USER_PHONE_NUMBER);
    public static String userAddress = bundle.getString(USER_ADDRESS);
    public static String userPenalty = bundle.getString(USER_PENALTY);

    public static String bookId = bundle.getString(BOOK_ID);
    public static String bookTitle = bundle.getString(BOOK_TITLE);
    public static String bookAuthor = bundle.getString(BOOK_AUTHOR);
    public static String bookYearOfPublishing = bundle.getString(BOOK_YEAR_OF_PUBLISHING);
    public static String addNewBook = bundle.getString(ADD_NEW_BOOK);
    public static String deleteBook = bundle.getString(DELETE_BOOK);
    public static String showAllBooksButton = bundle.getString(SHOW_ALL_BOOKS_BUTTON);

    public static String loginUsername = bundle.getString(LOGIN_USERNAME);
    public static String loginPassword = bundle.getString(LOGIN_PASSWORD);
    public static String loginWelcome = bundle.getString(LOGIN_WELCOME);
    public static String loginButton = bundle.getString(LOGIN_BUTTON);

    public static String registration = bundle.getString(REGISTRATION);
    public static String logoutButton = bundle.getString(LOGOUT_BUTTON);

    public static String loggedInAs = bundle.getString(LOGGED_IN_AS);

    public static String subscriptionId = bundle.getString(SUBSCRIPTION_ID);
    public static String arrangeSubscriptionButton = bundle.getString(ARRANGE_SUBSCRIPTION_BUTTON);
    public static String viewSubscriptionsButton = bundle.getString(VIEW_SUBSCRIPTIONS_BUTTON);
    public static String yourSubscriptions = bundle.getString(YOUR_SUBSCRIPTIONS);
    public static String startOfThePeriod = bundle.getString(START_OF_THE_PERIOD);
    public static String endOfThePeriod = bundle.getString(END_OF_THE_PERIOD);
    public static String isExpired = bundle.getString(IS_EXPIRED);

    public static String search = bundle.getString(SEARCH);
    public static String filter = bundle.getString(FILTER);
    public static String filterByTitle = bundle.getString(FILTER_BY_TITLE);
    public static String filterByAuthor = bundle.getString(FILTER_BY_AUTHOR);
    public static String filterByYear = bundle.getString(FILTER_BY_YEAR);

    public static void initStringFields(ResourceBundle bundle) {
        usersListString = bundle.getString(USERS_LIST_STRING);
        seeUsersList = bundle.getString(SEE_USERS_LIST);
        seeBooksList = bundle.getString(SEE_BOOK_LIST);
        booksListString = bundle.getString(BOOK_LIST_STRING);
        toHomePage = bundle.getString(TO_HOME_PAGE);
        seeSubscriptionsList = bundle.getString(SEE_SUBSCRIPTIONS_LIST);
        subscriptionsListString = bundle.getString(SUBSCRIPTIONS_LIST_STRING);

        deleteUserButton = bundle.getString(DELETE_USER_BUTTON);
        blockButton = bundle.getString(BLOCK_BUTTON);
        unblockButton = bundle.getString(UNBLOCK_BUTTON);
        usernameTableHeader = bundle.getString(USERNAME_TABLE_HEADER);
        statusTableHeader = bundle.getString(STATUS_TABLE_HEADER);
        userBlocked = bundle.getString(USER_BLOCKED);
        userNotBlocked = bundle.getString(USER_NOT_BLOCKED);
        userFirstName = bundle.getString(USER_FIRST_NAME);
        userLastName = bundle.getString(USER_LAST_NAME);
        userEmail = bundle.getString(USER_EMAIL);
        userPhoneNumber = bundle.getString(USER_PHONE_NUMBER);
        userAddress = bundle.getString(USER_ADDRESS);
        userPenalty = bundle.getString(USER_PENALTY);

        bookId = bundle.getString(BOOK_ID);
        bookTitle = bundle.getString(BOOK_TITLE);
        bookAuthor = bundle.getString(BOOK_AUTHOR);
        bookYearOfPublishing = bundle.getString(BOOK_YEAR_OF_PUBLISHING);
        addNewBook = bundle.getString(ADD_NEW_BOOK);
        deleteBook = bundle.getString(DELETE_BOOK);
        showAllBooksButton = bundle.getString(SHOW_ALL_BOOKS_BUTTON);

        loginUsername = bundle.getString(LOGIN_USERNAME);
        loginPassword = bundle.getString(LOGIN_PASSWORD);
        loginWelcome = bundle.getString(LOGIN_WELCOME);
        loginButton = bundle.getString(LOGIN_BUTTON);

        registration = bundle.getString(REGISTRATION);
        logoutButton = bundle.getString(LOGOUT_BUTTON);

        loggedInAs = bundle.getString(LOGGED_IN_AS);

        subscriptionId = bundle.getString(SUBSCRIPTION_ID);
        arrangeSubscriptionButton = bundle.getString(ARRANGE_SUBSCRIPTION_BUTTON);
        viewSubscriptionsButton = bundle.getString(VIEW_SUBSCRIPTIONS_BUTTON);
        yourSubscriptions = bundle.getString(YOUR_SUBSCRIPTIONS);
        startOfThePeriod = bundle.getString(START_OF_THE_PERIOD);
        endOfThePeriod = bundle.getString(END_OF_THE_PERIOD);
        isExpired = bundle.getString(IS_EXPIRED);

        search = bundle.getString(SEARCH);
        filter = bundle.getString(FILTER);
        filterByTitle = bundle.getString(FILTER_BY_TITLE);
        filterByAuthor = bundle.getString(FILTER_BY_AUTHOR);
        filterByYear = bundle.getString(FILTER_BY_YEAR);
    }

    public FirstView() {}

    public static void changeLanguageToUa() {
        bundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, new Locale("ua", "UA"));

        initStringFields(bundle);
    }

    public static void changeLanguageToEn() {
        bundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, new Locale("en", "EN"));

        initStringFields(bundle);
    }

    public String getUsersListString() {return usersListString;}

    public String getSeeUsersList() {return seeUsersList;}

    public String getSeeBooksList() {return seeBooksList;}

    public String getBooksListString() {return booksListString;}

    public String getToHomePage() {return toHomePage;}

    public String getSeeSubscriptionsList() {return seeSubscriptionsList;}

    public String getSubscriptionsListString() {return subscriptionsListString;}

    public String getBlockButton() {
        return blockButton;
    }

    public String getUnblockButton() {
        return unblockButton;
    }

    public String getUsernameTableHeader() {
        return usernameTableHeader;
    }

    public String getStatusTableHeader() {
        return statusTableHeader;
    }

    public String getUserBlocked() {
        return userBlocked;
    }

    public String getUserNotBlocked() {
        return userNotBlocked;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookYearOfPublishing() {
        return bookYearOfPublishing;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getLoginWelcome() {
        return loginWelcome;
    }

    public String getLoginButton() {
        return loginButton;
    }

    public String getRegistration() {
        return registration;
    }

    public String getDeleteUserButton() {
        return deleteUserButton;
    }

    public String getLoggedInAs() {
        return loggedInAs;
    }

    public String getAddNewBook() {
        return addNewBook;
    }

    public String getDeleteBook() {
        return deleteBook;
    }

    public String getUserPenalty() {
        return userPenalty;
    }

    public String getViewSubscriptionsButton() {
        return viewSubscriptionsButton;
    }

    public String getYourSubscriptions() {
        return yourSubscriptions;
    }

    public String getStartOfThePeriod() {
        return startOfThePeriod;
    }

    public String getEndOfThePeriod() {
        return endOfThePeriod;
    }

    public String getIsExpired() {
        return isExpired;
    }

    public String getArrangeSubscriptionButton() {
        return arrangeSubscriptionButton;
    }

    public String getLogoutButton() {
        return logoutButton;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public String getFilter() {
        return filter;
    }

    public String getFilterByTitle() {
        return filterByTitle;
    }

    public String getFilterByAuthor() {
        return filterByAuthor;
    }

    public String getFilterByYear() {
        return filterByYear;
    }

    public String getSearch() {
        return search;
    }

    public String getShowAllBooksButton() {
        return showAllBooksButton;
    }
}
