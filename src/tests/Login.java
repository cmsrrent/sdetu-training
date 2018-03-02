package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.DashboardPage;
import pages.LoginPage;

public class Login {

	@Test
	public void loginTestPOM() {
	
		// 1. initialise driver
		WebDriver driver = utilities.DriverFactory.open("Firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// 2. enter login information (login page)
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("tim@testemail.com");
		loginPage.setPassword("trpass");
		loginPage.clickSubmit();
	
		// 3. Get confirmation (Dashboard page)
		DashboardPage dashboardPage = new DashboardPage(driver);
		String conf = dashboardPage.confirmationMessage();				
		String title = dashboardPage.title();
				
		// 4. Assertions
		Assert.assertTrue(conf.contains("success"));
		Assert.assertTrue(title.contains("Account"));
		
		// 5. Close the driver
		driver.quit();
	
	}
}
