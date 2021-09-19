package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	public WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By cartLink= By.className("shopping_cart_link");
	private By addBackpack= By.id("add-to-cart-sauce-labs-backpack");
	private By addfleecejacket= By.id("add-to-cart-sauce-labs-fleece-jacket");
	private By checkout= By.id("checkout");


	
	public WebElement getCartLink() {
		return driver.findElement(cartLink);
	}

	public WebElement addBackPack() {
		return driver.findElement(addBackpack);
	}
	
	public WebElement addFleeceJacket() {
		return driver.findElement(addfleecejacket);
	}
	
	public WebElement getCheckout() {
		return driver.findElement(checkout);
	}
	
	public CheckoutAndConfirmPage CCPage() {
		CheckoutAndConfirmPage ccp=new CheckoutAndConfirmPage(driver);
		return ccp;
	}
	
}
