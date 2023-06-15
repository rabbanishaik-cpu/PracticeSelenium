package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class openNewtab {
    private WebDriver driver;
    private ChromeOptions chromeOptions;
    String url="https://www.ebay.com";

    @BeforeMethod
    public void setUp(){
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }
    @Test
    public void openNewTab(){
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //opening a new Tab
        //this is not working for some reason
        //Actions actions = new Actions(driver);
        //actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
        //actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();


        //new version to open a new tab
        driver.switchTo().newWindow(WindowType.TAB);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));

        driver.get("https://www.jio.com");
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
