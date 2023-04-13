//Currently not working, file operations are not working
package org.example;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class ScreenShot{
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();
        //Convert Webdriver Object to takesScreenShot
        TakesScreenshot SS = (TakesScreenshot)driver;
        //call getScreenShotAs method to create img
        File SrcSS = SS.getScreenshotAs(OutputType.FILE);
        File DstSS = new File("C:\\Users\\rabba\\OneDrive\\Pictures\\SeleniumSS");

        //error here, file copy is not working
        //FileUtils.copyFile(SrcSS, DstSS);
        driver.close();

    }
}
