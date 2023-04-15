package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeBrowser {
    WebDriver driver;
    @BeforeTest
    public void startBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }
    @Test
    public void logIn() throws Exception {
        try {
//            driver.findElement(By.name("username")).sendKeys("Admin");
//            driver.findElement(By.name("password")).sendKeys("admin123");
//            driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
            String ExpectedTitle = "OrangeHRM";
            String nextPageTitle = driver.getTitle();
            Assert.assertEquals(nextPageTitle, ExpectedTitle);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("Exception Caught");
        }
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
