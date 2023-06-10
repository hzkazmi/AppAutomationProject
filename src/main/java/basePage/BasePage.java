package basePage;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import locators.LoginLocators;
import locators.RegisterLocators;

public class BasePage {
	private By register_btn=By.xpath("//android.widget.TextView[@text='Get Started']");
	public By login_btn=By.xpath("//android.widget.TextView[@text='Login']");
	private AndroidDriver driver;
	public By settingsScreen=By.xpath("//android.widget.TextView[@text='Settings']");
	public By chat_icon=By.xpath("(//android.widget.TextView)[1]");
	public By dialpad_icon=By.xpath("//android.widget.TextView[@text='New Message']/parent::android.view.ViewGroup/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup");
	public By searchId_field=By.xpath("//android.widget.TextView[@text='Enter xID']/following-sibling::android.widget.EditText");
	public By msg_icon=By.xpath("(//android.widget.TextView)[7]");
	public By confirmBtn=By.id("android:id/button1");
	private By pin1=By.xpath("//android.widget.TextView[@text='1']");
	private By pin2=By.xpath("//android.widget.TextView[@text='2']");
	private By pin3=By.xpath("//android.widget.TextView[@text='3']");
	private By pin4=By.xpath("//android.widget.TextView[@text='4']");
	public By pinScreen=By.xpath("//android.widget.TextView[@text='Verification PIN']");
	public By back_btn=By.xpath("(//android.widget.TextView)[1]");
	public By xID=By.xpath("//android.widget.TextView[matches(@text,'[\\d]{3}\\s[\\d]{3}\\s[\\d]{3}')]");
	public By contact_icon=By.xpath("(//android.widget.TextView)[3]");
	public By contacts_screen=By.xpath("//android.widget.TextView[@text='Contacts']");
	
	public BasePage(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public RegisterLocators gotoRegister() {
		driver.findElement(register_btn).click();
		return new RegisterLocators(driver);
	}
	public LoginLocators gotoLogin() {
		driver.findElement(login_btn).click();
		return new LoginLocators(driver);
	}
	public WebElement waitforElementPresent(By by) {
		return 	new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void scrollTo(String onText) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+onText+"\"));"));
	}
	public void enterPin() {
	driver.findElement(pin1).click();
	driver.findElement(pin2).click();
	driver.findElement(pin3).click();
	driver.findElement(pin4).click();
	new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(pinScreen));
	}
	
}

