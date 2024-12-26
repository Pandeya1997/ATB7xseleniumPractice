package com.thetestingacadmey.ex_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Lab304 {
    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://clickbetexch.mango7222.com/");

        // No Back , Forward allowed in case of get

        driver.navigate().to("https://ui.win1buzz.in/");
        driver.navigate().to(new URL("https://www.zplay2.in/"));
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();

    }
}
