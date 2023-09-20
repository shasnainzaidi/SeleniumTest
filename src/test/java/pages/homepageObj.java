package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepageObj {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//input[@class='_162767a9']")
	public WebElement searchBar;
	
	public homepageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
