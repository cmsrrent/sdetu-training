package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;



public class PageTitleJUnit {
	// 1 declare class level objects
	WebDriver driver;
	String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	
	@Test
	public void pageTitleTest() {				
		driver.get(webURL);
		String actualTitle = driver.getTitle();
		String expectedTitle = "SDET Training | Account Management";
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Before
	public void setUp() {
		driver = utilities.DriverFactory.open("chrome");
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
}
