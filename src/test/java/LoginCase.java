import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginCase {

	private WebDriver driver;
	
	@Test
	public void failedLoginEmail(){
	//1. go to URL
	
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.dubizzle.com.bh/en/");

    //
    
	//2. Click on Login button
    driver.findElement(By.cssSelector("button[aria-label='Login']")).click();
    System.out.println("logged in button");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    driver.switchTo().alert().accept();
    System.out.println("clicked logged in button");

//    driver.findElement(By.xpath("//button[@xpath='3']")).click();
	driver.findElement(By.xpath("//span[.='Continue with Email']")).click();
//    driver.switchTo().alert().accept();

    System.out.println("clicked email button");

    //4. Enter a valid Email
    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("hasnain.zaidi@empglabs.com");
    // 5. Click on next
    driver.findElement(By.xpath("(//span[@class='_5079de6b be13fe44'])[2]")).click();
	//5. Enter Password
    driver.findElement(By.id("password")).sendKeys("qerty1");
	//6. click on login
    driver.findElement(By.cssSelector("button[type='button'] span[class='_5079de6b be13fe44']")).click();
	//7. Check if user is logged in(Failed case)
    String failedText = driver.findElement(By.xpath("//span[@class='ee61ea1e fab3055b']/child::span")).getText();
    System.out.println(failedText);
    String expectedText = "Invalid credentials.";
    Assert.assertEquals(failedText, expectedText);
	
	}
	@Test
	public void passedLoginEmail(){
		//1. go to URL
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.dubizzle.com.bh/en/");

	    //
	    
		//2. Click on Login button
	    driver.findElement(By.cssSelector("button[aria-label='Login']")).click();
	    System.out.println("logged in button");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	    driver.switchTo().alert().accept();
	    System.out.println("clicked logged in button");

//	    driver.findElement(By.xpath("//button[@xpath='3']")).click();
		driver.findElement(By.xpath("//span[.='Continue with Email']")).click();
//	    driver.switchTo().alert().accept();

	    System.out.println("clicked email button");

	    //4. Enter a valid Email
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("hasnain.zaidi@empglabs.com");
	    // 5. Click on next
	    driver.findElement(By.xpath("(//span[@class='_5079de6b be13fe44'])[2]")).click();
		//5. Enter Password
	    driver.findElement(By.id("password")).sendKeys("qwerty1");
		//6. click on login
	    driver.findElement(By.cssSelector("button[type='button'] span[class='_5079de6b be13fe44']")).click();
		//7. Check if user is logged in(passed case)
	    driver.findElement(By.xpath("//img[@class='_874da736']")).click();
	    String userName = driver.findElement(By.xpath("//span[@class='_061b8584 be13fe44']")).getText();
	    System.out.println(userName);
	    String expectedText = "Hasnain";
	    Assert.assertEquals(userName, expectedText);
		
		}
	@Test 
	public void sellButtonLogin() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.dubizzle.com.bh/en/");
		//1. Click on Sell button
		driver.findElement(By.xpath("//button[@class='_4408f4a8 _58676a35']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//2. Click on login with email
		driver.findElement(By.xpath("(//button[@class='_4408f4a8 _5d33e436'])[3]")).click();
		//3. Enter email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("hasnain.zaidi@empglabs.com");
		//4. Click Next
		driver.findElement(By.xpath("(//button[@class='_4408f4a8 _58676a35'])[2]")).click();
		//5. Enter Password
		driver.findElement(By.id("password")).sendKeys("qwerty1");
		//6. Click Login
		driver.findElement(By.xpath("(//button[@class='_4408f4a8 _58676a35'])[2]")).click();
		//7. Select a category
		driver.findElement(By.xpath("(//div[@class='_1075545d _0e6551d1 _505c5f3e dc7134ee _96d4439a'])[13]")).click();
		//8. Select a sub category
		driver.findElement(By.xpath("(//div[@class='_1075545d _0e6551d1 _505c5f3e dc7134ee _96d4439a'])[24]")).click();
		//9. Enter Ad title
		driver.findElement(By.id("title")).sendKeys("Car spare Parts for sale");
		//10. enter ad description
		driver.findElement(By.id("description")).sendKeys("Car spare Parts for sale at a very reasonable prices for all");
		//11. set price
		driver.findElement(By.id("price")).sendKeys("100");
		//12. Set location
		driver.findElement(By.xpath("(//div[@class='e6f2da21'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='a9021c2f'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='e6f2da21'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='_01c86e7b'])[2]")).click();
		//click on post now
		driver.findElement(By.xpath("//button[@class='_4408f4a8 _58676a35']")).click();
		
		
		
	
		
		
	}
	
	
	
}
