package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot{
    public static void main(String[] args) throws IOException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();
        //Convert Webdriver Object to takesScreenShot
        TakesScreenshot SS = (TakesScreenshot)driver;
        //call getScreenshotAs method to create img
        File SrcSS = SS.getScreenshotAs(OutputType.FILE);
        File DstSS = new File("C:/Users/rabba/OneDrive/Pictures/SeleniumSS/screenshot.png");

        //go to mvn repository and add commons.io apache dependency in POM then Fileutils will work.
        FileUtils.copyFile(SrcSS, DstSS);
        driver.close();

    }
}
