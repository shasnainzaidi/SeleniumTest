package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Resources;

public class Login {

    public WebDriver driver;

    @FindBy(css = "button[aria-label='Login']")
    public WebElement loginBtn;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;
  
    
    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
