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

public class Lab_323_conformation_Promtp {
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
    @Description("The Test Case Describe Arlt conformation_Promtp ")
    public void element_Promtp() throws Exception {
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println("Title" + driver.getTitle());
        //button[onclick="jsConfirm()"]
        WebElement element_Promtp = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));

        element_Promtp.click();
        Thread.sleep(5000);

        // AWS , Docker,
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Abhhishek");
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(result, "You entered: Abhhishek");

        System.out.println(result);

    }

    @AfterSuite
    public void ClosedBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
