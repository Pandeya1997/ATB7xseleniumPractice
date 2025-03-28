package com.thetestingacadmey.ex_selenium_30_12_24;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

// Project  #1 - TC (Negative) - Invalid Username , pass - Error message verification
// 1. open the URL https://clickbetexch.mango7222.com/ / #/ login ]
// 2. find the email id ** and enter the email id (dcuser01)
// 3. find the password input box and enter the password
// 4. find the sign in button and click on it
// 5. verify the error message is displayed on the page
@Test
public class Lab_310 {
    @Test
    public void testclickLoginNegative() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://clickbetexch.mango7222.com/");
        driver.manage().window().maximize();
        String Title = driver.getTitle();
        System.out.println("title" + Title);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://clickbetexch.mango7222.com/");

        //  WebElement elementInputBox = driver.findElement();
        driver.quit();

    }

}

