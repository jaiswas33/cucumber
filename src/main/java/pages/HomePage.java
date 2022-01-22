package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class HomePage {
	
	@FindBy(xpath="//div[text()='Compose']")
	WebElement compose_button;
	
	@FindBy(xpath="//div[text()='Send']")
	WebElement send_button;
	
	@FindBy(xpath="//div[@aria-label='New Message']")
	WebElement new_email_template;
	
	@FindBy(xpath="//textarea[@name='to']")
	WebElement to_field;
	
	@FindBy(xpath="//input[@name='subjectbox']")
	WebElement subject_field;
	
	@FindBy(id=":2lv")
	WebElement message_body;
	
	@FindBy(xpath="//div[@aria-label='Main menu']//*[name()='svg']")
	WebElement main_menu_button;
	
	@FindBy(xpath="//a[@aria-label='Sent']")
	WebElement sent_button;
	
	@FindBy(xpath="//*[text()='Incubyte']")
	WebElement email_subject_text;
	
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void clickComposeButton() {
		compose_button.click();
	}
	
	public void isComposeButtonVisible() {
		Assert.assertTrue(compose_button.isDisplayed());
	}
	
	public void isEmailTemplateVisible() {
		Assert.assertTrue(new_email_template.isDisplayed());
	}

	public void clickOnRecipients() {
		to_field.click();
	}

	public void enterRecipients(String emailId) {
		to_field.sendKeys(emailId);
	}

	public void clickOnSubject() {
		subject_field.click();
	}

	public void enterSubject(String subject) {
		subject_field.sendKeys(subject);
	}

	public void clickOnEmailBody() {
		message_body.click();
	}

	public void enterEmailBody(String email_message) {
		message_body.sendKeys(email_message);
	}

	public void clickOnSendButton() {
		send_button.click();
	}

	public void clickOnMainMenuButton() {
		main_menu_button.click();
	}

	public void clickOnSentButton() {
		sent_button.click();
	}

	public void isEmailSubjectVisible() {
		Assert.assertTrue(email_subject_text.isDisplayed());
	}

}
