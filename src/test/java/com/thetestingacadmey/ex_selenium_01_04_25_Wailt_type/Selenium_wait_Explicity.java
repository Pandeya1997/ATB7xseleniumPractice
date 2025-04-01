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

public class Selenium_wait_Explicity {
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
        // Explicity wait - e1, e2,e3 for 2 second then if e4 10 seconds
        driver.get("https://www.ebay.com/");
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("macmini");
        WebElement sendButton = driver.findElement(By.cssSelector("span[class=\"gh-search-button__label\"]"));
        sendButton.click();

    }
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

