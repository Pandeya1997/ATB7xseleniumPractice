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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.time.Duration;

public class Lab_318 {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }
    @Test(groups = "QA")
    @Description("Explicit wait test")
    public void VWOLogin(){
        // Explicit Wait
        driver.get("https://app.vwo.com/#/login");
        String Title = driver.getTitle();
        System.out.println("VWO Login Title:- " + Title);
        driver.findElement(By.id("login-username")).sendKeys("contact+atb7x@thetestingacademy.com");
        driver.findElement(By.id("login-password")).sendKeys("Wingify@1234");
        driver.findElement(By.id("js-login-btn")).click();
// wait for DashBoard to load
        //  span[data-qa="lufexuloga"]
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-qa=\"lufexuloga\"]")));
// Find the WebElement
        WebElement LogginUserName = driver.findElement(By.cssSelector("span[data-qa=\"lufexuloga\"]"));
        String Username = LogginUserName.getText();
// Print
        System.out.println(Username);
        //or
        System.out.println(driver.findElements(By.cssSelector("span[data-qa=\"lufexuloga\"]")).get(0).getText());
        Assert.assertEquals(Username, "Aman Ji");


    }

    @AfterSuite
    public void ClosedBroser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

}
