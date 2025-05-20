package com.thetestingacadmey.Exception_18_05_2025_;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Lab_346 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    // StaleElementReferenceException: This exception is thrown when the web driver is unable to interact with an element that has been modified or removed from the DOM after it was located.
    @Test
    public void testIframeInteraction() throws InterruptedException {
        try {


            String URL = "https://www.google.com/";
            driver.get(URL);
            WebElement ele = driver.findElement(By.xpath("//*[@class=\"gLFyf\"]\n"));
            driver.navigate().refresh();
            WebElement ele2 = driver.findElement(By.xpath("//*[@class=\"gLFyf\"]\n"));
            ele2.sendKeys("the testing academy" + Keys.ENTER);
            Thread.sleep(4000);
            //Refresh. Nevigate other page, change in DOM elements (Ajax calls) - Vuejs, AngularJS

            // b1 - found driver
            // b1 remove
            // b1.click --> ? no such element
            // driver.switchTO().frame(1);
            // driver.swithTO().alert().accept();

        }catch (StaleElementReferenceException | NoSuchElementException ex){
            System.out.println(ex.getMessage());
        }

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
