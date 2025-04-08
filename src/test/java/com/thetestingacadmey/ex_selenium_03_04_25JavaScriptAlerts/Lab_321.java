package com.thetestingacadmey.ex_selenium_03_04_25JavaScriptAlerts;

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

public class Lab_321 {
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
    @Description("The Test Case Describe Arlt message click ")
    public void Herokupap() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println("Title" + driver.getTitle());
        // button[onclick="jsAlert()"]
        WebElement element_Alert = driver.findElement(By.cssSelector("button[onclick=\"jsAlert()\"]"));
        element_Alert.click();

        // AWS , Docker,
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You successfully clicked an alert");

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
