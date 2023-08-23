import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDown {

private WebDriver driver;
	
	
	@Test
	
	public void DropDownTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    	Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		String option ="Option3";
		dropdown.selectByVisibleText(option);
			// we also have option for select
//		dropdown.selectByIndex(2);
//		dropdown.selectByValue(option);



		
		
	}
}
