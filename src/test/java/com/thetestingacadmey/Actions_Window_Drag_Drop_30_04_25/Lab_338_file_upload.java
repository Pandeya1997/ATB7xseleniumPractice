package com.thetestingacadmey.Actions_Window_Drag_Drop_30_04_25;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Lab_338_file_upload {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(testName = "Postive Test Case")
    @Description("")
    public void PostiveTestCase() throws InterruptedException {
        String URL = "https://awesomeqa.com/selenium/upload.html";
        driver.get(URL);
        Thread.sleep(4000);

        WebElement uploadFile = driver.findElement(By.id("fileToUpload"));
        String dir = System.getProperty("user.dir");
        System.out.println(dir); // C:\\Users\\AARRSOL\\IdeaProjects\\ATB7xseleniumPractice


        uploadFile.sendKeys(dir + "\\src\\test\\java\\com\\thetestingacadmey\\ex_selenium_30_04_25_Actions_Window_Drag_Drop\\toUpload.txt");
        driver.findElement(By.name("submit")).click();


        Thread.sleep(4000);


    }

    @AfterSuite
    public void CloseBrowser() {
        try {
            Thread.sleep(10000); // better to avoid Thread.sleep() in real framework
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
