package com.snappet.pom;

import com.snappet.utilities.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LessonsPage {

    //When empty
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public static WebElement GOTO_HOMEPAGE_BTN;

    //When there are lessons
    @FindBy(xpath = "//span[@id='select2-xs7r-container']")
    public static WebElement SUBJECT_DROPDOWN;

    @FindBy(xpath = "//span[@data-bind='text: Strings.MoreFirstUpper']")
    public static WebElement MORE_OPTION;

    @FindBy(xpath = "//span[@data-bind='text: Strings.AddCourse']")
    public static WebElement ADD_COURSE_BTN;

    public LessonsPage() {
        PageFactory.initElements(Helper.getDriver(), this);
    }

}
