package stepsdefinition;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.HomePage;
import pages.LoginPage;

public class checkComposeFunctionSteps {
	
	WebDriver driver = null;
	HomePage home = new HomePage(driver);
	
	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("^navigate to base url$")
	public void navigate_to_base_url() throws Throwable {
		String url = System.getenv("URL");
		driver.get(url);
	}

	@Given("^perform login$")
	public void perform_login() throws Throwable {
		LoginPage login = new LoginPage(driver);
		String user = System.getenv("USERNAME");
		login.enterUsername(user);
		login.clickNextButton();
		String secret = System.getenv("SECRET");
		login.enterPassword(secret);
		login.clickNextButton();	
	}
	
	@Then("^verify compose button exist$")
	public void verify_compose_button_exist() throws Throwable {
		home.isComposeButtonVisible();
	}
	

	@Given("^click on compose button$")
	public void click_on_compose_button() throws Throwable {
		home.clickComposeButton();
	}

	@Then("^new email body should display$")
	public void new_email_body_should_display() throws Throwable {
		home.isEmailTemplateVisible();
	}

	@Given("^enter recipients \"([^\"]*)\"$")
	public void enter_receipents(String emailId) throws Throwable {
		home.clickOnRecipients();
		home.enterRecipients(emailId);
	}

	@Given("^enter subject \"([^\"]*)\"$")
	public void enter_subject(String subject) throws Throwable {
		home.clickOnSubject();
		home.enterSubject(subject);
	}

	@Given("^enter email body \"([^\"]*)\"$")
	public void enter_email_body(String email_message) throws Throwable {
		home.clickOnEmailBody();
		home.enterEmailBody(email_message);
	}

	@Given("^click on send button$")
	public void click_on_send_button() throws Throwable {
		home.clickOnSendButton();
	}

	@Given("^click on main menu button$")
	public void click_on_main_menu_button() throws Throwable {
		home.clickOnMainMenuButton();
	}

	@Then("^click sent button$")
	public void click_sent_button() throws Throwable {
		home.clickOnSentButton();
	}

	@Then("^verify latest email subject$")
	public void verify_latest_email_subject() throws Throwable {
		home.isEmailSubjectVisible();
	}
	
	@After
	public void cleanUp() {    
		driver.close();    
	}  

}
