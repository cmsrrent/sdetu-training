package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		String name = "Tom Riddle";
		String email = "ts@testemail.com";
		String password = "mspass";		
		String country = "Germany";
		String phoneNumber = "01511111111" ;
		String browserType = "firefox";
		String gender = "Male";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occasionalEmail = true;
		
		// Define WebDriver
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType);		
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();
		
		//define web elements
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.id("MainContent_txtHomePhone"));
		WebElement passwordElement = driver.findElement(By.cssSelector("input[type='password']"));
		WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement maleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
		WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		WebElement monthlyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail"));
		WebElement occasionalCheckbox = driver.findElement(By.name("ctl00$MainContent$checkUpdates"));
		WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
		
		//3. fill out form			
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phoneNumber);
		passwordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		new Select(countryElement).selectByVisibleText(country);
		
		//Gender Radio button algorithm											
		if (gender.equalsIgnoreCase("Male")) {			
			maleRadio.click();			
		}
		else {
			femaleRadio.click();	
		}
		
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
		
		//Monthlyemail checkbox
		if (monthlyEmail) {
			if (!monthlyCheckbox.isSelected()) {
				monthlyCheckbox.click();
			}
		}
		else {
			if (monthlyCheckbox.isSelected()) {
				monthlyCheckbox.click();
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
		
		
		driver.close();
			
	}

}

