import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTab {
	
	private WebDriver driver;
	
	@Test
	public void newTab() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("a[id='opentab']")).click();
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> tabsId = tabs.iterator();
        String ParentTab = tabsId.next();
        String ChildTab = tabsId.next();
        driver.switchTo().window(ChildTab);
        System.out.println(driver.getTitle());
        driver.switchTo().window(ParentTab);
        System.out.println(driver.getTitle());
        
        driver.quit();


	}
	
	@Test
	public void newWindow() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//button[@class='btn-style class1']")).click();
//        driver.switchTo().window(windowHandle);
        Set<String> newWindow = driver.getWindowHandles();
//        Iterator<String> window = newWindow.iterator();
        for(String windowHandle : newWindow) {
        	driver.switchTo().window(windowHandle);
        }
//        driver.switchTo().window(newWindow.next());
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        
        driver.quit();

	}
	

}
