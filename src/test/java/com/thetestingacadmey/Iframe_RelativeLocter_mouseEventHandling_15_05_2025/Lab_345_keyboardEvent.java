package com.thetestingacadmey.Iframe_RelativeLocter_mouseEventHandling_15_05_2025;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab_345_keyboardEvent {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(groups = "QA")
    @Description("Verify validation message when email is not entered on login screen")
    public void openPage() throws InterruptedException {
        driver.get("https://ui-scoreboard.maharaj365.in/login");

        // Switch to iframe
        // driver.switchTo().frame("result");

        // Wait for and click the button
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='button']")));
        button.click();

        // Allow time for the validation message to appear
        Thread.sleep(3000);

        // Locate the email input field and the error message below it
        WebElement emailInput = driver.findElement(By.id("cust_user_id"));
        WebElement errorElement = driver.findElement(with(By.tagName("div")).below(emailInput));

        // Get and assert the validation message
        String errorText = errorElement.getText();
        System.out.println("Validation message: " + errorText);
        Assert.assertEquals(errorText, "Please enter your Email.");
    }

    @AfterSuite
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(4000); // Better to avoid Thread.sleep and use waits if possible
        driver.quit();
        System.out.println("All Test Cases Passed");
    }
}