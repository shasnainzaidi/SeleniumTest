import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	private WebDriver driver;
	
@Test		// TODO Auto-generated method stub
public void BasicTest() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	//1. Visit site
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
			//2. Enter Country Name
	driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Pakistan");
	//3. Enter Name
	driver.findElement(By.cssSelector("input[id='name']")).sendKeys("Hasnain");
	
	//3. Click Confirm
	driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();	
			
		//4. Confirm Alert
	driver.switchTo().alert().accept();
	
	
	}

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
