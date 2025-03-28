package com.thetestingacadmey.ex_selenium_30_12_24;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

// Project  #1 - TC (Negative) - Invalid Username , pass - Error message verification
// 1. open the URL https://clickbetexch.mango7222.com/ / #/ login ]
// 2. find the email id ** and enter the email id (dcuser01)
// 3. find the password input box and enter the password
// 4. find the sign in button and click on it
// 5. verify the error message is displayed on the page
@Test
public class Lab_311 {
    @Test
    public void testclickLoginNegative() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new EdgeDriver(edgeOptions);
        //driver.get("https://app.vwo.com/#/login");
        // or
        driver.navigate().to("https://app.vwo.com");

        driver.manage().window().maximize();
        String Title = driver.getTitle();

        System.out.println("title" + Title);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        WebElement emailInpurBox = driver.findElement(By.id("login-username"));
        emailInpurBox.sendKeys("admin@admin.com");
        WebElement passwordEnter = driver.findElement(By.id("login-password"));
        passwordEnter.sendKeys("admin@password");
        WebElement SubmitButton = driver.findElement(By.id("js-login-btn"));
        SubmitButton.click();
        // Verify thr error message
        Thread.sleep(2000);
        WebElement ErrorMessage = driver.findElement(By.id("js-notification-box-msg"));
        //  WebElement ErrorMessage = driver.findElement(By.className("notification-box-description"));

        String errormessages = ErrorMessage.getText();
        System.out.println("error message " + " " + errormessages);

        Assert.assertEquals(ErrorMessage.getText(), "Your email, password, IP address or location did not match");


        // id - , name , class not unique -->
        // Link text and partial Link  -a tag anchor
        // exchate name
        //  WebElement freeTrailLink = driver.findElement(By.linkText("Start a free trial"));
        //   freeTrailLink.click();
        // partial  name
        WebElement FreeTrailLinkParcial = driver.findElement(By.partialLinkText("Start a free tri"));
        FreeTrailLinkParcial.click();

        WebElement EnterBUssinationEmail = driver.findElement(By.id("page-v1-step1-email"));
        EnterBUssinationEmail.sendKeys("123admin@admin.com");
        WebElement Checkbox = driver.findElement(By.id("page-826cu-gdpr-consent-checkbox"));
        Checkbox.click();
        Thread.sleep(Long.parseLong("5000"));

        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        buttonList.get(0).click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

}

