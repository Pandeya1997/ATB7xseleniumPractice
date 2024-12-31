package com.thetestingacadmey.ex_selenium_29_12_2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Lab302 {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://clickbetexch.mango7222.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

    }

}
