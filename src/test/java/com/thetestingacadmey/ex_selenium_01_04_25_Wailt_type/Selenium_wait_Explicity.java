package com.thetestingacadmey.ex_selenium_01_04_25_Wailt_type;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

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
        driver.get("https://app.vwo.com/#/login");

//        WebElement UserName = driver.findElement(By.id("login-username"));
//        UserName.sendKeys("Admin@admin.com");
//        WebElement PasswordBox = driver.findElement(By.id("login-password"));
//        PasswordBox.sendKeys("Password@123");
        driver.findElement(By.id("login-username")).sendKeys("Login-username");
        driver.findElement(By.id("login-password")).sendKeys("Login-password");
        WebElement ClickButton = driver.findElement(By.cssSelector("span[data-qa=\"ezazsuguuy\"]"));
        ClickButton.click();

        WebElement error_msg = driver.findElement(By.cssSelector("[id= \"js-notification-box-msg\"]"));
//        Explicit Wait use
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(error_msg, "Your email, password, IP address or location did not match"));

        Assert.assertEquals(error_msg.getText(), "Your email, password, IP address or location did not match");
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

