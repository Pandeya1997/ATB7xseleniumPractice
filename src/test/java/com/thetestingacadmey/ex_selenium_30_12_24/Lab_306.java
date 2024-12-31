package com.thetestingacadmey.ex_selenium_30_12_24;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab_306 {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        EdgeOptions options = new EdgeOptions();
        // options.addArguments ("start-maximized");
//        options.addArguments("--window-size=800,600");
//        options.addArguments("--incognito");
//        options.addArguments("--guest");
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("127.0.0.1:8080");
        options.setCapability("Proxy", proxy);


        options.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.get("https://google.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
