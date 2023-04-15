package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class TestNG {
        public String baseurl="https://www.browserstack.com/";
        public WebDriver driver;
        public ChromeOptions chromeOptions;
        //String driverpath="C:\\Users\\rabba\\Softwares\\geckodriver-v0.32.2-win-aarch64\\geckodriver.exe";
        //String driverpath="C:\\Users\\rabba\\Softwares\\ChromeDriver\\chromedriver.exe";
        @BeforeTest
        public void LaunchBrowser()
                {
                    System.out.println("Launching the Web application");
                    //System.setProperty("webdriver.gecko.driver",driverpath);

                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(chromeOptions);

                    //driver=new FirefoxDriver();
                    //System.setProperty("webdriver.chrome.driver",driverpath);
                    //driver = new ChromeDriver();
                    driver.get(baseurl);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                }
                @BeforeMethod
                public void loginHomepage()
                {
//                    driver.findElement(By.name("uid")).sendKeys("****");
//                    driver.findElement(By.name("password")).sendKeys("****");
//                    driver.findElement(By.name("btnLogin")).click();
                    System.out.println("in BeforeMethod");
                }
                @Test
                public void verifyHomepage()
                {
                    String Actual=driver.getTitle();
                    String Expected="Most Reliable App & Cross Browser Testing Platform | BrowserStack";
                    Assert.assertEquals(Actual,Expected);
                }
                @AfterTest
                public void closeBrowser()
                {
                    driver.quit();
                }
}