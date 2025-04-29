package com.thetestingacadmey.ex_selenium_29_04_25.ActionClass;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Lab_332 {
    EdgeOptions options;
    WebDriver driver;
    @BeforeSuite
    public void OpenBrowser(){
      options =new EdgeOptions();
      options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
      driver = new EdgeDriver(options);
      driver.manage().window().maximize();
    }
    @Test(testName = "shadow & USE JavaScript")
    @Description("Shadow Test And scrooling Managin broser throgh JS")
    public void shadowTest(){
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
    // name = "firstname"
        // THE TESTING ACADEMY
        WebElement firstname = driver.findElement(By.name("firstname"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(firstname,"thetestingacadmey")
                .keyUp(Keys.SHIFT).build().perform();

        WebElement link = driver.findElement(By.xpath("//a[text()= \"Click here to Download File\"]"));
        actions.contextClick(link).build().perform();
    }
    @AfterSuite
    public void ClosedBrowser(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
