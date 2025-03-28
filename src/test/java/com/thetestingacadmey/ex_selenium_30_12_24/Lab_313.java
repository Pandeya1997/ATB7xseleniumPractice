package com.thetestingacadmey.ex_selenium_30_12_24;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Lab_313 {

    @Test
    public void freeTrailLink() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());

        Thread.sleep(2000);
        // Start a free trial
        // find the element - id is not   , name is not , class not unique,
        // link taxt and partial link - work only a tag

        WebElement freeTrailLink = driver.findElement(By.linkText("Start a free trial"));
        freeTrailLink.click();
        Thread.sleep(4000);
        WebElement enterEmail = driver.findElement(By.id("page-v1-step1-email"));
        enterEmail.sendKeys("Admin@Admin.com");

        WebElement gdprconsentcheckbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        gdprconsentcheckbox.click();
        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        buttonList.get(0).click();
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.className("invalid-reason"));
        System.out.println(errorMessage.getText());
        Assert.assertEquals(errorMessage.getText(), "An account with this email already exists. Login Here");
        driver.quit();

    }
}
