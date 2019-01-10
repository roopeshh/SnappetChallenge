package com.snappet.pom;

import com.snappet.utilities.Helper;

public class BasePage {
    public static boolean validatePage(String pageName) {
        switch (pageName) {
            case "login":
                return Helper.isDisplayed(LoginPage.LOGIN_PAGE_FORM);
            case "dashboard":
                return Helper.isDisplayed(DashboardPage.TEACHER_NAME);
            case "lessons":
                return Helper.isDisplayed(DashboardPage.LESSONS_TAB);
        }
        return false;
    }

    public static Class getPageName(String pageName) {
        Class page = null;
        switch (pageName) {
            case "login":
                page = LoginPage.class;
                break;
            case "dashboard":
                page = DashboardPage.class;
                break;
            case "lessons":
                page = LessonsPage.class;
                break;
        }
        return page;
    }

}
