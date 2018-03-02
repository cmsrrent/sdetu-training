package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	//Return webdriver object
	public static WebDriver open(String browserType) {
		
		if (browserType.equalsIgnoreCase("firefox")){ 
			//FF
			System.setProperty("webdriver.gecko.driver", "C:\\dev\\selenium\\software\\geckodriver.exe");
			return new FirefoxDriver();		
		}
		else if (browserType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\dev\\selenium\\software\\IEDriverServer.exe");
			return new InternetExplorerDriver();	
			
		}
		else {
			System.setProperty("webdriver.chrome.driver", "C:\\dev\\selenium\\software\\chromedriver.exe");
			return new ChromeDriver();
			
		}
	}
	
}
