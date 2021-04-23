package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageFactory.TechlisticHomePage;

public class FormPractice {
	
	WebDriver driver = null;
	TechlisticHomePage homepage;
	
	@Given("^user is on the web page$")
	public void user_is_on_the_web_page() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/webdriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().to("http://www.techlistic.com/p/selenium-practice-form.html");
		driver.manage().window().maximize();
		
		System.out.println("User is currently in Techlistic's "+ driver.getTitle()+"("+driver.getCurrentUrl()+")");
		
		WebElement element = driver.findElement(By.xpath("//b[contains(text(),'AUTOMATE ME')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);

		
	}

	@When("^user populates the (.*) and (.*) fields$")
	public void user_populates_the_required_fields(String firstname, String lastname) {
		homepage = new TechlisticHomePage(driver);
		
		homepage.textInput(firstname, lastname);
		
	}

	@And("^selects the (.*) and (.*)$")
	public void selects_the_sex_and_years(String sex, int years) throws InterruptedException {
		homepage.radioSexMale(sex);
		homepage.radioYearsExperience(years);
		Thread.sleep(2000);
		
	
		
	}
	
	@And("user click the submit button")
	public void user_click_the_submit_button() {
	}

	@Then("message is returned to the user")
	public void message_is_returned_to_the_user() {
		driver.close();
		driver.quit();
	}
	

}
