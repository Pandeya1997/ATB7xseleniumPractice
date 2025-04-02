package com.thetestingacadmey.ex_selenium_01_04_25_Wailt_type;

import io.qameta.allure.Description;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Lab_318 {
    EdgeOptions options;
    WebDriver driver;
    @BeforeSuite
    public void OpenBrowser(){
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }
    @Test
    @Description("")
    public void VWOLogin(){
 // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Explicit Wait
  driver.get("https://www.ebay.com/");

    }
    @AfterSuite
    public void ClosedBroser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

}
