package com.thetestingacadmey.Actions_Window_Drag_Drop_30_04_25;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Lab_336_Action {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(testName = "Postive Test Case")
    @Description("")
    public void PostiveTestCase() throws InterruptedException {
        String URL = "https://www.makemytrip.com/railways/";
        driver.get(URL);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        System.out.println("Scroll Down");


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
