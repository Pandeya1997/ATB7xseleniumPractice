package com.thetestingacadmey.ex_selenium;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Lab298 {
    @Test
    public void clickmango7222login() {
        // selenium flow
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://clickbetexch.mango7222.com/");
        driver.quit();

    }
}
