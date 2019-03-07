package stepdef;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginPageDef {
	private WebDriver driver;

	@Before
	public WebDriver i_will_start_Browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("_____....!!!....Chrome Browser is starting....!!!....____");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		
		return driver;

	}

	@After
	public void i_will_close_the_browser_after_every_Scenario() throws Throwable {
		System.out.println("_____....!!!....Chrome Browser is Closing....!!!....____");
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}

	@Given("^I navigate to OrangeHRM live page$")
	public void i_navigate_to_OrangeHRM_live_page() throws Throwable {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(500);

	}

	@Given("^I verify the page$")
	public void i_verify_the_page() throws Throwable {
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		assertEquals(actualTitle, expectedTitle);
		System.out.println(
				"Actual Web Title is:   " + actualTitle + "    " + "Expected Web Title is:    " + expectedTitle);
		Thread.sleep(500);
	}

	@Given("^I enter username \"([^\"]*)\"$")
	public void i_enter_username(String arg1) throws Throwable {
		driver.findElement(By.id("txtUsername")).sendKeys(arg1);
		System.out.println("UserName: is  " + arg1);
	}

	@Given("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String arg1) throws Throwable {
		driver.findElement(By.id("txtPassword")).sendKeys(arg1);
		System.out.println("Password is:  " + arg1);
	}

	@Given("^I click login button$")
	public void i_click_login_button() throws Throwable {
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
	}

	@Then("^I validate and see the FailDashboard page$")
	public void i_validate_and_see_the_FailDashboard_page() throws Throwable {
		String actualText = driver.findElement(By.id("spanMessage")).getText();
		String expectedText = "Invalid credentials";
		assertEquals(actualText, expectedText);
		System.out.println("Actual Text is:  " + actualText + "    " + "Expected Text is:   " + expectedText);
		Thread.sleep(800);
	}

	@Then("^I validate and see the successDashboard page$")
	public void i_validate_and_see_the_successDashboard_page() throws Throwable {
		String actualText = driver.findElement(By.cssSelector("#menu_dashboard_index b")).getText();
		String expectedText = "Dashboard";
		assertEquals(actualText, expectedText);
		System.out.println("Actual Text is:   " + actualText + "    " + "Expected Text is:   " + expectedText);
		Thread.sleep(800);

	}

	@Given("^I enter \"([^\"]*)\" on username field$")
	public void i_enter_on_username_field(String arg1) throws Throwable {
		driver.findElement(By.id("txtUsername")).sendKeys(arg1);
		System.out.println("Username is:  " + arg1);
	}

	@Given("^I enter \"([^\"]*)\" on password field$")
	public void i_enter_on_password_field(String arg1) throws Throwable {
		driver.findElement(By.id("txtPassword")).sendKeys(arg1);
		System.out.println("Password is:  " + arg1);
	}

}
