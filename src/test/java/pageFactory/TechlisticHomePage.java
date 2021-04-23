package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechlisticHomePage {
	WebDriver driver;

	@FindBy(name="firstname") WebElement txt_FirstName;
	@FindBy(name="lastname") WebElement txt_LastName;
	@FindBy(xpath = "//input[@id='sex-0'][@value='Male']") WebElement rad_Male;
	@FindBy(xpath = "//input[@id='sex-1'][@value='Female']") WebElement rad_Female;
	
	@FindBy(xpath = "//input[@id='exp-0'][@name='exp']") WebElement rad_Exp0;
	@FindBy(xpath = "//input[@id='exp-1'][@name='exp']") WebElement rad_Exp1;
	@FindBy(xpath = "//input[@id='exp-2'][@name='exp']") WebElement rad_Exp2;
	@FindBy(xpath = "//input[@id='exp-3'][@name='exp']") WebElement rad_Exp3;
	@FindBy(xpath = "//input[@id='exp-4'][@name='exp']") WebElement rad_Exp4;
	@FindBy(xpath = "//input[@id='exp-5'][@name='exp']") WebElement rad_Exp5;
	@FindBy(xpath = "//input[@id='exp-6'][@name='exp']") WebElement rad_Exp6;
	
	@FindBy(xpath = "//input[@name='profession']") List<WebElement> chk_Profession;

	
	@FindBy(css = "#tool-0") WebElement chk_Uft;
	@FindBy(css = "#tool-1") WebElement chk_Protractor;
	@FindBy(css = "#tool-2") WebElement chk_Selenium;
	
	
	public TechlisticHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void textInput(String firstname, String lastname){
		txt_FirstName.sendKeys(firstname);
		txt_LastName.sendKeys(lastname);
	}
	
	public void radioSexMale(String sex) {
		String selectedSex = sex;
		switch (selectedSex){
			case "M":
				rad_Male.click();	
				break;
			case "F":
				rad_Female.click();
				break;
			default: System.out.println("None selected");
		}	
	}
	
	public void radioYearsExperience (int years) {
		int yearsExperience = years;
		switch (yearsExperience) {
		case 1:
			rad_Exp0.click();
			break;
		case 2:
			rad_Exp1.click();
			break;
		case 3:
			rad_Exp2.click();
			break;
		case 4:
			rad_Exp3.click();
			break;
		case 5:
			rad_Exp4.click();
			break;
		case 6:
			rad_Exp5.click();
			break;
		case 7:
			rad_Exp6.click();
			break;
		default:  System.out.println("None selected");
		}
	}
	
	public void selectProfession(String profession) {
		String selectedProfession = profession;
		
		System.out.println("Number of options: "+ chk_Profession.size());
		
		for (int i=0; i<=chk_Profession.size(); i++) {
			if (chk_Profession.get(i).getAttribute("value").equalsIgnoreCase(selectedProfession)){
				chk_Profession.get(i).click();
			}
		}
			
	}
}
