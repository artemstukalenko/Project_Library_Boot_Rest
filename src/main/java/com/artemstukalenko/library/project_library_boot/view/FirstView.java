package com.artemstukalenko.library.project_library_boot.view;

import org.springframework.beans.factory.annotation.Value;

import java.util.Locale;
import java.util.ResourceBundle;

public class FirstView {

    public static final String RESOURCE_BUNDLE_NAME = "messages";
    public static ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, new Locale("en", "EN"));

    public static String usersListString = bundle.getString(TextConstants.USERS_LIST_STRING);
    public static String seeUsersList = bundle.getString(TextConstants.SEE_USERS_LIST);
    public static String seeBooksList = bundle.getString(TextConstants.SEE_BOOK_LIST);
    public static String booksListString = bundle.getString(TextConstants.BOOK_LIST_STRING);
    public static String toHomePage = bundle.getString(TextConstants.TO_HOME_PAGE);
    public static String seeSubscriptionsList = bundle.getString(TextConstants.SEE_SUBSCRIPTIONS_LIST);
    public static String subscriptionsListString = bundle.getString(TextConstants.SUBSCRIPTIONS_LIST_STRING);

    public static String blockButton = bundle.getString(TextConstants.BLOCK_BUTTON);
    public static String unblockButton = bundle.getString(TextConstants.UNBLOCK_BUTTON);
    public static String usernameTableHeader = bundle.getString(TextConstants.USERNAME_TABLE_HEADER);
    public static String statusTableHeader = bundle.getString(TextConstants.STATUS_TABLE_HEADER);
    public static String userBlocked = bundle.getString(TextConstants.USER_BLOCKED);
    public static String userNotBlocked = bundle.getString(TextConstants.USER_NOT_BLOCKED);
    public static String userFirstName = bundle.getString(TextConstants.USER_FIRST_NAME);
    public static String userLastName = bundle.getString(TextConstants.USER_LAST_NAME);
    public static String userEmail = bundle.getString(TextConstants.USER_EMAIL);
    public static String userPhoneNumber = bundle.getString(TextConstants.USER_PHONE_NUMBER);
    public static String userAddress = bundle.getString(TextConstants.USER_ADDRESS);

    public static String bookId = bundle.getString(TextConstants.BOOK_ID);
    public static String bookTitle = bundle.getString(TextConstants.BOOK_TITLE);
    public static String bookAuthor = bundle.getString(TextConstants.BOOK_AUTHOR);
    public static String bookYearOfPublishing = bundle.getString(TextConstants.BOOK_YEAR_OF_PUBLISHING);

    public static String loginUsername = bundle.getString(TextConstants.LOGIN_USERNAME);
    public static String loginPassword = bundle.getString(TextConstants.LOGIN_PASSWORD);
    public static String loginWelcome = bundle.getString(TextConstants.LOGIN_WELCOME);
    public static String loginButton = bundle.getString(TextConstants.LOGIN_BUTTON);

    public static String registration = bundle.getString(TextConstants.REGISTRATION);

    public static void initStringFields(ResourceBundle bundle) {
        usersListString = bundle.getString(TextConstants.USERS_LIST_STRING);
        seeUsersList = bundle.getString(TextConstants.SEE_USERS_LIST);
        seeBooksList = bundle.getString(TextConstants.SEE_BOOK_LIST);
        booksListString = bundle.getString(TextConstants.BOOK_LIST_STRING);
        toHomePage = bundle.getString(TextConstants.TO_HOME_PAGE);
        seeSubscriptionsList = bundle.getString(TextConstants.SEE_SUBSCRIPTIONS_LIST);
        subscriptionsListString = bundle.getString(TextConstants.SUBSCRIPTIONS_LIST_STRING);

        blockButton = bundle.getString(TextConstants.BLOCK_BUTTON);
        unblockButton = bundle.getString(TextConstants.UNBLOCK_BUTTON);
        usernameTableHeader = bundle.getString(TextConstants.USERNAME_TABLE_HEADER);
        statusTableHeader = bundle.getString(TextConstants.STATUS_TABLE_HEADER);
        userBlocked = bundle.getString(TextConstants.USER_BLOCKED);
        userNotBlocked = bundle.getString(TextConstants.USER_NOT_BLOCKED);
        userFirstName = bundle.getString(TextConstants.USER_FIRST_NAME);
        userLastName = bundle.getString(TextConstants.USER_LAST_NAME);
        userEmail = bundle.getString(TextConstants.USER_EMAIL);
        userPhoneNumber = bundle.getString(TextConstants.USER_PHONE_NUMBER);
        userAddress = bundle.getString(TextConstants.USER_ADDRESS);

        bookId = bundle.getString(TextConstants.BOOK_ID);
        bookTitle = bundle.getString(TextConstants.BOOK_TITLE);
        bookAuthor = bundle.getString(TextConstants.BOOK_AUTHOR);
        bookYearOfPublishing = bundle.getString(TextConstants.BOOK_YEAR_OF_PUBLISHING);

        loginUsername = bundle.getString(TextConstants.LOGIN_USERNAME);
        loginPassword = bundle.getString(TextConstants.LOGIN_PASSWORD);
        loginWelcome = bundle.getString(TextConstants.LOGIN_WELCOME);
        loginButton = bundle.getString(TextConstants.LOGIN_BUTTON);

        registration = bundle.getString(TextConstants.REGISTRATION);
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
}
