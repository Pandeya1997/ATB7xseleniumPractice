package com.thetestingacadmey.ActionClass_29_04_25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import java.time.Duration;
import java.util.List;

public class MakeMyTripTest {
    EdgeOptions options;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        // initialize explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(testName = "QA")
    @Description("Open MakeMyTrip and input source location using Actions class with explicit wait.")
    public void Spicejet() {
        driver.get("https://www.makemytrip.com/railways/");

        // Wait for the fromCity input to be clickable
        WebElement fromCity = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("fromCity"))
        );

        // Use Actions to click & type
        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity)
                .click()
                .sendKeys("New Delhi")
                .build()
                .perform();

        // Wait for the suggestion list UL to appear
        By suggestionsListLocator = By.cssSelector("ul.react-autosuggest__suggestion-list li");
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsListLocator));

        // Fetch all suggestions
        List<WebElement> listAutoComplete = driver.findElements(suggestionsListLocator);
        for (WebElement e : listAutoComplete) {
            if (e.getText().contains("New Delhi")) {
                e.click();
                break;
            }
        }
    }

    @AfterSuite
    public void CloseBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

