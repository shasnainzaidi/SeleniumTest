import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void loginViaValidCredentials() throws InterruptedException {

        driver.get("https://bayut.com");
        driver.findElement(By.cssSelector("button[aria-label='Login'] ")).click();
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("muhammad.haris@dubizzlelabs.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("1234567a");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String actualUsername = driver.findElement(By.cssSelector("[aria-label='Username']")).getText();
        String expectedUsername = "Haris";
        assert actualUsername.equals(expectedUsername);
    }

    @Test
    public void loginViaInvalidCredentials() {
        driver.get("https://bayut.com");
        driver.findElement(By.cssSelector("button[aria-label='Login'] ")).click();
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("muhammad.haris@dubizzlelabs.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("1234567b");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        assert driver.findElement(By.xpath("//div[text() = '* The email address and password do not match']")).isDisplayed();
    }


    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
