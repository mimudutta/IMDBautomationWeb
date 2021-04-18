package VahakHybrid.IMDBautomationWeb.qa.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import VahakHybrid.IMDBautomationWeb.qa.Base.TestBase;

public class LoginPagePO extends TestBase{

	public LoginPagePO(){
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how=How.ID, using="ap_email")
	@CacheLookup
	public WebElement email;
	
	@FindBy(how=How.ID, using="ap_password")
	@CacheLookup
	public WebElement passCode;
	
	@FindBy(how=How.ID, using="signInSubmit")
	@CacheLookup
	public WebElement Signup_button;
	
	@FindBy(how=How.XPATH, using="//h4[text()='There was a problem']")
	@CacheLookup
	public WebElement UN_errorMassage;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'please re-enter your password')]")
	public WebElement pass_errorMassage;
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePagePO enterValidCredentails(String un, String pass) {
		System.out.println("Username="+un+" Password="+pass);
		email.sendKeys(un);
		passCode.sendKeys(pass);
		Signup_button.click();
		return new HomePagePO();
	}
	
	public void enterInvalidCredentails(String un, String pass) {
		System.out.println("Username="+un+" Password="+pass);
		email.sendKeys(un);
		passCode.sendKeys(pass);
		Signup_button.click();
	}
	
	public boolean Verify_userName_errorMassage() {
		if(pass_errorMassage.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	public boolean Verify_password_errorMassage() {
		if(pass_errorMassage.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}	
	}
	
}
