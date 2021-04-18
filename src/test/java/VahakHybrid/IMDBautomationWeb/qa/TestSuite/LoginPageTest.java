package VahakHybrid.IMDBautomationWeb.qa.TestSuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

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
	SoftAssert sa;
	
	@BeforeMethod
	public void setup() {
		initialization();
		hp=new HomePagePO();
		lop=new LoginOptionPagePO();
		lp=new LoginPagePO();
		sa=new SoftAssert();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getDataExcelvalidCredential() throws InvalidFormatException {
		Object [][] data=TestDataReadFromExcelFile.getTestData("validCredential");
		
		return data;
	}
	
	@DataProvider
	public Object[][] getDataExcelinvalidUN() throws InvalidFormatException {
		Object [][] data=TestDataReadFromExcelFile.getTestData("invalidUN");
		
		return data;
	}
	@DataProvider
	public Object[][] getDataExcelinvalidPass() throws InvalidFormatException {
		Object [][] data=TestDataReadFromExcelFile.getTestData("invalidPass");
		
		return data;
	}
	
	@Test(dataProvider="getDataExcelvalidCredential")
	public void testValidLogin(String userName, String pass) {
		hp.clickSignIn();
		lop.clickSign_with_IMDb();
		lp.enterValidCredentails(userName, pass);
		//hp.checkUserAfterLogin(userName);
		AssertJUnit.assertTrue(hp.checkUserAfterLogin(userName));
	}
	
	@Test(dataProvider="getDataExcelinvalidUN",dependsOnMethods = "testValidLogin")
	public void testLoginWrongUN(String userName, String pass) {
		hp.clickSignIn();
		lop.clickSign_with_IMDb();
		lp.enterInvalidCredentails(userName, pass);;
		AssertJUnit.assertTrue(lp.Verify_userName_errorMassage());
		AssertJUnit.assertEquals(lp.loginPageTitle(), properties.getProperty("LoginPageTitle"));
		sa.assertAll();
	}
	
	@Test(dataProvider="getDataExcelinvalidPass",dependsOnMethods = "testLoginWrongUN")
	public void testLoginWrongPass(String userName, String pass) {
		hp.clickSignIn();
		lop.clickSign_with_IMDb();
		lp.enterInvalidCredentails(userName, pass);
		AssertJUnit.assertTrue(lp.Verify_password_errorMassage());
		AssertJUnit.assertEquals(lp.loginPageTitle(), properties.getProperty("LoginPageTitle"));
		sa.assertAll();
	}

}
