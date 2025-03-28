package com.thetestingacadmey.ex_selenium_24_03_2025;

import io.qameta.allure.Description;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Lab_316 {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void SetUp() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().fullscreen();
    }

    @Test
    @Description()
    public void Login() throws InterruptedException {
        driver.get("");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
// X.path - Quesry languges to find the element in the html document.
// Relative - 99%
// Absolute - Not body ignore - 1%

// Core Logic --> //tagName[@attribute= value]
// xpath-Funcation --> text(), contain, start-with, end-with(), substring, Normalize-space - trime the
// Xpath  Axes --> Ancestors, following-sibling, parant, child , descendants, precedi

//Css Selector --> All  these

// Logic - [attribute=value]  --> xpath convert --> //tagName[@attribute =value]

// Css selector are used to select elements in the HTML or XML document
// in order to apply styles or other msnipulations to those elements.

// id --? Normal selector --> css selector
// By.id --> #id
// className --> .class
//custom Attribute -> input type = "text" data-qa = "abc/> -> [data-qa = "abcd"]
// convert xpath --> css selector also.

// css selector -->
// contain xPath contains() --> *
// start-with() -xpath --> ^
// end-with() xpath --> $
