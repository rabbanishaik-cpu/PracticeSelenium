//NOTES
//We use List to store all links of the website.
//Iterator to iterate through the list,
// iterator.next().getAttribute("href");
// create object for URL and pass link as argument
//create object for HttpURLConnection and type cast url to HttpURLConnection and call url.openConnection();
//httpUrlConnection.connect();
//httpUrlConnection.getResponseCode();
//httpUrlConnection.getResponseMessage();
//catch exceptions so that flow of the program continues without stopping
//https://www.guru99.com/find-broken-links-selenium-webdriver.html
//https://www.techlistic.com/2020/03/selenium-webdriver-get-all-page-links.html
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindBrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://phptravels.com/demo/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //declare a list and find all links in website and store in it.
        List<WebElement> links = driver.findElements(By.tagName("a"));

//        for (WebElement l:links) {
//            System.out.println(l.getText());
//        }

        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()){
            String linkUrl =iterator.next().getAttribute("href");
            verifyLinks(linkUrl);
        }
        driver.close();
    }

    private static void verifyLinks(String linkUrl) throws IOException {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400)
                System.out.println(linkUrl + "-" + httpURLConnection.getResponseMessage() + " is broken");
            else
                System.out.println(linkUrl + "-" + httpURLConnection.getResponseMessage() + " is Working");
        } catch (IOException e){
            System.out.println("Exception caught");
            e.printStackTrace();
        }
    }
}