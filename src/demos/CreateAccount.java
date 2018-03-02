package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {

		//1. create webdriver
		System.setProperty("webdriver.gecko.driver", "C:\\dev\\selenium\\software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//2. nav to account management >> click create account
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("Create Account")).click();
		
		//3. fill out form
		
			//locate elements
			driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Tom Test");
			driver.findElement(By.id("MainContent_txtEmail")).sendKeys("TT@testemail.com");
			driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys("01511111111");
			driver.findElement(By.cssSelector("input[type='password']")).sendKeys("mspass");
			driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("mspass");
		
			//interact with elements
			driver.findElement(By.id("MainContent_Female")).click();
			
			new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Germany");
			
			driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
			
			driver.findElement(By.id("MainContent_btnSubmit")).click();
			
		//4. get confirmation
			String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
			System.out.println("CONFIRMATION: " + conf);
			
						
		//5. close browser
			driver.close();
			
	}

}
