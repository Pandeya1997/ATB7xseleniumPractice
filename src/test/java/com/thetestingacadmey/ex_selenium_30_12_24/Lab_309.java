package com.thetestingacadmey.ex_selenium_30_12_24;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab_309 {
    public static void main(String[] args) {
        //   selenium
        // Find the element and Interact
        // Command --> Target - IDE

        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://sa-admin-ui.jaigovinda7.com/login#/login");
        System.out.println(driver.getTitle());
        driver.quit();


    }
}

