package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class mouseActions {
    private WebDriver driver;
    private ChromeOptions chromeOptions;
    String url="https://www.snapdeal.com";

    @BeforeMethod
    public void setUp(){
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }
    @Test
    public void mouseActions(){
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //mouse Hover
        Actions actions = new Actions(driver);
        WebElement signInButton = driver.findElement(By.xpath("//div[@class='accountInner']/span[contains(text(),'Sign In')]"));
        actions.moveToElement(signInButton).perform();

        WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'login')]"));
        loginButton.click();
    }
    @Test
    public void hovers(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement user1=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        actions.moveToElement(user1).perform();

        WebElement text = driver.findElement(By.xpath("//*[contains(text(),'name: user1')]"));
        Assert.assertTrue(text.isDisplayed());
    }
    @Test
    public void rightClick() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        driver.manage().window().maximize();

        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        //When doing mouse actions, don't forget to perform();
        actions.contextClick(box).perform();
        driver.switchTo().alert().accept();
    }
    @Test
    public void keyPresses() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        driver.manage().window().maximize();

        WebElement box = driver.findElement(By.id("target"));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        String text=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(text,"You entered: RIGHT","right key is not pressed");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
