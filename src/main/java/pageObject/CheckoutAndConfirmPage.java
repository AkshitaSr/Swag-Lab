package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutAndConfirmPage {
	public WebDriver driver;

	public CheckoutAndConfirmPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By firstName= By.name("firstName");
	private By LastName= By.name("lastName");
	private By postalcode= By.id("postal-code");
	private By continu= By.id("continue");
	private By finish= By.id("finish");
	private By message= By.className("complete-header");
	
	public WebElement getfirstName() {
		return driver.findElement(firstName);
	}

	public WebElement addLastName() {
		return driver.findElement(LastName);
	}
	
	public WebElement addPostalCode() {
		return driver.findElement(postalcode);
	}
	
	public WebElement getcontinue() {
		return driver.findElement(continu);
	}
	
	public WebElement getFinish() {
		return driver.findElement(finish);
	}
	
	public WebElement getMessage() {
		return driver.findElement(message);
	}
	
}
