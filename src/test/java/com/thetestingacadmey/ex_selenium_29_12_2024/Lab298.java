package com.thetestingacadmey.ex_selenium_29_12_2024;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Lab298 {
    @Test
    public void vwoLogin() {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://courses.thetestingacademy.com/");
        driver.quit();
    }
}
