package com.thetestingacadmey.ex_Selenium_15_05_2025;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class Lab_343_RelativeLocater {
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
        driver.get("https://www.aqi.in/in/real-time-most-polluted-city-ranking");

// Search Chity Name
        Thread.sleep(5000);
        WebElement SearchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        SearchBox.sendKeys("india" + Keys.ENTER);
        Thread.sleep(5000);

//div[@class="content grow text-[2.5vw] sm:text-[1rem] min-h-[50em] flex flex-col sm:max-lg:overflow-x-auto max-md:pb-[2em]"]/div/a/div/p

// List of Elements
        List<WebElement> list_of_states = driver.findElements(By.xpath("//div[@class=\"content grow text-[2.5vw] sm:text-[1rem] min-h-[50em] flex flex-col sm:max-lg:overflow-x-auto max-md:pb-[2em]\"]/div/a/div/p"));
        // List_of_state > left, right_of --> AQI
        for (WebElement l : list_of_states) {
            String s1 = driver.findElement(with(By.tagName("p")).toRightOf(l)).getText();
            String s2 = driver.findElement(with(By.tagName("p")).toLeftOf(l)).getText();
            System.out.println(l.getText() + "-->" + s1 + "-->s2");

        }


        Thread.sleep(5000);
    }

    @AfterSuite
    public void ClosedBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
        System.out.println("All Test Case Paas");
    }
}
