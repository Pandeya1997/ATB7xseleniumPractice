package com.thetestingacadmey.ex_selenium_01_04_25_Wailt_type;
import io.qameta.allure.Description; // Correct import for Allure reporting
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab_319_Wait_helper {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {  //
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");  //
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void VWOLogin() {
        driver.get("https://app.vwo.com/#/login");
        System.out.println("Page Title: " + driver.getTitle());

        driver.findElement(By.id("login-username")).sendKeys("contact+atb7x@thetestingacademy.com");
        driver.findElement(By.id("login-password")).sendKeys("Wingify@1234");
        driver.findElement(By.id("js-login-btn")).click();

        // Wait for the element to be visible
        checkVisibility(driver, By.cssSelector("[data-qa='lufexuloga']"));
    }

    public void checkVisibility(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  //
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        System.out.println("Element is visible: "+ element.isDisplayed());
    }

    @AfterSuite
    public void ClosedBrowser() {
        driver.quit();
    }
}
