package VahakHybrid.IMDBautomationWeb.qa.TestSuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import VahakHybrid.IMDBautomationWeb.qa.Base.TestBase;
import VahakHybrid.IMDBautomationWeb.qa.ExcelReader.TestDataReadFromExcelFile;
import VahakHybrid.IMDBautomationWeb.qa.PageObject.HomePagePO;
import VahakHybrid.IMDBautomationWeb.qa.PageObject.LastMoviePO;
import VahakHybrid.IMDBautomationWeb.qa.PageObject.LoginOptionPagePO;
import VahakHybrid.IMDBautomationWeb.qa.PageObject.LoginPagePO;
import VahakHybrid.IMDBautomationWeb.qa.PageObject.TopRatedMoviesPagePO;

public class LastMoviePageTest extends TestBase{
	LastMoviePageTest(){
		super();
	}
	
	HomePagePO hp;
	LoginOptionPagePO lop;
	LoginPagePO lp;
	SoftAssert sa;
	TopRatedMoviesPagePO tmp;
	LastMoviePO lmp;
	
	@BeforeMethod
	public void setup() {
		initialization();
		hp=new HomePagePO();
		lop=new LoginOptionPagePO();
		lp=new LoginPagePO();
		sa=new SoftAssert();
		tmp=new TopRatedMoviesPagePO();
		lmp=new LastMoviePO();
			
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
	public void testTitleLastMoviePage(String userName, String pass) {
		hp.clickSignIn();
		lop.clickSign_with_IMDb();
		lp.enterValidCredentails(userName, pass);
		hp.clickMenu();
		hp.Click_TopRatedMovieLink();
		tmp.sortByDropDownVisibleText(properties.getProperty("SortByVisibleText"));
		new WebDriverWait(driver,10).until(ExpectedConditions.textToBePresentInElement(tmp.lastMovieLink, properties.getProperty("lastMovieName")));
		
		tmp.click_lastMovieLink();
		System.out.println(lmp.getTitle());
		AssertJUnit.assertEquals(lmp.getTitle(), properties.getProperty("lastMoviePageTitle"));
		
	}
	
}
