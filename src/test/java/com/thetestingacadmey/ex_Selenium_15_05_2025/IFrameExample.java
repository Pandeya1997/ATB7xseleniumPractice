package com.thetestingacadmey.ex_Selenium_15_05_2025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrameExample {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testIframeInteraction() throws InterruptedException {
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe");

        // Switch to the outer iframe by ID
        driver.switchTo().frame("iframeResult");

        // Now switch to the inner iframe by tag (or name if available)
        WebElement innerIframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(innerIframe);

        // Interact with element inside the iframe (just an example, we print the title)
        String innerText = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Text inside inner iframe: " + innerText);

        // Switch back to main content
        driver.switchTo().defaultContent();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}