package com.thetestingacadmey.Iframe_RelativeLocter_mouseEventHandling_15_05_2025;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;


public class Lab_344_mouse_event_Keyword_event {
    EdgeOptions options;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(groups = "QA")
    @Description("Test case description")
    public void OpenPage() throws InterruptedException {
        driver.get("https://ui-scoreboard.maharaj365.in/login");

        // iframe
        // driver.switchTo().frame("result");
        WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type= \"button\"]")));
        Button.click();
        Thread.sleep(3000);
        WebElement UserID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cust_user_id")));
        UserID.sendKeys("admin001" + Keys.ENTER);
//        UserID.sendKeys("admin001");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id=\"passwd\"]")));
        password.sendKeys("adminPass" + Keys.ENTER);


        Thread.sleep(5000);
    }

    @AfterSuite
    public void ClosedBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
        System.out.println("All Test Case Paas");
    }
}
