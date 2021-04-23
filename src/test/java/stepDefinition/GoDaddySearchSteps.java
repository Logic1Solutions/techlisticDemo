package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pageFactory.GoDaddyExercise;

public class GoDaddySearchSteps {
	
	WebDriver driver = null;
	GoDaddyExercise goDaddy;
	String searchDomainName = "Logic 1 Solutions";
	
	
	@Given("^user is on the goDaddy page$")
	public void user_is_on_the_go_daddy_page() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/webdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,  TimeUnit.SECONDS);
		driver.get("http://www.godaddy.com");
		
	    
	}

	@When("^user enters search string$")
	public void user_enters_search_string() {
	    goDaddy = new GoDaddyExercise(driver);
	    goDaddy.searchAnything(searchDomainName);
		
	}

	@Then("^search results are returned$")
	public void search_results_are_returned() {
		Assert.assertEquals(true, goDaddy.addToCart(driver));
		String webRecommend = goDaddy.availableDomainName(driver);
	    System.out.println("Domain is available " + webRecommend);
	    
	    driver.quit();
	    };
	    
		
	}

	
