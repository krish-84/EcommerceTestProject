package ECommerceTest;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import CommonLib.CommonDriver;
import ECommerce.DesktopsPage;
import ECommerce.HomePage;
import ECommerce.RegisterPage;
import Utility.Utility;

public class BaseScenarios {

	public Properties ConfigProperty;
	public CommonDriver cmnDriver;
	public static WebDriver driver;
	public HomePage HomePage;
	public DesktopsPage desktopPage;
	public RegisterPage registerPage;
	
	
	
	
	
	
	public BaseScenarios() {
		try {
			ConfigProperty = Utility.readProperty("C:\\Users\\ramakiye\\eclipse-workspace\\ECommerce\\src\\test\\java\\Utility\\Config.Properties");
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		cmnDriver = new CommonDriver(driver);
		
		cmnDriver.invokebrowser(ConfigProperty.getProperty("browserName"), ConfigProperty.getProperty("baseUrl"));
		driver = cmnDriver.driver;
		HomePage = PageFactory.initElements(driver, HomePage.class);
		desktopPage = PageFactory.initElements(driver, DesktopsPage.class);
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		Thread.sleep(6000);
		
			
	}
	
		
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
}

