package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG {
        public String baseurl="http://www.demo.guru99.com/V4/";
        public WebDriver driver;
        //String driverpath="C:\\Users\\rabba\\Softwares\\geckodriver-v0.32.2-win-aarch64\\geckodriver.exe";
        //String driverpath="C:\\Users\\rabba\\Softwares\\ChromeDriver\\chromedriver.exe";
        @BeforeTest
        public void LaunchBrowser()
                {
                    System.out.println("Launching the Web application");
                    //System.setProperty("webdriver.gecko.driver",driverpath);
                    driver=new FirefoxDriver();
                    //System.setProperty("webdriver.chrome.driver",driverpath);
                    //driver = new ChromeDriver();
                    driver.get(baseurl);
                }
                @BeforeMethod
                public void loginHomepage()
                {
                    driver.findElement(By.name("uid")).sendKeys("****");
                    driver.findElement(By.name("password")).sendKeys("****");
                    driver.findElement(By.name("btnLogin")).click();
                }
                @Test
                public void verifyHomepage()
                {
                    //String ActualURL=driver.getTitle();
                    System.out.println("Its working in firefox");
                    //String ExpectedURL="http://www.demo.guru99.com/V4/manager/Managerhomepage.php";
                    //Assert.assertEquals(ActualURL,ExpectedURL);
                }

                @AfterTest
                public void closeBrowser()
                {
                    //driver.close();
                    driver.quit();
                }
}