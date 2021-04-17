package VahakHybrid.IMDBautomationWeb.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import VahakHybrid.IMDBautomationWeb.qa.Utility.UtilLoadTime;
import VahakHybrid.IMDBautomationWeb.qa.Utility.WebEventHandler;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	public static FileInputStream fis;
	public static EventFiringWebDriver e_driver;
	public static WebEventHandler eventListener;
	
	
	public TestBase() {
		
		try {
			properties=new Properties();
			fis=new FileInputStream(System.getProperty("user.dir")+
										"/src/main/resource/config.properties");
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
	        if (fis != null) {
	            try {
	                fis.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
		}
}


	public static void initialization() {
		String browserName=properties.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			driver= new ChromeDriver();		
		}
		
		else if(browserName.equalsIgnoreCase("Chromeheadless")) {
			WebDriverManager.chromedriver().setup(); 
			ChromeOptions options=new ChromeOptions();
			options.addArguments("window-size=1400,800");
			options.addArguments("headless");
			driver= new ChromeDriver(options);		
		}
		
		
		e_driver=new EventFiringWebDriver(driver);
		WebEventHandler eventListener = new WebEventHandler(); 
		e_driver.register(eventListener);
		driver=e_driver;
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilLoadTime.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilLoadTime.IMPLICITE_WAIT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("URL"));	
	}
	
		

}













