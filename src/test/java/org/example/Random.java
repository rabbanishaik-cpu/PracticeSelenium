package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Random {
    public ChromeOptions chromeOptions;
    public WebDriver driver;
    public String url ="https://www.verizon.com";

    @BeforeMethod
    public void setUp(){
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

    }
    @Test
    public void signIn(){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String Title=driver.getTitle();
        System.out.println(Title);
        Actions actions=new Actions(driver);
        //actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"gnav20-sign-id\"]/span/span"))).build().perform();
        driver.findElement(By.xpath("//*[@id=\"gnav20-sign-id\"]/span/span")).click();
        driver.findElement(By.linkText("Sign in to My Account")).click();
        String nextpageTitle = driver.getTitle();
        System.out.println(nextpageTitle);
    }
    @Test
    public void dropDown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        WebElement dropdown=driver.findElement(By.id("dropdown"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("Option 1");

        //digging deep into the dropdown webelement
        WebElement option1=dropdown.findElement(By.cssSelector("option[value='1']"));
        WebElement option2=dropdown.findElement(By.cssSelector("option[value='2']"));

        Assert.assertTrue(option1.isSelected());
        Assert.assertFalse(option2.isSelected());

    }
    @Test
    public void linkText() {
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        driver.manage().window().maximize();

        WebElement icon =driver.findElement(By.linkText("Clickable Icon"));
        String link=icon.getAttribute("href");
        Assert.assertEquals(link,"https://ultimateqa.com/link-success/","Failed");

        Assert.assertEquals(icon.getCssValue("background-origin"),"padding-box");
    }
    @Test
    public void checkHighlightedBox() {
        driver.get("https://example.cypress.io/commands/actions");
        driver.manage().window().maximize();

        WebElement textbox =driver.findElement(By.cssSelector(".action-focus"));
        textbox.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@for='password1']")).getAttribute("style")
                .contains("color: orange"));
    }
    @Test
    public void scrollToBottom() throws InterruptedException {
        driver.get("https://ultimateqa.com/complicated-page/");
        driver.manage().window().maximize();

        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(1000);
    }
    @Test
    public void scrollToTop() throws InterruptedException {
        driver.get("https://ultimateqa.com/complicated-page/");
        driver.manage().window().maximize();

        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(1000);

        javascriptExecutor.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
