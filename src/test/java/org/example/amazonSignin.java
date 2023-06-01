package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class amazonSignin {
    WebDriver driver;
    @BeforeTest
    public void startBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
    }
    @Test
    public void logIn() throws Exception {
        try {

            //relative xpath
            WebElement signinButton =driver.findElement(By.id("nav-link-accountList-nav-line-1"));
            signinButton.click();
            driver.findElement(By.xpath("//input[@type='email']")).sendKeys("rabbanishaik998@gmail.com");
            driver.findElement(By.xpath("//input[@id='continue']")).click();

            driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("rabbanishaik998@gmail.com");
            driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

            //driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
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
