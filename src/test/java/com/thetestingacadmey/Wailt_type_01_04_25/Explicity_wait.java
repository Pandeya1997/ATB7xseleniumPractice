package com.thetestingacadmey.Wailt_type_01_04_25;


import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Explicity_wait {
    public static void main(String[] args) {
        WebDriver driver;
        EdgeOptions options;
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // implicitly wait work globally for all web Elements Applied
        String URL = "https://www.facebook.com/login.php/";
        driver.get(URL);
        WebElement EmailID = driver.findElement(By.id("email"));
        WebElement Password = driver.findElement(By.id("pass"));

        SendKey(driver, EmailID, 10, "Abhi@Abhi.com");
        SendKey(driver, Password, 5, "Pass@123");

        WebElement LoginButton = driver.findElement(By.id("loginbutton"));
        ClickButton(driver, LoginButton, 10);
    }

    public static void SendKey(WebDriver driver, WebElement element, int timeout, String value) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value); // corrected
    }

    public static void ClickButton(WebDriver driver, WebElement element, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click(); // corrected
    }
}
