package com.thetestingacadmey.ex_selenium_03_04_25;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Lab_320 {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser(){
        options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }
    @Test
    @Description("The Test Case Describe Drop-Dwon")
    public void Herokupap(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
        System.out.println("Title"+driver.getTitle());

        WebElement element_select = driver.findElement(By.id("dropdown"));
        Select select = new Select(element_select);
        select.selectByIndex(2);

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
