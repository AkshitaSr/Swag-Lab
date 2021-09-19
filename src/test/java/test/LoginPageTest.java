package test;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import pageObject.LoginPage;

import org.testng.annotations.*;

import resources.Base;

public class LoginPageTest extends Base {
	public static final Logger log= LogManager.getLogger(LoginPageTest.class.getName());
	public WebDriver driver;

	
	@BeforeTest
	public void initializeDriver() throws IOException {
	 driver=initialize();
	 log.info("Driver is initialized by LoginPage");
	 
	
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data= new Object[4][2];
		
		//Valid Username And Paasword
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		
		//Valid Username And Invalid Paasword
		data[1][0]="standard_user";
		data[1][1]="aaa111";
		
		//InValid Username And Valid Paasword
		data[2][0]="standard";
		data[2][1]="secret_sauce";
		
		//InValid Username And InValid Paasword
		data[3][0]="standard111";
		data[3][1]="secret222";
		
		
		return data;
	}
	

	@Test(dataProvider="getData")
	public void loginTest(String username, String password) {
		 driver.get(prop.getProperty("url"));
		 log.info("Landing on Login Page");
		LoginPage lp= new LoginPage(driver);
		lp.getUsername().sendKeys(username);
		 log.info("Entered username : " + username);

		lp.getPassword().sendKeys(password);
		 log.info("Entered password : "+ password);
		lp.getLogin().click();
		 log.info("Clicked on Login Button");
		
		String newUrl= driver.getCurrentUrl();
		
		
		if (newUrl.contains("inventory")) {
			log.info("Successfully Login- username:  "+username+ " and password: "+password);

			
		}
		
		else {
			log.info("Login Failed- username:  "+username+ " and password: "+password);
		}
		
	}
	
	
	  @AfterTest public void teardown() {
		  driver.close(); 
		  }
	 
}
