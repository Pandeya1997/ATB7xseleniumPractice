package com.thetestingacadmey.ex_selenium_30_12_24;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab_312 {

// Project  #1 - TC (Negative) - Invalid Username , pass - Error message verification
// 1. open the URL https://app.vwo.com/#/login]
// 2. find the email id ** and enter the email id (dcuser01)
// 3. find the password input box and enter the password
// 4. find the sign in button and click on it
// 5. verify the error message is displayed on the page
    @Test
    public void testVwoLoginNegative() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
       edgeOptions.addArguments("--guest");
       WebDriver driver = new EdgeDriver(edgeOptions);
       //driver.get("https://app.vwo.com/#/login");
        driver.navigate().to("https://app.vwo.com/#/login");
       // How to find the elements
        // email-id
        // <input
        // type="email"
        // class="text-input W(100%)"
        // name="username"
        // id="login-username"
        // data-qa="hocewoqisi">

        // find the Email id** and enter the email as admin@admin.com
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox = driver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys("password@123");

        WebElement ButtonSubmit = driver.findElement(By.id("js-login-btn"));
        ButtonSubmit.click();

         Thread.sleep(5000);
        WebElement errorMessage = driver.findElement(By.id("js-notification-box-msg"));
        String messageText = errorMessage.getText();
        System.out.println("Error Message: " + messageText);
        //Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");
        // or
        Assert.assertEquals(messageText,"Your email, password, IP address or location did not match");
        // id="js-notification-box-msg"
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        driver.quit();

    }
}
