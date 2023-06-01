package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Assertions {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.browserstack.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //from selenium 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        String ActualTitle = driver.getTitle();
        String ExpTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
        Assert.assertEquals(ActualTitle,ExpTitle);
        //Assert.assertNotEquals(ActualTitle,ExpTitle);
        driver.quit();
    }
}
