package com.thetestingacadmey.ex_selenium_24_04_25.SVG;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Lab_330 {
    EdgeOptions options;
    WebDriver driver;
    private int size;

    @BeforeSuite
    public void OpenBrowser(){
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }
    @Test
    @Description("Find ")
    public void SVG(){
     String URL = "https://www.flipkart.com/\n";
    driver.get(URL);
    driver.findElement(By.xpath(" //*[text()= \"Electronics\"]\n")).click();
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//    wait.until(ExpectedConditions.)
    }



    @AfterSuite
    public void ClosedBrowser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
