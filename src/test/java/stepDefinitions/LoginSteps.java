package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
	//io.cucumber.testng.UndefinedStepException: The step 'I am on the login page' and 3 other step(s) are undefined.
	//You can implement these steps using the snippet(s) below:

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		// Write code here that turns the phrase above into concrete actions
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//throw new io.cucumber.java.PendingException();
	}
	@When("I enter valid credentials")
	public void i_enter_valid_credentials() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(1000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(1000);
		//throw new io.cucumber.java.PendingException();
	}
	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.className("orangehrm-login-button")).click();
		//throw new io.cucumber.java.PendingException();
	}

	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(5000);
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(actualURL, expectedURL);
		//throw new io.cucumber.java.PendingException();


	}
	@After
	public void close() {
		driver.quit();
	}


}
