package VahakHybrid.IMDBautomationWeb.qa.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import VahakHybrid.IMDBautomationWeb.qa.Base.TestBase;

public class TopRatedMoviesPagePO extends TestBase{
	
	public TopRatedMoviesPagePO(){
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait;
	
	@FindBy(how=How.XPATH, using="//h1[@class=\"header\"and text()='Top Rated Movies']")
	public WebElement TopRatedMovies;
	
	@FindBy(how=How.NAME, using="sort")
	public WebElement sortByDropDown;
	
	@FindBy(how=How.XPATH, using="//tbody[@class=\"lister-list\"]/tr[last()]/td[@class=\"titleColumn\"]/a")
	public WebElement lastMovieLink;

	
	public String getTitle_TopRatedMoviePage() {
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(TopRatedMovies));
			return driver.getTitle();
	}
	
	public void sortByDropDownVisibleText(String visibleText) {
		Select select=new Select(sortByDropDown);
		select.selectByVisibleText(visibleText);
	}
	
	public LastMoviePO click_lastMovieLink() {
		new WebDriverWait(driver,10).until(ExpectedConditions.textToBePresentInElement(lastMovieLink, properties.getProperty("lastMovieName")));
		lastMovieLink.click();
		return new LastMoviePO();
	}
	
	
}
