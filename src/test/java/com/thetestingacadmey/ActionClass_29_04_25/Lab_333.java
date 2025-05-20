package com.thetestingacadmey.ActionClass_29_04_25;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab_333 {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(testName = "SpiceJet Source Location Input")
    @Description("Open SpiceJet and input source location using Actions class with explicit wait.")
    public void Spicejet() {
        String URL = "https://www.spicejet.com/";
        driver.get(URL);

        // Explicit wait to wait until the element is visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement source = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@autocapitalize=\"sentences\"]")));
        // //input[@autocapitalize="sentences"]
        // Now safely perform Actions
        Actions actions = new Actions(driver);
        actions.moveToElement(source).click().sendKeys("BLR").build().perform();
    }

    @AfterSuite
    public void CloseBrowser() {
        try {
            Thread.sleep(10000); // better to avoid Thread.sleep() in real framework
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
