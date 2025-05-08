package com.thetestingacadmey.ex_selenium_03_04_25JavaScriptAlerts;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lab_324_checkBox {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    @Description("The Test Case Describe check Box  ")
    public void element_Promtp() throws Exception {
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        System.out.println("Title" + driver.getTitle());
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));
        // checkBoxes.get(0).click();
        checkBoxes.get(1).click();


    }

    @AfterSuite
    public void ClosedBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
