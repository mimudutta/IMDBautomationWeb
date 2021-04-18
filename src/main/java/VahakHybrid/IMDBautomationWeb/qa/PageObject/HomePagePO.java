package VahakHybrid.IMDBautomationWeb.qa.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import VahakHybrid.IMDBautomationWeb.qa.Base.TestBase;

public class HomePagePO extends TestBase{
	
	public HomePagePO(){
		PageFactory.initElements(driver, this);
	}
	WebDriverWait wait;
	
	@FindBy(how=How.XPATH, using="//div[text()='Sign In']")
	public WebElement Signinlink;
	
	@FindBy(how=How.XPATH, using="//div[text()='Menu']")
	public WebElement Menu;
	
	@FindBy(how=How.XPATH, using="//span[text()='Movies']/ancestor::label/following-sibling::div/div/ul/a/span[text()='Top Rated Movies']")
	public WebElement Top_Rated_Movies_link;
	
	
	public boolean checkUserAfterLogin(String userEmail) {
		System.out.println("User email/name:"+userEmail);
		String Homepage_User="//span[text()='"+userEmail+"']";
		WebElement Homepage_User_xpath=driver.findElement(By.xpath(Homepage_User));
		
		if(Homepage_User_xpath.getText().equals(userEmail)) {
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
	
	
	public boolean verify_TopRatedMovieLink_exist() {
		wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(Top_Rated_Movies_link));
		if (Top_Rated_Movies_link.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public TopRatedMoviesPagePO Click_TopRatedMovieLink() {
		wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(Top_Rated_Movies_link));
		Actions action =new Actions(driver);
		action.moveToElement(Top_Rated_Movies_link).click().build().perform();	
		return new TopRatedMoviesPagePO();
	}

}
