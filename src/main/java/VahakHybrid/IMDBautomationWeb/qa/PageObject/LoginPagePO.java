package VahakHybrid.IMDBautomationWeb.qa.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import VahakHybrid.IMDBautomationWeb.qa.Base.TestBase;

public class LoginPagePO extends TestBase{

	public LoginPagePO(){
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how=How.ID, using="ap_email")
	public WebElement email;
	
	@FindBy(how=How.ID, using="ap_password")
	public WebElement passCode;
	
	@FindBy(how=How.ID, using="signInSubmit")
	public WebElement Signup_button;
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePagePO enterCredentails(String un, String pass) {
		System.out.println("Username="+un+" Password="+pass);
		email.sendKeys(un);
		passCode.sendKeys(pass);
		Signup_button.click();
		
		return new HomePagePO();
	}
	
}
