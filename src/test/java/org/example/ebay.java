package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ebay {
    private WebDriver driver;
    private ChromeOptions chromeOptions;
    String url="https://www.ebay.com";

    @BeforeTest
    public void setUp(){
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }
    @Test
    public void search(){
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.id("gh-ac")).sendKeys("Apple Watch");
        WebElement category = driver.findElement(By.id("gh-cat"));
        Select select = new Select(category);
        select.selectByVisibleText("Consumer Electronics");
        driver.findElement(By.id("gh-btn")).click();
        //incomplete
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
