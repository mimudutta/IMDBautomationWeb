package VahakHybrid.IMDBautomationWeb.qa.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import VahakHybrid.IMDBautomationWeb.qa.Base.TestBase;

public class LastMoviePO extends TestBase{
	
	public LastMoviePO() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//h4[text()='Release Date:']/parent::*/child::span/a")
	public WebElement releaseDate_SeeMoreLink;

	public LastMovieReleaseDetailPO click_releaseDate_SeeMore() {
		releaseDate_SeeMoreLink.click();
		return new LastMovieReleaseDetailPO();
	}
	
	public String getTitle() {
		new WebDriverWait(driver, 8).until(ExpectedConditions.visibilityOf(releaseDate_SeeMoreLink));
		return driver.getTitle();
		
	}

}
