package com.thetestingacadmey.ex_selenium_29_04_25.ActionClass;


import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Lab_334_MakeMyTrip {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(testName = "QA")
    @Description("Open MakeMyTrip and input source location using Actions class with explicit wait.")
    public void PostiveTestCase() throws InterruptedException {
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        Thread.sleep(4000);

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("New Delhi").build().perform();

        //ul.react-autosuggest__suggestions-list > li
        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));


        for (WebElement e : list_auto_complete) {
            if (e.getText().contains("New Delhi")) {
                e.click();
                break;
            }


        }


        Thread.sleep(13000);

    }

    @AfterSuite
    public void CloseBrowser() {
        try {
            Thread.sleep(10000); // better to avoid Thread.sleep() in real framework
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
