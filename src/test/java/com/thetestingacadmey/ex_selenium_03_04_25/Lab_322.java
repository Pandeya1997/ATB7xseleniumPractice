package com.thetestingacadmey.ex_selenium_03_04_25;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Lab_322 {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    @Description("The Test Case Describe Arlt confomation  message Accept / cancel ")
    public void Herokupap() {
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println("Title" + driver.getTitle());
        //button[onclick="jsConfirm()"]
        WebElement element_Confirm = driver.findElement(By.cssSelector("button[onclick=\"jsConfirm()\"]"));
        element_Confirm.click();
        // AWS , Docker,
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        //  alert.accept();
        alert.dismiss();

        String result = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(result, "You clicked: Cancel");

    }

    @AfterSuite
    public void ClosedBrowser() {
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
