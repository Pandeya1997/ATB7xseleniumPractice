package com.thetestingacadmey.ex_selenium_19_02_25;

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

public class Lab315_B {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void SetUp() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }

    @Test
    @Description
    public void HelenBennettFind() throws InterruptedException {

        driver.manage().window().maximize();
        driver.navigate().to("https://awesomeqa.com/webtable.html");
        Thread.sleep(3000);
        try {
            // WebElement tablekeyword = driver.findElement(By.xpath("//td[text() = \"Helen Bennett\"]"));
            //WebElement tablekeyword = driver.findElement(By.xpath("(//td[normalize-space()='Helen Bennett'])[1]"));
            WebElement tablekeyword = driver.findElement(By.xpath("//td[normalize-space()='Helen Bennett']"));


            try {
                String keyword = tablekeyword.getText();

                System.out.println("Test Pased " + " :- " + keyword);

            } catch (AssertionError e) {
                System.out.println("Test  Faild ");
            }
        } catch (AssertionError e) {
            System.out.println("Helen Bennett - Xpath Not Found ");
        }

    }


    @AfterSuite
    public void terDown() {
        driver.quit();
    }
}














