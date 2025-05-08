package com.thetestingacadmey.ex_selenium_09_04_25_Window_Handling;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class Lab_339 {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test()

    public void OpenPage() throws InterruptedException {
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        String mainWindowHandling = driver.getWindowHandle();
        System.out.println("Before click " + mainWindowHandling);
        Thread.sleep(3000);
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();
        Set<String> windowHandle = driver.getWindowHandles();
        // All the windows tab have a unique name
        for (String handles : windowHandle) {
            System.out.println(handles);
        }
    }

    @AfterSuite
    public void ClosedBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
