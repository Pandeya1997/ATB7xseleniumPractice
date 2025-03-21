package com.thetestingacadmey.ex_selenium_19_02_25;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Lab315 {
    @Test
    @Description()
    public void testMakeAppointment() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new EdgeDriver(edgeOptions);
        //driver.get("https://app.vwo.com/#/login");
        // or
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/\n");

        driver.manage().window().maximize();

        // Default Locator Strategy - id , name, class - unique - super good
        // Xpath or CSS Selector strategy
        // which is good , xpath or css selector
        // css selector --> little fast , Nowdays since more ram - xpath == css selector
        // Xpath or css selector - converted to each vice -
        // css selector - css Enginer - little fast to find the element

        // What os Xpath ?
        // xPath is a query language
        // for selecting nodes from an xml documents
        // HTML --> xml type of documents - tag base - A
        // All the major browser understand and support it. w3c
        //
        // Core - Logic -// TagName[@attribute = 'value']

        // type of Xpath

        // Absoulte xpath - type#1

        // it is too long -
        //  prone to change - any change in div or html - Axpath will work
        //  no Body use this

        // Relative Xpath (with query)
        // Core Logic - //tagname[@atrribute = "value"]
        // //input [@id = "login-username"]
        // selenium - id ?

        // WebElement btnElement_id = driver.findElement(By.id("btn-make-appointment"));
        //btnElement_id.click();
        //  WebElement btnElement_id = driver.findElement(By.className("btn-lg"));
        // btnElement_id.click();
        //  WebElement btnElement_id = driver.findElement(By.partialLinkText("Appointment"));
        //   btnElement_id.click();
        //     WebElement btnElement_id = driver.findElement(By.linkText("Make Appointment"));
        //     btnElement_id.click();
        WebElement brnElement_id = driver.findElement(By.xpath("//a [@href= \"./profile.php#login\"]"));
        brnElement_id.click();
        Thread.sleep(15000);

        // WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
        //This is slow , we are going to find the first all the elements
        WebElement username = driver.findElement(By.xpath("//*[@name = 'username']"));
        username.sendKeys("admin@123");
        // here, input --> place holder
        List<WebElement> PasswordBox = driver.findElements(By.xpath("//input[@placeholder= 'Password']"));
        PasswordBox.get(1).sendKeys("Jone Done");
        // ID, --> unique
        // Name, --> unique
        // CLass Name, - not unique - find multiple - useless
        // Link - Partial -Since it is not a chane , we can't use
        // Relative Xpath || CSS Selector

        // css selector


        // //*[@placeholder = "username"]
 // They are usefull when in the value -  some conststant and dynamic
        // title = "pra,od_1234".
        // starts-with --> pramod , contain  --> Partial match
        // img [contains{@title,"Flip"}]
       //immg[starts-with(@title,"Flip")]
        // substring- after

        // normalize-space = remove the title = " pramod "

        // a[text()= "Make Appointment" ] - Exact Match

        // Multiple Attributes
        // Operator - AND & OR
        // And Example
        //tag_name[@name = 'Name Value' and @id = 'ID Value ']
//  //a[text() = "Make Appointment" and contains (@id,"btn-make-appointment")]


        // Xapth - Axes
        // Go the Parent or child when you khow about the Son

        
        ////div [@class = 'Mammal']/child::div


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}

// * --> select all the nodes - select * from all element in html
// input --> select all input box - select inputs from all the html
// input [@title = "flipkart"] = select input  from all the html when  title  = flipkart;














