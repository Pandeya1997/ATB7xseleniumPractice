package com.thetestingacadmey.Data_Driven_19_05_25_Data_Driven.RealTimeSenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class Lab_352_DataDriven_Excel_reader {
    EdgeOptions options;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    @Test(dataProvider = "loginData")
    public void testDataDriven(String email, String password, String expectedResult) {
        driver.get("https://app.vwo.com");
        WebElement emailElement = driver.findElement(By.id("login-username"));
        emailElement.clear();
        emailElement.sendKeys(email);
        WebElement passwordElement = driver.findElement(By.id("login-password"));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        driver.findElement(By.id("js-login-btn")).click();

        if (expectedResult.equalsIgnoreCase("Valid")) {
            String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-qa=\"lufexuloga\"]"))).getText();
//            String text = driver.findElement(By.cssSelector("[data-qa=\"lufexuloga\"]")).getText();
            System.out.println(text);
            Assert.assertEquals(text, "Aman Ji");
        }
        if (expectedResult.equalsIgnoreCase("InValid")) {
            WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(error_message));
            Assert.assertTrue(error_message.isDisplayed());
            Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
        }
    }


    @DataProvider(name = "loginData")
    public String[][] testDataExcel() throws IOException {
        String testDataFile = "src/test/java/TataData.xlsx";
        ExcelReader excelReader = new ExcelReader(testDataFile);
        String[][] data = excelReader.getDataFromSheet(testDataFile, "LoginData");
        return data;
    }


    @AfterSuite
    public void ClosedBroswer() throws InterruptedException {
        Thread.sleep(300);
        driver.quit();
    }
}
