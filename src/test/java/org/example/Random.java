package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Random {
    public ChromeOptions chromeOptions;
    public WebDriver driver;
    public String url ="https://www.verizon.com";

    @BeforeTest
    public void launchBrowser(){
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void signIn(){
        String Title=driver.getTitle();
        System.out.println(Title);
        Actions actions=new Actions(driver);
        //actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"gnav20-sign-id\"]/span/span"))).build().perform();
        driver.findElement(By.xpath("//*[@id=\"gnav20-sign-id\"]/span/span")).click();
        driver.findElement(By.linkText("Sign in to My Account")).click();
        String nextpageTitle = driver.getTitle();
        System.out.println(nextpageTitle);
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
