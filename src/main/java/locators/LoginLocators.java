package locators;


import org.openqa.selenium.By;

import basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class LoginLocators extends BasePage{
	private AndroidDriver driver;
	private By xID_field=By.xpath("//android.widget.EditText[@text='xID']");
	private By password_field=By.xpath("//android.widget.EditText[@text='Password']");
	private By next_btn=By.xpath("//android.widget.TextView[@text='Next']");
	
	
	
	
	
	public LoginLocators(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public ContactLocators verifyChatPage(String xID,String password) {
	driver.findElement(xID_field).sendKeys(xID);
	driver.findElement(password_field).sendKeys(password);
	driver.findElement(next_btn).click();
	waitforElementPresent(pinScreen);
	enterPin();

	return new ContactLocators(driver);
	}
	
}
