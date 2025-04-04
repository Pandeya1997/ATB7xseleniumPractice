package com.thetestingacadmey.ex_selenium_24_03_2025;

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


public class Lab_317 {
    EdgeOptions options;
    WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    // Navigate to the - https://www.ebay.com/sch/i.html?_nkw=+macmini&_sacat=0&_from=R40&_trksid=p2334524.m570.l1313&_odkw=all+macmini&_osacat=0
//Find the macmini , click search
// print all the titles
    @Test(groups = "QA")
    @Description("Test case Description ")
    public void Login() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        System.out.println(driver.getTitle());
        // how to CSS selector  find search element :- input[id = "gh-ac"] --> Xpath --> //input[@id = ""gh-ac""]
        // how to id find search element  :- #gh-ac
        // WebElement searchBox = driver.findElement(By.id("gh-ac"));
        WebElement searchBox = driver.findElement(By.cssSelector("input[id = \"gh-ac\"]"));
        searchBox.sendKeys("macmini");
        //  CLick search button
        // id - gh-search-btn
        // css selector - button[value="Search"] or button[role="button"] or button[type="submit"] or or button[class="gh-search-button btn btn--primary"]
        //WebElement searchBoxButton = driver.findElement(By.cssSelector("button[value=\"Search\"]"));
        //    WebElement searchBoxButton = driver.findElement(By.cssSelector("button[class=\"gh-search-button btn btn--primary\"]"));
        //WebElement searchBoxButton = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        WebElement searchBoxButton = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        searchBoxButton.click();
        Thread.sleep(5000);
        try {
            //        List<WebElement> titlenname = driver.findElements(By.cssSelector("div[class =s-item__title]"));
            List<WebElement> titlenname = driver.findElements(By.cssSelector(".s-item__title"));
            List<WebElement> TitlePriceProduct = driver.findElements(By.cssSelector(".s-item__price"));

//            for (WebElement title : titlenname ){
//                System.out.println(title.getText());
//
//            }
//            //.s-item__price
//            for( WebElement price : TitlePriceProduct){
//                System.out.println(price.getText());
//            }
            // Ensure both lists are of the same size to avoid IndexoutofBoundsException
            int size = Math.min(titlenname.size(), TitlePriceProduct.size());
            for (int i = 0; i < size; i++) {
                System.out.println("Title: " + titlenname.get(i).getText() + "||" + "Price" + TitlePriceProduct.get(i).getText());
                System.out.println(" ");
            }
        } catch (AssertionError e) {
            System.out.println("Test Faild title & Price ");
        }

        // img[title*="Flip"] - contains
        // img[title^="Flip"] - starts-with
        //img[title$="Flip"] - end-with
        //div.first > span:nth-child(2n+1)
        //div.fist


        // select --> simple, custom select(div, ui-li) diffrent appraoch)
        //
        // waits

    }

    @AfterSuite
    public void closed() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("closer");
        driver.quit();
    }

}
