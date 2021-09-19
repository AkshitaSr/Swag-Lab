package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import pageObject.CheckoutAndConfirmPage;
import pageObject.LoginPage;
import pageObject.ProductPage;
import resources.Base;

public class ProductPageTest extends Base{
	
  public static final Logger log= LogManager.getLogger(ProductPageTest.class.getName());
  public WebDriver driver;
  
  @BeforeTest
  public void initializeDriver() throws IOException {
	  driver=initialize();
		 log.info("Driver is initialized by ProductPage");
		 
		 driver.get(prop.getProperty("url"));
		 log.info("Landing on Product Page");
  }
 
  @Test
  public void productTest() {
	  
	  LoginPage lp= new LoginPage(driver);
		lp.getUsername().sendKeys(prop.getProperty("username"));
		log.info("Entering Username");
		lp.getPassword().sendKeys(prop.getProperty("password"));
		log.info("Entering Password");
		lp.getLogin().click();
		log.info("Click on Login Button- Landing on Product Page");
	  ProductPage  pp= new ProductPage(driver);
	  pp.addBackPack().click();
	  log.info("Added SauceLab BackPack in cart");
	  pp.addFleeceJacket().click();
	  log.info("Added Sauce Lab Fleece Jacket in cart");
	  pp.getCartLink().click();
	  log.info("Clicked  on CartLink");
	  pp.getCheckout().click();
	  log.info("Clicked on Checkout button");
	  
	  log.info("Adding Details in CHECKOUT: YOUR INFORMATION page");
	  CheckoutAndConfirmPage cac=pp.CCPage();
	  cac.getfirstName().sendKeys("Abcd");
	  log.info("Entered FirstName");
	  cac.addLastName().sendKeys("efgh");
	  log.info("Entered LastName");
	  cac.addPostalCode().sendKeys("12345");
	  log.info("Entered Postal Code");
	  cac.getcontinue().click();
	  log.info("Clicked on continue button ");
	  
	  cac.getFinish().click();
	  log.info("Clicked on Finish button");
	  
	  String message= cac.getMessage().getText();
	  
	  if(message.contains("THANK YOU FOR YOUR ORDER" )) {
		  log.info("Test Passed :- Order is successful placed");
	  }
	  
	  else {
		  log.info("Test Failed :- Order is not placed");
	  }
  }

  
  @AfterTest 
  public void teardown() {
	  driver.close(); 
	  }
}
