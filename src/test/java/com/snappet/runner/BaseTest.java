package com.snappet.runner;

import com.snappet.pom.ActivateSubjectPage;
import com.snappet.pom.DashboardPage;
import com.snappet.pom.LessonsPage;
import com.snappet.pom.LoginPage;
import com.snappet.utilities.Helper;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

@CucumberOptions(
        features = {"src/test/features/"},
        glue = {"com/snappet/stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber"}
)

public class BaseTest extends AbstractTestNGCucumberTests {

    private static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        Helper.initialiseDriver();
        driver = Helper.getDriver();

        new LoginPage();
        new DashboardPage();
        new ActivateSubjectPage();
        new LessonsPage();

        driver.get(LoginPage.URL);
        driver.manage().window().fullscreen();

        String screenshotFolder = System.getProperties().get("user.dir") + "/screenshots";
        Helper.deleteFolderIfExists(screenshotFolder);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Helper.snapScreenShot("FAIL", testResult.getName(), driver);
        }
        try {
            Helper.click(DashboardPage.HOME_TAB);
        } catch (Exception e) {
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }
}