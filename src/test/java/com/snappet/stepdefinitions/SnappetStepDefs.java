package com.snappet.stepdefinitions;

import com.snappet.pom.*;
import com.snappet.utilities.Helper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class SnappetStepDefs {

    @Given("^I am on the (.*) page$")
    public void verifyPage(String name) {
        assertTrue(BasePage.validatePage(name));
    }

    @Then("(.*) is displayed on (.*) page$")
    public void elementIsDisplayed(String elementName, String pageName) throws Exception {
        WebElement element = Helper.getWebElementFromPage(pageName, elementName);
        assertTrue(Helper.isDisplayed(element));
    }

    @And("I click on (.*) on (.*) page$")
    public void click(String elementName, String pageName) throws Exception {
        WebElement element = Helper.getWebElementFromPage(pageName, elementName);
        Helper.click(element);
    }

    @And("activate the first subject")
    public void activateSubject() throws InterruptedException {
        assertTrue(Helper.isDisplayed(ActivateSubjectPage.QUESTION_TEXT_1));
        Helper.click(ActivateSubjectPage.SUBJECTS);
        Helper.click(ActivateSubjectPage.SUBJECTS_LIST.get(0));
        Helper.click(ActivateSubjectPage.NEXT_BTN);
        Thread.sleep(1000);
        Helper.click(ActivateSubjectPage.GROUP.get(0));
        Thread.sleep(1000);
        Helper.click(ActivateSubjectPage.NEXT_BTN);
        Thread.sleep(1000);
        Helper.click(ActivateSubjectPage.LESSONS.get(0));
        Helper.click(ActivateSubjectPage.ACTIVATE_SUBJECT_BTN);
        assertTrue(Helper.isDisplayed(DashboardPage.EDIT_SUBJECT));
    }

    @And("I login to the teacher dashboard")
    public void loginToTheApp() {
        LoginPage.login();
    }

    @And("I should find the lessons")
    public void verifyLessonFound() {
        assertTrue(Helper.isDisplayed(LessonsPage.SUBJECT_DROPDOWN));
    }

    @And("I should not find the lessons")
    public void verifyLessonNotFound() {
        assertTrue(Helper.isDisplayed(LessonsPage.GOTO_HOMEPAGE_BTN));
    }

    @Then("I delete the subject")
    public void deleteSubject() {
        Helper.click(DashboardPage.EDIT_SUBJECT);
        Helper.click(DashboardPage.REMOVE_SUBJECT);
        Helper.click(DashboardPage.REMOVE_BUTTON);
    }
}
