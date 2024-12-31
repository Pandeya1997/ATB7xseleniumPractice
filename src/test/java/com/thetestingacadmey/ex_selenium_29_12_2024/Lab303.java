package com.thetestingacadmey.ex_selenium_29_12_2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Lab303 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://clickbetexch.mango7222.com/");
        // quit vs closed

        //  Thread.sleep(5000);
        //  driver.close();
        // closed current Browser window
        // Not Null Browser
        // Session ID != NULL
        Thread.sleep(5000);
        driver.quit();

    }
}
