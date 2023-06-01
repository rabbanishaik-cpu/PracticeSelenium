package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CAW {
    public static void main(String[] args) {

//        ArrayList<String> emailIds = new ArrayList<>();
//        emailIds.add("gill@gmail.com");
//        emailIds.add("mouse@gmail.com");
//        emailIds.add("keyboard@gmail.com");
//        emailIds.add("screen@gmail.com");

        String[] emaiids = {"gill@gmail.com"};

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //driver.navigate().to("https://ultimateqa.com/automation");
        driver.get("https://ultimateqa.com/automation");
        driver.manage().window().maximize();

        for (String str:emaiids) {
            WebElement emailID = driver.findElement(By.name("email"));
            emailID.sendKeys(str);
            WebElement subscribe = driver.findElement(By.name("jetpack_subscriptions_widget"));
            subscribe.click();

            WebElement noOfSub = driver.findElement(By.xpath("//div[@class='wp-block-jetpack-subscriptions__subscount']"));
            String text = noOfSub.getText();
            System.out.println(text);
            driver.navigate().refresh();
        }
        driver.quit();
    }
}
