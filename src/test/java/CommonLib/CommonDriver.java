package CommonLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonDriver {
	
	public WebDriver driver;
//	public long pageLoadTimeout;
//	public long elementDetectionTimeout;
	
	public CommonDriver(WebDriver driver) {
		this.driver = driver;
						
	}
	
	
	
	public void invokebrowser(String browsername, String url) {
		
		switch(browsername.toLowerCase()){
			case "firefox":
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\ramakiye\\.m2\\repository\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\ramakiye\\.m2\\repository\\chromedriver.exe");
			driver = new ChromeDriver();	
				
		}
		
		url = url.trim();
		
		if(url.isEmpty()){
			url = "about:blank";
		}
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(601, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(801, TimeUnit.SECONDS);
		
		driver.get(url);
		
	}


}
