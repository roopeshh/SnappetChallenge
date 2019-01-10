package com.snappet.pom;

import com.snappet.utilities.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActivateSubjectPage {

    @FindBy(xpath = "//a[contains(@class,'close-modal')]")
    public static WebElement CLOSE_BTN;

    @FindBy(xpath = "//h2[@data-bind='text: Strings.WhichSubjectToAdd']")
    public static WebElement QUESTION_TEXT_1;

    @FindBy(xpath = "//div[@class='row']")
    public static WebElement SUBJECTS;

    @FindBy(xpath = "//subjects-dropdown[1]/span[1]/span[1]/span[2]/ul[1]/li")
    public static List<WebElement> SUBJECTS_LIST;

    @FindBy(xpath = "//a[contains(@class,'btn btn-primary')]")
    public static WebElement NEXT_BTN;

    @FindBy(xpath = "//h2[@data-bind='text: Strings.WhatLevelWillClassWork']")
    public static WebElement QUESTION_TEXT_2;

    @FindBy(xpath = "//div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div")
    public static List<WebElement> GROUP;

    @FindBy(xpath = "//div[@class='card-inner']")
    public static List<WebElement> LESSONS;

    @FindBy(xpath = "//input[@type='text']")
    public static WebElement SUBJECT_NAME;

    @FindBy(xpath = "//button[contains(text(),'Activate subject')]")
    public static WebElement ACTIVATE_SUBJECT_BTN; //List

    public ActivateSubjectPage() {
        PageFactory.initElements(Helper.getDriver(), this);
    }

}
