package CommonLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionControl {

	public WebDriver driver;

	
	
	public ActionControl(WebDriver driver) {
		this.driver = driver;
	}
	
	public Actions getAction(){
		Actions action = new Actions(driver);
		return action;
	}
	
	public void moveToElement(WebElement element) throws Exception {
		getAction().moveToElement(element).build().perform();
		
	}
}
	