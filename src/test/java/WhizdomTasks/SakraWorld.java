package WhizdomTasks;

import org.example.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class SakraWorld extends TestBase {
    @Test
    public void bookAppointment() throws IOException, InterruptedException {
        Properties properties = null;
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//WhizdomTasks//project.properties");
            properties.load(fileInputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        driver.get(properties.getProperty("hospitalUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(properties.getProperty("doctorName"))).click();
        driver.findElement(By.xpath(properties.getProperty("consultationButton"))).click();

        Thread.sleep(3000);

        //checking if name field is visible or not
        if (isElementVisible(properties.getProperty("nameTextBox"))) {
            //Entering data in form
            driver.findElement(By.id(properties.getProperty("nameTextBox"))).sendKeys(properties.getProperty("name"));
            driver.findElement(By.id(properties.getProperty("emailTextBox"))).sendKeys(properties.getProperty("email"));
            driver.findElement(By.id(properties.getProperty("mobileNumberBox"))).sendKeys(properties.getProperty("mobileNumber"));
        }else
            System.out.println("Name field is not visible");

    }
    public boolean isElementVisible(String locator){
        WebElement webElement;
        try{
            webElement=driver.findElement(By.id(locator));
            if (!webElement.isDisplayed())
                return false;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
