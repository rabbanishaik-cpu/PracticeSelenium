package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.sql.SQLOutput;
import java.time.Duration;

public class Facebook extends TestBase{
//    WebDriver driver;
//    ChromeOptions chromeOptions;
//    String fbUrl="https://www.fb.com/";
//    String facebookurl="https://www.facebook.com/";
//    @BeforeTest
//    public void launchBrowser(){
//        chromeOptions=new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(chromeOptions);
//        driver.get(fbUrl);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//    }
    @Test
    public void facebookSignUp(){
        String fbUrl="https://www.fb.com/";
        String facebookurl="https://www.facebook.com/";
        driver.get(fbUrl);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        try {
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, facebookurl,"No Redirection happened");
            driver.findElement(By.xpath("//*[@role='button' and @class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
            //new user registraion
            //driver.findElement(By.id("u_9_b_dI")).sendKeys("Rocky");
            driver.findElement(By.name("firstname")).sendKeys("Rocky");
            driver.findElement(By.name("lastname")).sendKeys("Bhai");
            driver.findElement(By.name("reg_email__")).sendKeys("7894561230");
            driver.findElement(By.id("password_step_input")).sendKeys("RockyKGF");

            //selecting dropdowns
            Select day = new Select(driver.findElement(By.id("day")));
            Select Month = new Select(driver.findElement(By.id("month")));
            Select Year = new Select(driver.findElement(By.id("year")));

            day.selectByVisibleText("4");
            Month.selectByVisibleText("Oct");
            Year.selectByVisibleText("2021");

            driver.findElement(By.xpath("//input[@type='radio' and @value='2']")).click();
            driver.findElement(By.name("websubmit")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

           // driver.findElement(By.id("u_9_g_Ci")).sendKeys("7894561230");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    @AfterTest
//    public void closeBrowser(){
//        driver.quit();
//    }
}
