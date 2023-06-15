package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.sql.Time;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class flipkartShopping {
    private WebDriver driver;
    ChromeOptions chromeOptions;
    String url ="https://www.flipkart.com/";

    @BeforeTest
    public void launchBrowser(){
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }
    @Test(priority = 1)
    public void shop(){
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        try {
            if(driver.findElement(By.xpath("//input[@type='text' and @class='_2IX_2- VJZDxU']")).isDisplayed()) {
                driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Login popup is not displayed");
        }
        driver.findElement(By.name("q")).sendKeys("Apple 14 pro max");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone')][1]")).click();

        //switch tabs
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> iterator = tabs.iterator();
        String previousTab = iterator.next();
        String newTab=iterator.next();
        driver.switchTo().window(newTab);

        //add to cart
        try{
            if (driver.getTitle().contains("APPLE iPhone")){
                driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Wrong item");
        }
    }
    @Test(priority = 2)
    public void links(){
        driver.get(url);
        List<WebElement> links = driver.findElements(By.tagName("a"));

        //print all links
        for (WebElement link:links){
            System.out.println("Link Text ::"+link.getText());
            System.out.println("Link URL ::"+link.getAttribute("href"));
        }
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
