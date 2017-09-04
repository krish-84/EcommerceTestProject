package ECommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DesktopsPage {
	
	public WebDriver driver;
	
	@FindBy (xpath = "/html/body/div[6]/div[3]/div[2]/div[2]/div/div[1]")
	WebElement desktopResult;
	
	public DesktopsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String desktopResultText() {
		String result = desktopResult.getText();
		return result;
	}
}
