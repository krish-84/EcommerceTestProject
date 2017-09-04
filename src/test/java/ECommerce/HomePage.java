package ECommerce;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	@FindBy(id = "customerCurrency")
	WebElement customerCurrencyLink;

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(id = "gender-male")
	WebElement maleCheckBox;

	@FindBy(xpath = "//*[@id='FirstName']")
	WebElement firstName;

	@FindBy(xpath = "//*[@id='LastName']")
	WebElement lastName;

	@FindBy(name = "DateOfBirthDay")
	WebElement DateOfBirthDay;

	@FindBy(name = "DateOfBirthMonth")
	WebElement DateOfBirthMonth;

	@FindBy(name = "DateOfBirthYear")
	public WebElement DateOfBirthYear;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Company")
	WebElement company;

	@FindBy(id = "Newsletter")
	WebElement newsletterCheckbox;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassword;

	@FindBy(id = "register-button")
	WebElement registerButton;

	@FindBy(className = "result")
	WebElement registerResult;

	@FindBy(linkText = "Computers")
	WebElement computerLink;

	@FindBy(linkText = "Desktops")
	WebElement desktopLink;

	public Actions action;
	public Select dropdown;
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	public void SelectDollorfromCustomerCurrency() {

		dropdown = new Select(customerCurrencyLink);
		dropdown.selectByValue("US Dollar");

	}

	public void registerAUser(String FN, String LN, String dob) throws Exception {

		registerLink.click();
		maleCheckBox.click();
		firstName.sendKeys(FN);
		lastName.sendKeys(LN);
		dropdown = new Select(DateOfBirthDay);
		dropdown.selectByVisibleText(dob);
		dropdown = new Select(DateOfBirthMonth);
		dropdown.selectByVisibleText("August");
		dropdown = new Select(DateOfBirthYear);
		dropdown.selectByVisibleText("2017");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		email.sendKeys("Krish" + sdf.format(cal.getTime()) + "@gmail.com");
		company.sendKeys("Sogeti");
		newsletterCheckbox.click();
		password.sendKeys("qwer1234");
		confirmPassword.sendKeys("qwer1234");
		registerButton.click();

	}

	public void clickDesktopLink() throws Exception {

		movetoComputerLink();
		desktopLink.click();

	}

	public void movetoComputerLink() throws Exception {

		action = new Actions(driver);
		action.moveToElement(computerLink).build().perform();
		Thread.sleep(3000);

	}

	public String registerResult() {
		String result = registerResult.getText();
		return result;
	}

}
