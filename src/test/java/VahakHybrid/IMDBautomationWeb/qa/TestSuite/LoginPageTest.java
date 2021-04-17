package VahakHybrid.IMDBautomationWeb.qa.TestSuite;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import VahakHybrid.IMDBautomationWeb.qa.Base.TestBase;
import VahakHybrid.IMDBautomationWeb.qa.ExcelReader.TestDataReadFromExcelFile;
import VahakHybrid.IMDBautomationWeb.qa.PageObject.HomePagePO;
import VahakHybrid.IMDBautomationWeb.qa.PageObject.LoginOptionPagePO;
import VahakHybrid.IMDBautomationWeb.qa.PageObject.LoginPagePO;

public class LoginPageTest extends TestBase{
	
	LoginPageTest(){
		super();
	}
	
	HomePagePO hp;
	LoginOptionPagePO lop;
	LoginPagePO lp;
	
	@BeforeMethod
	public void setup() {
		initialization();
		hp=new HomePagePO();
		lop=new LoginOptionPagePO();
		lp=new LoginPagePO();	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getDataExcel() throws InvalidFormatException {
		Object [][] data=TestDataReadFromExcelFile.getTestData("UserRegistration1");
		
		return data;
	}
	
	@Test(dataProvider="getDataExcel")
	public void testLogin(String userName, String pass) {
		hp.clickSignIn();
		lop.clickSign_with_IMDb();
		lp.enterCredentails(userName, pass);
		hp.checkUserAfterLogin(userName);
		Assert.assertTrue(hp.checkUserAfterLogin(userName));
		System.out.println("testLogin passed.");
	}

}
