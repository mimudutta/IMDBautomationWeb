package VahakHybrid.IMDBautomationWeb.qa.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import VahakHybrid.IMDBautomationWeb.qa.Base.TestBase;

public class LastMovieReleaseDetailPO extends TestBase{
	
	public LastMovieReleaseDetailPO(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//h4[normalize-space(text()='Release Dates')]")
	public WebElement ReleaseDatesHeading;
	
	@FindBy(how=How.XPATH, using="//tbody/tr")
	public List<WebElement>  releaseDate_allRows;

	public void printAllReleasedetails() {
		for (WebElement row : releaseDate_allRows) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 
		    for (WebElement cell : cells) {         
		    	System.out.println(cell.getText());
		    }
		}
	}
	
	public String getTitle() {
		new WebDriverWait(driver, 8).until(ExpectedConditions.visibilityOf(ReleaseDatesHeading));
		return driver.getTitle();
	}
}
