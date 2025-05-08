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
import io.qameta.allure.Description;

import java.util.Set;

public class Lab_340 {
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
    @Description("Handle multiple windows and switch to new tab")
    public void OpenPage() {
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);

        // Store the current window handle
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Main Window Handle: " + mainWindowHandle);

        // Click the link to open a new window
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Switch to the new window
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to child window: " + handle);
                System.out.println("Child window title: " + driver.getTitle());

                // Perform any action in new window (optional)
                // e.g., verify text, click something, etc.

                // Close child window if desired
                driver.close();
                break;
            }
        }

        // Switch back to main window
        driver.switchTo().window(mainWindowHandle);
        System.out.println("Back to main window: " + driver.getTitle());
    }

    @AfterSuite
    public void ClosedBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
