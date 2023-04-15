//Output will be
//Hi BeforeTest here!
//Hi BeforeClass here!
//Hi BeforeMethod here!
//Hi Test 1 here!
//Hi AfterMethod here!
//Hi BeforeMethod here!
//Hi Test 2 here!
//Hi AfterMethod here!
//Hi AfterClass here!
//Hi AfterTest here!
package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Annotations {
    @BeforeClass
    public void BeforeClass(){
//        WebDriver driver = new FirefoxDriver();
//        driver.get("https://testng.org/doc/documentation-main.html");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
        System.out.println("Hi BeforeClass here!");
    }
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("Hi BeforeMethod here!");
    }
    @BeforeTest
    public void BeforeTest(){
        System.out.println("Hi BeforeTest here!");
    }

    //timeOut Attribute is used to set time for the test case, if the teat does not run in specified time, it will get
    //skipped. time in milliseconds
    //using enabled = false we can skip the testCase
    @Test(priority = 0,timeOut = 5000, enabled = false)
    public void Test1(){
        System.out.println("Hi Test 1 here!");
    }

    //using InvocationCount = 2 we can run a test multiple times
    @Test(priority = 1,invocationCount = 1)
    public void Test2(){
        System.out.println("Hi Test 2 here!");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("Hi AfterTest here!");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("Hi AfterMethod here!");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("Hi AfterClass here!");
    }
}
