package com.snappet.pom;

import com.snappet.utilities.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "/html/body/div[1]/article")
    public static WebElement LOGIN_PAGE_FORM;

    @FindBy(id = "UserName")
    public static WebElement USERNAME;

    @FindBy(id = "Password")
    public static WebElement PASSWORD;

    @FindBy(xpath = "//button[@type='submit']")
    public static WebElement LOGIN_BUTTON;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[3]/a")
    public static WebElement FORGOT_PASSWORD;

    public static final String URL = "https://teacher.snappet.org/";

    public static final String USERNAME_VALUE = "ChallengeTeacher1";

    public static final String PASSWORD_VALUE = "*7jdfD%^st0";

    public LoginPage() {
        PageFactory.initElements(Helper.getDriver(), this);
    }

    public static WebElement getElement(String name) {
        WebElement element = null;
        switch (name) {
            case "username field":
                element = USERNAME;
                break;
            case "password field":
                element = PASSWORD;
                break;
            case "login button":
                element = LOGIN_BUTTON;
                break;
        }
        return element;
    }

    public static void login() {
        Helper.enterText(USERNAME, USERNAME_VALUE);
        Helper.enterText(PASSWORD, PASSWORD_VALUE);
        Helper.click(LOGIN_BUTTON);
    }
}
