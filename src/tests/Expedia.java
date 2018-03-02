package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {

	WebDriver driver;
	String browserType = "chrome";
	String city = "New York, NY";
	String checkIn = "10/12/2018";
	String checkOut = "17/12/2018";
	String noOfAdults = "3";
	String starRating = "star4";
	String searchResult = "2";
	
	@Test
	public void hotelReservation() {
		// 1. Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);		
		new Select(driver.findElement(By.xpath("//*[@id=\"hotel-1-adults-hp-hotel\"]"))).selectByValue(noOfAdults);
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[9]/label/button")).click();
		
		// print name of city
		String actualCity = driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).getText();
		System.out.println("CITY: " + actualCity);
		
		// 2. Modify search results page, give criteria		
		driver.findElement(By.cssSelector("input[name='star'][id='" + starRating + "']")).click();
				
		// 3. Analyse results and make selection
		WebDriverWait wait = new WebDriverWait(driver, 6);
		WebElement selectedHotel = wait.until(
		ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"resultsContainer\"]/section/article[\"+ searchResult + \"]/div[2]/div/a")));
		selectedHotel.click();
				
		//driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article["+ searchResult + "]/div[2]/div/a")).click();
		
		// Switch tab to newly opened tab
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(2));
		
		// Print hotel name and star rating		
		String hotelName =  driver.findElement(By.id("hotel-name")).getText();		
		System.out.println("HOTEL: " + hotelName);
		
		// 4. Book reservation
		
		driver.findElement(By.xpath("//*[@id=\"rooms-and-rates\"]/div/article/table/tbody/tr/td[4]/form/div[1]/button")).click();
		
		//*[@id="rooms-and-rates"]/div/article/table/tbody[1]/tr/td[4]/div/div[1]/button
		
		// 5. Fill out contact / billing
		
		
		// 6. Get confirmation
		
		
	}
	
	@BeforeMethod
	public void setup() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.expedia.co.uk/");		
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
}
