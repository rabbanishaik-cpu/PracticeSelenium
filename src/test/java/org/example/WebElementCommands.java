package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        WebElement radioButton = driver.findElement(By.id("sex-0"));
        radioButton.click();


    }
}
