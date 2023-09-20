import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class homepage {
	
	private WebDriver driver;
	
	@Test
	public void keywordSearch(){
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://www.dubizzle.com.bh/en/");
		 
		 //1. search a keyword in search bar
		 driver.findElement(By.xpath("//input[@class='_162767a9']")).sendKeys("iphone 11 pro max");
		 
		 //2. Click on search button
		 driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
		 
		 //3. Verify if keyword is searched on search page.
		String searchKeyword =  driver.findElement(By.cssSelector("._888f7099")).getText();
		System.out.println(searchKeyword);
		String location = driver.findElement(By.xpath("//span[@class='_6d5b4928']")).getText();
		String expectedKeyword = ("Iphone 11 Pro Max in " + location);
		System.out.println(expectedKeyword);
		Assert.assertEquals(searchKeyword, expectedKeyword);
		
		
		
		
		
		
	}

}
