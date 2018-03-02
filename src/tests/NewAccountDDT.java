package tests;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {	
	
	WebDriver driver;
	String name, email, phone, gender, password, country;	
	boolean weeklyEmail, monthlyEmail, occasionalEmail;	
	String browserType = "chrome";
	WebElement nameElement, emailElement, phoneElement, passwordElement, verifyPasswordElement,	countryElement,
		maleRadio, femaleRadio, weeklyCheckbox,	occasionalCheckbox,	submitButton;
	
	
	//This is our test method
	@Test
	public void newAccountTest() {
		System.out.println("New Record: " + name + " " + email + " " + phone + " " + gender + " " + password + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);
		
		defineWebElements();
		
		//3. fill out form			
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phone);
		passwordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		new Select(countryElement).selectByVisibleText(country);
		
		//Gender Radio button algorithm											
		if (gender.equalsIgnoreCase("Male")) { maleRadio.click(); }
		else { femaleRadio.click();	}
		
		//Weeklyemail checkbox
		if (weeklyEmail) {
			if (!weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		}
		else {
			if (weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		}
		
		
		//Occasionalemail checkbox
		if (occasionalEmail) {
			if (!occasionalCheckbox.isSelected()) {
				occasionalCheckbox.click();
			}
		}
		else {
			if (occasionalCheckbox.isSelected()) {
				occasionalCheckbox.click();
			}
		}
		
		//submit form
		submitButton.click();
					
		//4. get confirmation & close
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if (conf.contains(expected)) {
			System.out.println("CONFIRMATION: " + conf);
		}
		else {
			System.out.println("TEST FAILED");
		}					
		
	}
	
	@Before
	public void setup() {
		driver = utilities.DriverFactory.open(browserType);		
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	public void defineWebElements() {
	
		//define web elements
		nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		phoneElement = driver.findElement(By.id("MainContent_txtHomePhone"));
		passwordElement = driver.findElement(By.cssSelector("input[type='password']"));
		verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		maleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
		femaleRadio = driver.findElement(By.id("MainContent_Female"));
		weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));		
		occasionalCheckbox = driver.findElement(By.name("ctl00$MainContent$checkUpdates"));
		submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
		
	}
	
	// Annotated method to pass parameters into class via constructor
	@Parameters
	public static List<String[]> getData() {
		return utilities.CSV.get("C:\\SDETUniversity\\Files\\UserAccounts.csv");
	}

	// Constructor that passes parameters to the test method
	public NewAccountDDT(String name, String email, String phone, String gender, String password, String country,
			String weeklyEmail, String monthlyEmail, String occasionalEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		
		if (weeklyEmail.equals("TRUE")) {this.weeklyEmail = true; }
		else { this.weeklyEmail = false; }
		
		if (monthlyEmail.equals("TRUE")) {this.monthlyEmail = true; }
		else { this.monthlyEmail = false; }
		
		if (occasionalEmail.equals("TRUE")) {this.occasionalEmail = true; }
		else { this.occasionalEmail = false; }
		
	}
	
}
