package com.thetestingacadmey.ex_selenium_01_04_25_Wailt_type;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Selenium_wait {
    EdgeOptions options;
    WebDriver driver;

    @BeforeTest
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    @Description("Implicity Wait ")
    public void login() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Global Wait working in hold class , we will wait for 10 seconds  :- E1,E2,E3,E4... elements
        driver.get("https://www.ebay.com/");
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("macmini");
        WebElement sendButton = driver.findElement(By.cssSelector("span[class=\"gh-search-button__label\"]"));
        sendButton.click();

    }
    // Thread.Sleep(5000) --> JVM Stop 5 second then required to waits
// Whey do we Need waits in Selenium
    // Thread.sleep().JAVM to stop the execution
    // do that

    // Implicit Wait  - Bad
    // Implicit Wait, Explicit Wait, and Fluent Wait in Selenium

    // implicit Waits :- driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    // Explicit Wait
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example")));

    //  Fluent Wait
//    Wait<WebDriver> wait = new FluentWait<>(driver)
//            .withTimeout(Duration.ofSeconds(30))  // Maximum wait time
//            .pollingEvery(Duration.ofSeconds(5))  // Check every 5 seconds
//            .ignoring(NoSuchElementException.class); // Ignore specific exceptions
//
//    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("example")));


    @AfterTest
    public void closedBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


}

