package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class f22Labs {
    WebDriver driver;
    ChromeOptions options;
    @BeforeMethod
    public void startup(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
    @Test
    public void scroll(){
        driver.get("https://www.merriam-webster.com/dictionary/sample");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JavascriptExecutor javascriptExecutor =(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("javaScript:Window.scrollBy(0,500)");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
