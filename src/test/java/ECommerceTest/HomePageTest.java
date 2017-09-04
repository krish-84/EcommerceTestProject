package ECommerceTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Utility;

public class HomePageTest extends BaseScenarios {

	@Test(enabled = false)
	public void verifyHomePageTitle() {

		Assert.assertEquals(cmnDriver.driver.getTitle(), ConfigProperty.getProperty("homePageTitle"));
	}

	@Test(enabled = false)
	public void registerNewUser() throws Exception {
		int i;

		Utility.setExcelFile(
				"C:\\Users\\ramakiye\\eclipse-workspace\\ECommerce\\src\\test\\java\\TestData\\userlogindata.xlsx",
				"Sheet1");

		int totalRows = Utility.ExcelWSheet.getLastRowNum();

		for (i = 1; i <= totalRows; i++) {

			String FN = null;
			String LN = null;
			String dob = null;

			FN = Utility.getCellData(i, 0);
			LN = Utility.getCellData(i, 1);
			dob = Utility.getCellData(i, 2);

			HomePage.registerAUser(FN, LN, dob);
			String result = HomePage.registerResult();
			Assert.assertEquals(result, "Your registration completed", "Failed");
			registerPage.clickLogOut();

		}
	}

	@Test(enabled = false)
	public void verifyDesktopLink() throws Exception {

		HomePage.clickDesktopLink();
		String result = desktopPage.desktopResultText();

		Assert.assertEquals(result, "Desktops", "Failed");
	}

	@Test(enabled = true, dataProvider = "getData")
	public void registerNewUserwithDataProvider(String FN, String LN, String dob) throws Exception {
		HomePage.registerAUser(FN, LN, dob);
		String result = HomePage.registerResult();
		Assert.assertEquals(result, "Your registration completed", "Failed");
		registerPage.clickLogOut();
	}

	@DataProvider
	public Object[][] getData() throws Exception {

		Utility.setExcelFile(
				"C:\\Users\\ramakiye\\eclipse-workspace\\ECommerce\\src\\test\\java\\TestData\\userlogindata.xlsx",
				"Sheet1");

		int totalRows = Utility.ExcelWSheet.getLastRowNum();

		Object[][] data;

		data = new Object[totalRows][3];

		for (int iRow = 1; iRow <= totalRows; iRow++) {

			for (int iCell = 0; iCell <= 2; iCell++) {

				data[iRow - 1][iCell] = Utility.getCellData(iRow, iCell);

			}
		}
		return data;
	}
}
