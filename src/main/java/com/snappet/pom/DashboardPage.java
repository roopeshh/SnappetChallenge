package com.snappet.pom;

import com.snappet.utilities.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    @FindBy(xpath = "//a[@title='Home']")
    public static WebElement HOME_TAB;

    @FindBy(xpath = "//span[contains(text(),'Lessons')]")
    public static WebElement LESSONS_TAB;

    @FindBy(xpath = "//span[contains(text(),'Working Sets')]")
    public static WebElement WORKINGSET_TAB;

    @FindBy(xpath = "//span[contains(text(),'Monitor')]")
    public static WebElement MONITOR_TAB;

    @FindBy(xpath = "//span[contains(text(),'Reports')]")
    public static WebElement REPORTS_TAB;

    @FindBy(xpath = "//a[@class='btn btn-default btn-round btn-icon search']")
    public static WebElement SEARCH_BTN;

    @FindBy(xpath = "//a[@class='btn btn-default btn-submenu dropdown']")
    public static WebElement USER_MENU;

    @FindBy(xpath = "//div[@class='heading']")
    public static WebElement TEACHER_NAME;

    @FindBy(xpath = "//button[@type='button']")
    public static WebElement ACTIVITY_FROM_TODAY_BTN;

    @FindBy(xpath = "//span[@data-bind='text: addSubjectGroupLabel']")
    public static WebElement ACTIVATE_SUBJECT_BTN;

    @FindBy(xpath = "//a[@class='negative']")
    public static WebElement LOGOUT_OPTION;

    @FindBy(xpath = "//span[@data-bind='text: Strings.Edit']")
    public static WebElement EDIT_SUBJECT;

    @FindBy(xpath = "//span[@data-bind='text: Strings.RemoveSubject']")
    public static WebElement REMOVE_SUBJECT;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    public static WebElement REMOVE_BUTTON;

    @FindBy(xpath = "/html[1]/body[1]/script[8]")
    public static WebElement REMOVE_MESSAGE;

    public DashboardPage() {
        PageFactory.initElements(Helper.getDriver(), this);
    }

    public static WebElement getElement(String option) {
        WebElement element = null;
        switch (option) {
            case "activate subject button":
                element = ACTIVATE_SUBJECT_BTN;
                break;
            case "lessons tab":
                element = LESSONS_TAB;
                break;

            case "user icon":
                element = USER_MENU;
                break;

            case "logout button":
                element = LOGOUT_OPTION;
                break;
        }
        return element;
    }
}
