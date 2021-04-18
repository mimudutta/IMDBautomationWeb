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
import VahakHybrid.IMDBautomationWeb.qa.PageObject.TopRatedMoviesPagePO;

public class TopRatedMoviesPageTest extends TestBase{
	
	TopRatedMoviesPageTest(){
		super();
	}
	
	HomePagePO hp;
	LoginOptionPagePO lop;
	LoginPagePO lp;
	SoftAssert sa;
	TopRatedMoviesPagePO tmp;
	
	@BeforeMethod
	public void setup() {
		initialization();
		hp=new HomePagePO();
		lop=new LoginOptionPagePO();
		lp=new LoginPagePO();
		sa=new SoftAssert();
		tmp=new TopRatedMoviesPagePO();
			
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
	
	@Test(dataProvider="getDataExcelvalidCredential")
	public void testTopRatedMoviesLink_Exist(String userName, String pass) {
		hp.clickSignIn();
		lop.clickSign_with_IMDb();
		lp.enterValidCredentails(userName, pass);
		hp.clickMenu();
		AssertJUnit.assertTrue(hp.verify_TopRatedMovieLink_exist());
	}
	
	@Test(dataProvider="getDataExcelvalidCredential")
	public void testTopRatedMoviesPage_Exist(String userName, String pass) {
		hp.clickSignIn();
		lop.clickSign_with_IMDb();
		lp.enterValidCredentails(userName, pass);
		hp.clickMenu();
		hp.Click_TopRatedMovieLink();
		AssertJUnit.assertEquals(tmp.getTitle_TopRatedMoviePage(), properties.getProperty("TopRatedMoviesPageTitle"));
	}
	
	
}
