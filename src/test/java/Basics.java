import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Basics {


    private WebDriver driver;

    @Test
    public void SeleniumBasics() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        TestCase
//         Visit URL
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//         Enter name
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hello");
//         click Confirm
        driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();

//         Confirm Alert

        driver.switchTo().alert().accept();

        // Radio Buttons
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[class='radioButton']"));
        for(int i = 0; i <= 2; i++) {
            WebElement getOne = radioButtons.get(i);
            getOne.click();
        }

        driver.quit();

    }


}
