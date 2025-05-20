package com.thetestingacadmey.DaymicElements_04_04_25;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Lab_326_WebTable {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void openBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    @Description("Dynamic Element Finding in Web Table")
    public void dynamicElementFind() {
        driver.get("https://awesomeqa.com/webtable.html");
        System.out.println("Page Title: " + driver.getTitle());

        WebElement element = driver.findElement(By.xpath("//table [@id=\"customers\"]/tbody/tr[6]/td[3]"));
        System.out.println(element.getText());

    }

    @AfterSuite
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}