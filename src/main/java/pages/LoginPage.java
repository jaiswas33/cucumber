package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//input[@type='email']")
	WebElement username_field;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password_field;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement next_button;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	public void enterUsername(String username) {
		username_field.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		password_field.sendKeys(password);
	}
	
	public void clickNextButton() {
		next_button.click();
	}
	
}
