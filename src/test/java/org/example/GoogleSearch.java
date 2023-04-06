package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearch {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //get page title
        String title = driver.getTitle();
        System.out.println(title);

        //get currenturl of the page
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        //get sourcecode of the webpage
        //String sourceCode = driver.getPageSource();
        //System.out.println(sourceCode);

        //WebElement SearchBar = driver.findElement(By.name("q"));
        //SearchBar.sendKeys("Rabbani");

        //browser navigation
        driver.get("https://www.selenium.dev/documentation/");
        driver.navigate().to("https://www.selenium.dev/documentation/webdriver/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();
    }

}
