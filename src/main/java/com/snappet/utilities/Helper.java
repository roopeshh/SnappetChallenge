package com.snappet.utilities;

import com.snappet.pom.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {

    private static final int TIME_SECONDS = 10;
    private static WebDriver driver;


    public static void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperties().get("user.dir") + "/chromedriver");

        if (System.getProperty("browserType").equals("headless")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else {
            driver = new ChromeDriver();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void snapScreenShot(String result, String name, WebDriver driver) throws IOException {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = System.getProperties().get("user.dir") + "/screenshots";
        File directory = new File(fileName);
        if (!directory.exists()) {
            directory.mkdir();
        }
        fileName = fileName + "/" + name + "_" + result + ".jpg";
        File destinationFile = new File(fileName);
        FileHandler.copy(sourceFile, destinationFile);
    }

    public static void waitTillElementVisible(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, TIME_SECONDS);
        webDriverWait.ignoring(WebDriverException.class);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitTillElementClickable(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, TIME_SECONDS);
        webDriverWait.ignoring(WebDriverException.class);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean isDisplayed(WebElement element) {
        try {
            waitTillElementVisible(element);
        } catch (NoSuchElementException e) {
            System.out.println("NSE");
            return false;
        } catch (TimeoutException e) {
            System.out.println("TOE");
            return false;
        }
        return true;
    }

    public static void deleteFolderIfExists(String folderName) {
        Path folder = Paths.get(folderName);
        if (Files.exists(folder)) {
            FileHandler.delete(new File(folderName));
        }
    }

    public static void click(WebElement element) {
        waitTillElementClickable(element);
        element.click();
    }

    public static void enterText(WebElement element, String text) {
        waitTillElementVisible(element);
        element.sendKeys(text);
    }

    public static WebElement getWebElementFromPage(String pageName, String elementName) throws Exception {
        Class page = BasePage.getPageName(pageName);
        Method methodName = page.getMethod("getElement", String.class);
        Object pageInstance = page.newInstance();
        WebElement element = (WebElement) methodName.invoke(pageInstance, elementName);
        return element;
    }
}

