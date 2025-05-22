package com.thetestingacadmey.Data_Driven_19_05_25_Data_Driven.RealTimeSenarios;

import io.qameta.allure.Description;
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

import java.time.Duration;

public class Lab_351_DDTRealTIme {
    EdgeOptions options;
    WebDriver driver;
    WebDriverWait  wait;

    @BeforeSuite
    public void OpenBrowser(){
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    @Test(dataProvider = "loginData")
    public void dataDriven(String testid, String email, String password, String expectedResult) throws InterruptedException{
     driver.get("https://app.vwo.com");
     WebElement emailElement = driver.findElement(By.id("login-username"));
   //  emailElement.clear();
     emailElement.sendKeys(email);
     WebElement PasswordElement = driver.findElement(By.id("login-password"));
 //    PasswordElement.clear();
     PasswordElement.sendKeys(password);

     driver.findElement(By.id("js-login-btn")).click();
        if (expectedResult.equalsIgnoreCase("Valid")) {

//            String text = driver.findElement(By.cssSelector("[data-qa=\"lufexuloga\"]")).getText();
            String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-qa=\"lufexuloga\"]"))).getText();
            System.out.println(text);
            Assert.assertEquals(text,"Aman Ji");
        }
        if (expectedResult.equalsIgnoreCase("InValid")) {
            WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
            wait.until(ExpectedConditions.visibilityOf(error_message));
            Assert.assertTrue(error_message.isDisplayed());
            Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");
        }
    }


    @DataProvider(name = "loginData")
    public Object[][] testData() {
    return new Object[][]{

            {"TD1", "93npu2yyb0@esiix.comi", "Wingify@123", "InValid"},
            {"TD2", "contact+atb7x@thetestingacademy.com", "Wingify@1234", "Valid"},

    };
    }

//    @DataProvider(name = "loginData")
//    public String[][] testDataExcel() throws IOException {
//        String testDataFile = "src/test/resources/TataData.xlsx";
//        ExcelReader excelReader = new ExcelReader(testDataFile);
//        String[][] data = excelReader.getDataFromSheet(testDataFile, "LoginData");
//        return data;
//    }


    @AfterSuite
    public void ClosedBroswer() throws InterruptedException {
        Thread.sleep(300);
        driver.quit();
    }
}
