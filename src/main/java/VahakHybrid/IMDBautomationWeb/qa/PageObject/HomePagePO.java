package VahakHybrid.IMDBautomationWeb.qa.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import VahakHybrid.IMDBautomationWeb.qa.Base.TestBase;

public class HomePagePO extends TestBase{
	
	public HomePagePO(){
		PageFactory.initElements(driver, this);
	}
	
	String User;
	
	@FindBy(how=How.XPATH, using="//div[text()='Sign In’]")
	public WebElement Signinlink;
	
	@FindBy(how=How.XPATH, using="//div[text()='Menu’]")
	public WebElement Menu;
	
	@FindBy(how=How.XPATH, using="//span[text()='\"+User+\"’]")
	public WebElement Homepage_User_check;
	
	@FindBy(how=How.XPATH, using="//span[text()='Movies']/ancestor::label/following-sibling::div/div/ul/a/span[text()='Top Rated Movies’]")
	public WebElement Top_Rated_Movies_link;
	
	
	public boolean checkUserAfterLogin(String userEmail) {
		User=userEmail;
		if(Homepage_User_check.getText()==userEmail) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickMenu() {
		if (Menu.isDisplayed()) {
			Menu.click();
		}
	}
	
	public void clickSignIn() {
		if (Signinlink.isDisplayed()) {
			Signinlink.click();
		}
	}
	
	public void Click_TopRatedMovieLink() {
		if (Top_Rated_Movies_link.isDisplayed()) {
			Top_Rated_Movies_link.click();
		}
	}

}
