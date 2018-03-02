package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	// Define web elements at class level
	
	WebDriver driver;
	
	@FindBy(id="MainContent_txtUserName")
	WebElement userNameBox;
	
	@FindBy(id="MainContent_txtPassword")
	WebElement passwordBox;
	
	@FindBy(id="MainContent_btnLogin")
	WebElement loginButton;
	
	// Steps
	public void setUserName(String username) {
		userNameBox.sendKeys(username);		
	}
	
	public void setPassword(String password) {
		passwordBox.sendKeys(password);		
	}
			
	public void clickSubmit() {
		loginButton.click();
	}
	
	// Actions
	public void login(String username, String password) {
		setUserName(username);
		setPassword(password);
		clickSubmit();
	}
	
	// constructor to initialise the driver
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		
		// initialise web elements
		PageFactory.initElements(driver, this);
		
	}
	
}
