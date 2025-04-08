package com.thetestingacadmey.ex_selenium_04_04_25_DaymicElements;

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

import java.util.List;

public class Lab_325_WebTable {
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

        // Get number of rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        int rowCount = rows.size();

        // Get number of columns
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td"));
        int colCount = cols.size();

        System.out.println("Rows: " + rowCount + ", Columns: " + colCount);

        for (int i = 2; i <= rowCount; i++) {  // Starting from 2 to skip header row
            for (int j = 1; j <= colCount; j++) {
                String dynamicXPath = "//table[@id='customers']/tbody/tr[" + i + "]/td[" + j + "]";
                String data = driver.findElement(By.xpath(dynamicXPath)).getText();
                System.out.print(data + " | ");
            }
            System.out.println();
        }
    }

    @AfterSuite
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}