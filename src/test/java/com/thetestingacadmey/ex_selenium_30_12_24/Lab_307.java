package com.thetestingacadmey.ex_selenium_30_12_24;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab_307 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.get("https://google.com/");
        Thread.sleep(5000);
        driver.quit();
    }
}
