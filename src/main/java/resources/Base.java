package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initialize() throws IOException {
		
		prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
		prop.load(fis);
		String browsername= prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver");
		    driver= new ChromeDriver();
		}
		
		if(browsername.equals("firefox")) {
			System.setProperty("webdriver.geckodriver.driver", System.getProperty("user.dir")+"/driver/geckodriver");
			driver= new FirefoxDriver();
		}
		return driver;
		
		
	}
	

}
