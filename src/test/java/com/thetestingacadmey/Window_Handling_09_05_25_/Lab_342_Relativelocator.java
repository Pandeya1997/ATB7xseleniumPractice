package com.thetestingacadmey.Window_Handling_09_05_25_;

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

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class Lab_342_Relativelocator {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(groups = "QA")
  @Description("Test case description")
    public void OpenPage() throws InterruptedException {
      driver.get("https://awesomeqa.com/practice.html");

//      WebElement span_element = driver.findElement(By.xpath("//span[.=\"Years of Experience\"]"));
     WebElement span_element = driver.findElement(By.xpath("//span[normalize-space()=\"Years of Experience\"]"));
//span[normalize-space()="Years of Experience"]
      driver.findElement(with(By.id("exp-1")).toRightOf(span_element)).click();



      Thread.sleep(5000);
    }

    @AfterSuite
    public void ClosedBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
        System.out.println("All Test Case Paas");
    }
}
