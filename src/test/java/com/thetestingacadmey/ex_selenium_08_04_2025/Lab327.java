package com.thetestingacadmey.ex_selenium_08_04_2025;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.List;

public class Lab327 {
    EdgeOptions options;
    // ChromeOptions options1;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        //options1 = new ChromeOptions();
        //options1.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        // driver = new ChromeDriver(options1);
        //   driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Description()
    public void webtable() {
        driver.get("https://awesomeqa.com/webtable1.html");
        //  xpath ; // table [@summary="Sample Table"]/tbody
        WebElement table = driver.findElement(By.xpath("//table[@summary=\"Sample Table\"]/tbody"));
        List<WebElement> rows_tables = table.findElements(By.tagName("tr"));
        System.out.println(rows_tables.size());
        System.out.println(rows_tables.get(1).getText());
        for (int i = 0; i < rows_tables.size(); i++) {
            List<WebElement> col = rows_tables.get(i).findElements(By.tagName("td"));
            for (WebElement c : col) {
                System.out.println(c.getText());
            }
        }

    }

    @AfterSuite
    public void ClosedBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
