import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Login;
import pages.homepageObj;

public class homepage {
	
	private static final TimeUnit TimeUnit = null;
	private WebDriver driver;
	private homepageObj homepage;

	@BeforeTest 
	public void intialization() {
	//homepage = new homepageObj(driver);
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
		
	}

	@Test (groups="Sanity")
	public void keywordSearch(){
		

		//WebDriverManager.chromedriver().setup();
		 //driver = new ChromeDriver();
		 driver.get("https://www.dubizzle.com.bh/en/");
			homepage = new homepageObj(driver);

		 //1. search a keyword in search bar
		 homepage.searchBar.sendKeys("iphone 11 pro max");
		 
		 //2. Click on search button
		 homepage.searchBtn.click();
		 
		 //3. Verify if keyword is searched on search page.
		String searchKeyword =  driver.findElement(By.cssSelector("._888f7099")).getText();
		System.out.println(searchKeyword);
		String location = driver.findElement(By.xpath("//span[@class='_6d5b4928']")).getText();
		String expectedKeyword = ("Iphone 11 Pro Max in " + location);
		System.out.println(expectedKeyword);
		Assert.assertEquals(searchKeyword, expectedKeyword);
		
	}
	
	@Test (groups = {"Smoke"})
	public void verifyAllIn() throws InterruptedException {
		
		driver.get("https://www.dubizzle.com.bh/en/");
		
		List <WebElement> categoryButtons = driver.findElements(By.xpath("//div[@class='_1adcd900']"));
		for (int i=0; i<=13; i++) {
			categoryButtons.get(i).click();
			System.out.println("element clicked");
			driver.navigate().back();
			Thread.sleep(8000);
//			WebDriverWait wait = new WebDriverWait(driver,30);
//			wait.until(ExpectedConditions.visibilityOfAllElements(categoryButtons));
		};
				
		
		
		
	}
	@Test (groups="Sanity")
	
public void searchFilter(){
		

		//WebDriverManager.chromedriver().setup();
		 //driver = new ChromeDriver();
		 driver.get("https://www.dubizzle.com.bh/en/");
			homepage = new homepageObj(driver);

			driver.findElement(By.xpath("(//a[@class='_21f8dc94'])[1]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			//apply location
			driver.findElement(By.xpath("(//(span[@class='_7597a67d'])[9]")).click();
			
			//apply make
			driver.findElement(By.xpath("(//span[@class='_82157ede'])[1]")).click();
			
			//apply model
			driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
			
			//price
			driver.findElement(By.xpath("(//input[@class='_162767a9'])[3]")).sendKeys("2000");

			driver.findElement(By.xpath("(//input[@class='_162767a9'])[4]")).sendKeys("2022");
		 //1. search a keyword in search bar
		// homepage.searchBar.sendKeys("iphone 11 pro max");
		 
		 //2. Click on search button
		// homepage.searchBtn.click();
		 
		 // 3. Select a category
		 
	
	
	
	}

	 @Test
	    public void catClick(){
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.dubizzle.com.bh/en/");

	        //1. search a keyword in search bar
	        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_1adcd900']"));

	        for (int i=0; i<= 12; i++) {
	            WebElement el = elements.get(i);
	            System.out.println("start");
	            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	         //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
	           // wait.until(ExpectedConditions.elementToBeClickable(el)).click();
	            System.out.println("done with wait");

//	            element.click();
	            System.out.println("Clicked");
	            driver.navigate().back();
	        }
	 }
	        @Test
	        public void viewMore() {
	        	WebDriverManager.chromedriver().setup();
	        	driver = new ChromeDriver();
	        	driver.get("https://www.dubizzle.com.bh/en/");
	        	
	        	//1. Click on element
	        	List<WebElement> elements = driver.findElements(By.xpath("//span[@class='ab6d65bd']"));
	        	
	        	//for loop
	        	for (int i=0; i<=7; i++) {
	        		WebElement el = elements.get(i);
	        		System.out.println("Start");
	        		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        		System.out.println("Done with wait");
	        		System.out.println("Element Clicked");
	        		driver.navigate().back();

	        	}
	        		
	        }
	        
	        @Test 
	        public void footerLinks() {
	        	
	        	WebDriverManager.chromedriver().setup();
	        	driver = new ChromeDriver();
	        	driver.get("https://www.dubizzle.com.bh/en/");
	        	
	        	List <WebElement> elements = driver.findElements(By.xpath("(//span[@class='_5e159053'])"));
	        	
	        	for (int i=0; i<=14; i++) {
	        		WebElement el = elements.get(i);
	        	System.out.println("Started loop");
	        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        	System.out.println("Waited");
	        	System.out.println("Element Clicked");
	        	driver.navigate().back();
	        	
	        	}
	        	
	        	
	        }
	        
	      @Test
	      public void allCat() {
	    	  
	    	  WebDriverManager.chromedriver().setup();
	    	  driver = new ChromeDriver();
	    	  driver.get("https://www.dubizzle.com.bh/en/");
	    	  
	    	  driver.findElement(By.xpath("//div[@class='f4cbb336']")).click();
	    	  String categoryClicked = driver.findElement(By.xpath("(//a[@href='/en/vehicles/'])[1]")).getText();

	    	  driver.findElement(By.xpath("(//a[@href='/en/vehicles/'])[1]")).click();
	    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	  //Assertion
	    	  String categoryName = driver.findElement(By.xpath("(//span[@class='_7597a67d dd224544'])[1]")).getText();

	    	  System.out.println(categoryName);
	    	  Assert.assertEquals(categoryName, categoryClicked);
	      }
	    	
	    	  
	    @Test
	    public void aboutDG() {
	    	
	    		WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            driver.get("https://www.dubizzle.com.bh/en/");
	            //1. click on element
	            driver.findElement(By.xpath("(//span[@class='_5e159053'])[1]")).click();
//	            driver.switchTo().window(windowHandle);
	            Set<String> newWindow = driver.getWindowHandles();
//	            Iterator<String> window = newWindow.iterator();
	            for(String windowHandle : newWindow) {
	            	driver.switchTo().window(windowHandle);
	            }
//	            driver.switchTo().window(newWindow.next());
//	            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            System.out.println(driver.getTitle());
	            String actualTitle = driver.getTitle();
	            String expectedTitle = "Dubizzle Group - Formerly EMPG";
	            Assert.assertEquals(actualTitle, expectedTitle);
	            driver.quit();
	    	  
	    	  
	      }
	      @Test
	      public void contactUs() {
		    	
	    		WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            driver.get("https://www.dubizzle.com.bh/en/");
	            //1. click on element
	            driver.findElement(By.xpath("(//span[@class='_5e159053'])[3]")).click();
//	            driver.switchTo().window(windowHandle);
	            Set<String> newWindow = driver.getWindowHandles();
//	            Iterator<String> window = newWindow.iterator();
	            for(String windowHandle : newWindow) {
	            	driver.switchTo().window(windowHandle);
	            }
//	            driver.switchTo().window(newWindow.next());
//	            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            System.out.println(driver.getTitle());
	            String actualTitle = driver.getTitle();
	            String expectedTitle = "Submit a request – dubizzle Bahrain";
	            Assert.assertEquals(actualTitle, expectedTitle);
	            driver.quit();
	    	  
	    	  
	      }
	        
	        
	        
	 
	 }

