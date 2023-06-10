package locators;

import org.openqa.selenium.By;

import basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class ResetPasswordLocators extends BasePage{
	
	private AndroidDriver driver;
	private By forgot_btn=By.xpath("//android.widget.TextView[@text='Forgot?']");
	private By resetpswd_btn=By.xpath("//android.widget.TextView[@text='Reset Password']");
	private By xID_field=By.className("android.widget.EditText");
	private By continue_btn=By.xpath("//android.widget.TextView[@text='Continue']");
	private By qs_btn=By.xpath("//android.widget.TextView[@text='Security Questions']");
	private By ans1=By.xpath("(//android.widget.EditText)[1]");
	private By ans2=By.xpath("(//android.widget.EditText)[2]");
	private By ans3=By.xpath("(//android.widget.EditText)[3]");
	private By pswd_screen=By.xpath("//android.widget.TextView[@text='Create New Password']");
	private By pswd_field=By.xpath("//android.widget.EditText[@text='Enter Password']");
	private By confirmpswd_field=By.xpath("//android.widget.EditText[@text='Confirm Password']");
	private By alert=By.id("android:id/message");
	private By ok_btn=By.id("android:id/button1");
	private By phrase_btn=By.xpath("//android.widget.TextView[@text='Security Phrase']");
	private By phrase_field=By.xpath("//android.widget.EditText[@text='Your Phrase']");
	private By next_btn=By.xpath("//android.widget.TextView[@text='Next']");
	private By email_btn=By.xpath("//android.widget.TextView[@text='Email']");
	private By email_field=By.xpath("//android.widget.EditText[@text='Enter Email']");
	private By done_btn=By.xpath("//android.widget.TextView[@text='Done']");
	
	
	public ResetPasswordLocators(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public LoginLocators resetbyQuestions(String number,String password,String answer) {
		driver.findElement(forgot_btn).click();
		driver.findElement(resetpswd_btn).click();
		driver.findElement(xID_field).sendKeys(number);
		driver.findElement(continue_btn).click();
		driver.findElement(qs_btn).click();
		driver.findElement(ans1).sendKeys(answer);
		driver.findElement(ans2).sendKeys(answer);
		driver.findElement(ans3).sendKeys(answer);
		driver.findElement(continue_btn).click();
		waitforElementPresent(pswd_screen);
		driver.findElement(pswd_field).sendKeys(password);
		driver.findElement(confirmpswd_field).sendKeys(password);
		driver.findElement(continue_btn).click();
		waitforElementPresent(alert);
		driver.findElement(ok_btn).click();
		return new LoginLocators(driver);
	}
	public LoginLocators resetbyPhrase(String number,String password,String phrase) {
		driver.findElement(forgot_btn).click();
		driver.findElement(resetpswd_btn).click();
		driver.findElement(xID_field).sendKeys(number);
		driver.findElement(continue_btn).click();
		driver.findElement(phrase_btn).click();
		driver.findElement(phrase_field).sendKeys(phrase);
		driver.findElement(next_btn).click();
		waitforElementPresent(pswd_screen);
		driver.findElement(pswd_field).sendKeys(password);
		driver.findElement(confirmpswd_field).sendKeys(password);
		driver.findElement(continue_btn).click();
		waitforElementPresent(alert);
		driver.findElement(ok_btn).click();
		return new LoginLocators(driver);
	}
	public LoginLocators resetbyEmail(String number,String password,String email) {
		driver.findElement(forgot_btn).click();
		driver.findElement(resetpswd_btn).click();
		driver.findElement(xID_field).sendKeys(number);
		driver.findElement(continue_btn).click();
		driver.findElement(email_btn).click();
		driver.findElement(email_field).sendKeys(email);
		driver.findElement(done_btn).click();
		waitforElementPresent(alert);
		driver.findElement(ok_btn).click();
		waitforElementPresent(pswd_screen);
		driver.findElement(pswd_field).sendKeys(password);
		driver.findElement(confirmpswd_field).sendKeys(password);
		driver.findElement(continue_btn).click();
		waitforElementPresent(alert);
		driver.findElement(ok_btn).click();
		return new LoginLocators(driver);
	}
}
