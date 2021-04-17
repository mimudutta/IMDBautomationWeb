package VahakHybrid.IMDBautomationWeb.qa.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import VahakHybrid.IMDBautomationWeb.qa.Base.TestBase;

public class LoginOptionPagePO extends TestBase{
	
	public LoginOptionPagePO(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//h1[text()='Sign in']/parent::div/div/a")
	public WebElement Sign_with_IMDb;
	
	public LoginPagePO clickSign_with_IMDb() {
		if (Sign_with_IMDb.isDisplayed()) {
			Sign_with_IMDb.click();
		}
		return new LoginPagePO();
	}
}
