package com.thetestingacadmey.ex_selenium_29_12_2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab305 {
    @Test
    public void testClickMangoLoginTitle() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://clickbetexch.mango7222.com/");
        String title = driver.getTitle();
        System.out.println("Website Title: " + title);
        Assert.assertEquals(driver.getTitle(), "");
        String url = driver.getCurrentUrl();
        System.out.println("URL" + url);
        Assert.assertEquals(driver.getCurrentUrl(), "https://clickbetexch.mango7222.com/");
        driver.quit();
    }
}
