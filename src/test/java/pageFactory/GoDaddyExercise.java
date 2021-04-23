package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoDaddyExercise {
	
	WebDriver driver;
	
	@FindBy(xpath="//body/div[1]/div[1]/section[1]/div[1]/form[1]/div[2]/span[1]/input[1]") WebElement txt_SearchBox;
	@FindBy(xpath="//body/div[1]/div[1]/section[1]/div[1]/form[1]/div[2]/span[2]/button[1]") WebElement btn_Search;
	
	
	public GoDaddyExercise(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchAnything(String search) {
		String searchString = search;
		txt_SearchBox.clear();
		txt_SearchBox.sendKeys(searchString);
		btn_Search.click();
	}
	
	
	

}
