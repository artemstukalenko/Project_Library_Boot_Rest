package com.artemstukalenko.library.project_library_boot.view;

import org.springframework.beans.factory.annotation.Value;

import java.util.Locale;
import java.util.ResourceBundle;

public class FirstView {

    public static final String RESOURCE_BUNDLE_NAME = "messages";
    public static ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, new Locale("en", "EN"));

    public static String usersListString;
    public static String seeUsersList;
    public static String seeBooksList;
    public static String booksListString;
    public static String toHomePage;
    public static String seeSubscriptionsList;
    public static String subscriptionsListString;
    public static String blockButton;
    public static String unblockButton;
    public static String usernameTableHeader;
    public static String statusTableHeader;

    static {
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
    }

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
}
