package com.thetestingacadmey.SVG_Shadow_root_24_04_25.shadow_root;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Lab_331 {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(testName = "shadow & USE JavaScript")
    @Description("Shadow Test And scrooling Managin broser throgh JS")
    public void shadowTest() {
        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//       js.executeScript("alert(1)");
        // javaScript code - document.querySelector("div#userName").shadowRoot.querySelector("div").shadowRoot.querySelector("input#pizza")
        // WebElement
        WebElement divScrolTo = driver.findElement(By.xpath("//div[@id=\"userName\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", divScrolTo);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement inputpizzabox = (WebElement) js.executeScript("return  document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\")");
        inputpizzabox.sendKeys("FarmHouse");

    }

    @AfterSuite
    public void ClosedBrowser() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
