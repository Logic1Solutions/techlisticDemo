package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoDaddyExercise {
	
	WebDriver driver;
	
	@FindBy(xpath="//body/div[1]/div[1]/section[1]/div[1]/form[1]/div[2]/span[1]/input[1]") WebElement txt_SearchBox;
	@FindBy(xpath="//body/div[1]/div[1]/section[1]/div[1]/form[1]/div[2]/span[2]/button[1]") WebElement btn_Search;
	
	@FindBy(xpath = "//div[@id='exact-match']/div/div/div/div/div/div[@data-cy='celebrate-add-to-cart-button-container']/div/div/div[2]/button") WebElement btn_AddToCart;
	@FindBy(xpath = "//body/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/span[1]") WebElement txt_AvailableDomainName;
	
	public GoDaddyExercise(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchAnything(String search) {
		String searchString = search;
		String searchResults = driver.getTitle();
		System.out.println("Search Page Title: "+ searchResults);
		txt_SearchBox.clear();
		txt_SearchBox.sendKeys(searchString);
		btn_Search.click();
	}
	
	public boolean addToCart(WebDriver driver) {
		boolean btnEnabled = btn_AddToCart.isDisplayed();
		return btnEnabled;
	}
	
	public String availableDomainName(WebDriver driver) {
		String domainName = txt_AvailableDomainName.getText();
		return domainName;
	}


}





