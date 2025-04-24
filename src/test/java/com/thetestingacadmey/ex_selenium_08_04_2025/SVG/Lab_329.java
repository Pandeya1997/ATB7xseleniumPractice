package com.thetestingacadmey.ex_selenium_08_04_2025.SVG;

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

import java.util.List;

public class Lab_329 {
    EdgeOptions options;
    WebDriver driver;
    private int size;

    @BeforeSuite
    public void OpenBrowser(){
      options = new EdgeOptions();
      options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
      driver = new EdgeDriver(options);
      driver.manage().window().maximize();
    }
   @Test
   @Description()
   public void SVG(){
        String URL = "https://www.amcharts.com/svg-maps/?map=india";
       // driver.get("https://www.amcharts.com/svg-maps/?map=india");
        driver.get(URL);
        List<WebElement> states = driver.findElements(By.xpath("//*[name()= 'svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()= 'path']"));

        for (WebElement state : states){
            System.out.println(state.getAttribute("aria-label"));
            if (state.getAttribute("aria-label").contains("Tripura")){
                state.click();
            }

        }

   }



    @AfterSuite
    public void ClosedBrowser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
