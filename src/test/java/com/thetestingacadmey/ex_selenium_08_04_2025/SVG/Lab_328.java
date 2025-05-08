package com.thetestingacadmey.ex_selenium_08_04_2025.SVG;

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

public class Lab_328 {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    @Description()
    public void SVG() {
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.name("q")).sendKeys("macmini");
        // List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()= \"svg\"]"));
        //or
//       List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()= \"svg\"]"));
//        svgElements.get(0).click();

        driver.findElement(By.xpath("//button [@title=\"Search for Products, Brands and More\"]//*[name()='svg']")).click();

    }


    @AfterSuite
    public void ClosedBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
