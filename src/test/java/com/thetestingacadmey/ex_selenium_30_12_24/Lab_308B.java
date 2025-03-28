package com.thetestingacadmey.ex_selenium_30_12_24;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab_308B {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximixed");
        options.addArguments("--guest");
        driver.get("https://www.facebook.com/");
        driver.quit();
        System.out.println("Done");
    }
}

