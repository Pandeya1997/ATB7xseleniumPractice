package com.thetestingacadmey.ex_selenium_19_05_2025_Data_Driven;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab_347 {
    EdgeOptions options;
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() {
        options = new EdgeOptions();
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
// Data Driver Testing - input Data different files format and then  use web automation  framework  Like (csv files, xml,text, ymal,json,DB, files  etc )

    @Test(groups = "QA")
    @Description("Data Drivern Testing ")
    public void testIframeInteraction() throws InterruptedException {


    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
