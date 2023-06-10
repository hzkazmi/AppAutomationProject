package locators;


import org.openqa.selenium.By;


import basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;


public class RegisterLocators extends BasePage{
	
	private By username_field=By.className("android.widget.EditText");
	private By login_btn=By.xpath("//android.widget.TextView[@text='Login']");
	private By next_btn=By.xpath("//android.widget.TextView[@text='Next']");
	private By xIDScreen=By.xpath("//android.widget.TextView[@text='Welcome to Your xID!']");
	private By new_password=By.xpath("//android.widget.EditText[@text='Enter Password']");
	private By confirm_password=By.xpath("//android.widget.EditText[@text='Confirm Password']");
	private By privacy_checkbox=By.xpath("//android.widget.TextView[@text='']");
	private By continue_btn=By.xpath("//android.widget.TextView[@text='Continue']");
	private By tutorial=By.xpath("//android.widget.TextView[@text='TAP HERE TO COMPOSE MESSAGE']");
	private By confirmpin_screen=By.xpath("//android.widget.TextView[@text='Confirm 4-Digit PIN']");
	private AndroidDriver driver;
	
	public RegisterLocators(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public boolean verifyRegister(String username,String password) {
		
		driver.findElement(username_field).sendKeys(username);
		driver.navigate().back();
		driver.findElement(next_btn).click();
		waitforElementPresent(next_btn);
		driver.findElement(next_btn).click();
		driver.findElement(new_password).sendKeys(password);
		driver.findElement(confirm_password).sendKeys(password);
		driver.findElement(privacy_checkbox).click();
		driver.findElement(continue_btn).click();
		enterPin();
		waitforElementPresent(confirmpin_screen);
		enterPin();
		waitforElementPresent(tutorial);
		return true;
}
	public boolean verifyInvalidRegister(String username) {
		driver.findElement(username_field).sendKeys(username);
		driver.navigate().back();
		driver.findElement(next_btn).click();
		if(username.toLowerCase().contains("xpal")&&driver.findElements(xIDScreen).isEmpty()){
		return true;
		}
		return false;
	}
	public LoginLocators verifyLoginScreen(String xID,String password) {
		driver.findElement(login_btn).click();
		return new LoginLocators(driver);
	}
}