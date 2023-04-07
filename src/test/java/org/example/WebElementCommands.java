package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class WebElementCommands {
    public static void main(String []args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //WebElements Practice
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("rakul");

        //Clicking radio Button
//        WebElement radioButton = driver.findElement(By.id("sex-0"));
//        radioButton.click();

        //getText
        WebElement text = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div/div/h2[1]/b/span"));
        String textToPrint = text.getText();
        System.out.println(textToPrint);

        //isDisplayed - checks whether element is displayed or not
        WebElement shareButton = driver.findElement(By.id("sharing-button-Blog1-byline-3077692503353518311"));
        boolean isButtonDisplayed = shareButton.isDisplayed();
        System.out.println(isButtonDisplayed);

        //isEnabled - checks whether element is enabled or not
        WebElement button = driver.findElement(By.id("sharing-button-Blog1-byline-3077692503353518311"));
        boolean isButtonEnabled = button.isEnabled();
        if (isButtonEnabled)
            button.click();
        else
            System.out.println("Share Button is not enabled");

        //Selecting DropDowns
        WebElement dropDown = driver.findElement(By.id("continents"));
        Select item = new Select(dropDown);
        item.selectByIndex(1);
        WebElement printSelectedCont = driver.findElement((By.name("continents")));
        String continentName = printSelectedCont.getText();
        System.out.println(continentName);
    }
}
