package locators;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class SettingsLocators extends BasePage{
	AndroidDriver driver;
	
	private By settingsbackBtn=By.xpath("(//android.widget.TextView)[1]");
	private By profileHeader=By.xpath("//android.widget.TextView[@text='...']/parent::android.view.ViewGroup/parent::android.view.ViewGroup");
	private By displayName=By.xpath("//android.widget.ImageView[1]/following-sibling::android.widget.TextView[1]");
	private By editNameBtn=By.xpath("//android.widget.TextView[@text='Edit']");
	private By editNameField=By.xpath("//android.widget.TextView[@text='...']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.EditText");
	private By changePin_btn=By.xpath("//android.widget.TextView[@text='Change PIN']");
	private By pin_1=By.xpath("//android.widget.TextView[@text='1']");
	private By pin_2=By.xpath("//android.widget.TextView[@text='2']");
	private By pin_3=By.xpath("//android.widget.TextView[@text='3']");
	private By pin_4=By.xpath("//android.widget.TextView[@text='4']");
	private By newpin_screen=By.xpath("//android.widget.TextView[contains(@text,'Select a new 4-Digit PIN')]");
	private By confirmpin_screen=By.xpath("//android.widget.TextView[contains(@text,'Confirm 4-Digit PIN')]");
	private By alert=By.id("android:id/message");
	private By ok_btn=By.xpath("//android.widget.Button[@text='OK']");
	private By changePassword_btn=By.xpath("//android.widget.TextView[@text='Change Password']");
	private By currentpassword_field=By.xpath("//android.widget.EditText[@text='Current Password']");
	private By newpassword_field=By.xpath("//android.widget.EditText[@text='New Password']");
	private By confirmpassword_field=By.xpath("//android.widget.EditText[@text='Confirm New Password']");
	private By save_btn=By.xpath("//android.widget.TextView[@text='Save']");
	private By twoStep_btn=By.xpath("//android.widget.TextView[@text='Two-Step Verification']");
	private By turnOff_btn=By.xpath("//android.widget.TextView[@text='Turn Off']");
	private By done_btn=By.xpath("//android.widget.TextView[@text='Done']");
	private By email_field=By.xpath("//android.widget.EditText[@text='Enter Email']");
	private By reverse_btn=By.xpath("//android.widget.TextView[@text='Reverse PIN Security']");
	private By toggle_btn=By.className("android.widget.Switch");
	private By yes_btn=By.id("android:id/button1");
	private By reverse_icon=By.xpath("//android.widget.TextView[@text='Reverse PIN Security']/parent::android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
	private By block_btn=By.xpath("//android.widget.TextView[@text=\"Blocked xID's\"]");
	private By blocked_ID=By.xpath("//android.widget.TextView[@text='...']");
	private By unblock_btn=By.xpath("//android.widget.TextView[@text='Unblock']");
	private By blockList_empty=By.xpath("//android.widget.TextView[@text=\"You have no Blocked xID's yet.\"]");
	private By recovery_btn=By.xpath("//android.widget.TextView[@text='Account Recovery']");
	private By questions_btn=By.xpath("//android.widget.TextView[@text='Security Questions']");
	private By password_field=By.xpath("//android.widget.EditText[@text='Your Password']");
	private By next_btn=By.xpath("//android.widget.TextView[@text='Next']");
	private By selectqs_btn=By.xpath("//android.widget.TextView[@text='Select your Question']");
	private By questions_modal=By.xpath("//android.widget.TextView[@text='Questions']");
	private By first_Q=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
	private By answer_field=By.xpath("//android.widget.EditText[@text='Answer for Question']");
	private By continue_btn=By.xpath("//android.widget.TextView[@text='Continue']");
	private By q2=By.xpath("//android.widget.TextView[@text='02']");
	private By second_Q=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]");
	private By q3=By.xpath("//android.widget.TextView[@text='03']");
	private By third_Q=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]");
	private By recovery_screen=By.xpath("//android.widget.TextView[@text='Account Recovery']");
	private By phrase_btn=By.xpath("//android.widget.TextView[@text='Security Phrase']");
	private By phrase_field=By.xpath("//android.widget.EditText[@text='Your Phrase']");
	private By signout_btn=By.xpath("//android.widget.TextView[@text='Sign out']");
	private By signoutOptions_btn=By.xpath("//android.widget.TextView[@text='Sign out']/parent::android.view.ViewGroup/parent::android.view.ViewGroup/android.view.View");
	private By switch_btn=By.xpath("//android.widget.TextView[@text='Switch Account']");
	private By addAccount_btn=By.xpath("//android.widget.TextView[@text='Add Another xID']");
	private By confirmSignout_btn=By.xpath("//android.widget.Button[@text='SIGN OUT']");
	private By register_btn=By.xpath("//android.widget.TextView[@text='Get Started']");
	private By permissionBtn=By.xpath("//android.widget.TextView[@text='Who Can Contact You']");
	private By byApprovalOnlyOption=By.xpath("//android.widget.TextView[@text='By Approval Only']");
	private By disablePinBtn=By.className("android.widget.Switch");
	
	
	public SettingsLocators(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public String verifyPin() {
		driver.findElement(changePin_btn).click();
		driver.findElement(pin_1).click();
		driver.findElement(pin_2).click();
		driver.findElement(pin_3).click();
		driver.findElement(pin_4).click();
		waitforElementPresent(newpin_screen);
		driver.findElement(pin_2).click();
		driver.findElement(pin_2).click();
		driver.findElement(pin_3).click();
		driver.findElement(pin_3).click();
		waitforElementPresent(confirmpin_screen);
		driver.findElement(pin_2).click();
		driver.findElement(pin_2).click();
		driver.findElement(pin_3).click();
		driver.findElement(pin_3).click();
		waitforElementPresent(alert);
		String alert_text=driver.findElement(alert).getText();
		driver.findElement(ok_btn).click();
		driver.findElement(changePin_btn).click();
		driver.findElement(pin_2).click();
		driver.findElement(pin_2).click();
		driver.findElement(pin_3).click();
		driver.findElement(pin_3).click();
		waitforElementPresent(newpin_screen);
		driver.findElement(pin_1).click();
		driver.findElement(pin_2).click();
		driver.findElement(pin_3).click();
		driver.findElement(pin_4).click();
		waitforElementPresent(confirmpin_screen);
		driver.findElement(pin_1).click();
		driver.findElement(pin_2).click();
		driver.findElement(pin_3).click();
		driver.findElement(pin_4).click();
		waitforElementPresent(alert);
		return alert_text;	
	}
	public String verifyPassword(String current_pass,String new_pass) {
		driver.findElement(changePassword_btn).click();
		driver.findElement(currentpassword_field).sendKeys(current_pass);
		driver.navigate().back();
		driver.findElement(newpassword_field).sendKeys(new_pass);
		driver.findElement(confirmpassword_field).sendKeys(new_pass);
		driver.findElement(save_btn).click();
		waitforElementPresent(alert);
		String alert_text=driver.findElement(alert).getText();
		driver.findElement(ok_btn).click();
		return alert_text;
	}
	public boolean reverseEnable() {
		driver.findElement(reverse_btn).click();
		driver.findElement(toggle_btn).click();
		driver.findElement(yes_btn).click();
		waitforElementPresent(reverse_icon);
		return true;
	}
	public boolean isBlocked() {
		scrollTo("Blocked xID's");
		driver.findElement(block_btn).click();
		return driver.findElement(blocked_ID).isDisplayed();
	}
	public boolean addQuestions(String password,String answer) {
		scrollTo("Account Recovery");
		driver.findElement(recovery_btn).click();
		driver.findElement(questions_btn).click();
		driver.findElement(password_field).sendKeys(password);
		driver.findElement(next_btn).click();
		driver.findElement(selectqs_btn).click();
		driver.findElement(first_Q).click();
		new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(questions_modal));
		driver.findElement(answer_field).sendKeys(answer);
		driver.findElement(continue_btn).click();
		waitforElementPresent(q2);
		driver.findElement(selectqs_btn).click();
		driver.findElement(second_Q).click();
		new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(questions_modal));
		driver.findElement(answer_field).sendKeys(answer);
		driver.findElement(continue_btn).click();
		waitforElementPresent(q3);
		driver.findElement(selectqs_btn).click();
		driver.findElement(third_Q).click();
		new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(questions_modal));
		driver.findElement(answer_field).sendKeys(answer);
		driver.findElement(continue_btn).click();
		waitforElementPresent(recovery_screen);
		return true;
	}
	public boolean addPhrase(String password,String phrase) {
		scrollTo("Account Recovery");
		driver.findElement(recovery_btn).click();
		driver.findElement(phrase_btn).click();
		driver.findElement(password_field).sendKeys(password);
		driver.findElement(next_btn).click();
		driver.findElement(phrase_field).sendKeys(phrase);
		driver.findElement(next_btn).click();
		waitforElementPresent(recovery_screen);
		return true;
	}
	public String setTwoStep(String mail) {
		driver.findElement(twoStep_btn).click();
		driver.findElement(email_field).sendKeys(mail);
		driver.findElement(next_btn).click();
		waitforElementPresent(alert);
		driver.findElement(ok_btn).click();
		waitforElementPresent(alert);
		return driver.findElement(alert).getText();	
	}
	public String turnOffTwoStep(){
		driver.findElement(twoStep_btn).click();
		
		return null;
	}
	
	public void disableTwoStep(String password) {
		driver.findElement(twoStep_btn).click();
		driver.findElement(turnOff_btn).click();
		driver.findElement(currentpassword_field).sendKeys(password);;
		driver.findElement(done_btn).click();
		waitforElementPresent(settingsScreen);
	}
	public boolean unblock() {
		scrollTo("Blocked xID's");
		driver.findElement(block_btn).click();
		waitforElementPresent(unblock_btn);
		driver.findElement(unblock_btn).click();
		driver.findElement(yes_btn).click();
		waitforElementPresent(blockList_empty);
		return true;
	}
	public boolean signout() {
		scrollTo("Sign out");
		driver.findElement(signout_btn).click();
		driver.findElement(signoutOptions_btn).click();
		driver.findElement(confirmSignout_btn).click();
		waitforElementPresent(register_btn);
		return true;
	}

	public RegisterLocators switchAccount() {
		scrollTo("Switch Account");
		driver.findElement(switch_btn).click();
		driver.findElement(addAccount_btn).click();
		waitforElementPresent(login_btn);
		return new RegisterLocators(driver);
	}
	
	public void setToByApprovalOnly() {
		scrollTo("Who Can Contact You");
		driver.findElement(permissionBtn).click();
		driver.findElement(byApprovalOnlyOption).click();
		driver.findElement(save_btn).click();
		waitforElementPresent(settingsScreen);
		driver.findElement(settingsbackBtn).click();
	}
	
	public boolean verifyProfileEdited(String name) {
		driver.findElement(profileHeader).click();
		System.out.println("Profile Image Clicked");
		driver.findElement(editNameBtn).click();
		driver.findElement(editNameField).sendKeys(name);
		String profileName=driver.findElement(editNameField).getText();
		driver.findElement(done_btn).click();
		waitforElementPresent(settingsScreen);
		return driver.findElement(displayName).getText().equals(profileName);
	}
	
	public boolean verifyInvalidName(String name) {
		driver.findElement(profileHeader).click();
		driver.findElement(editNameBtn).click();
		driver.findElement(editNameField).sendKeys(name);
		driver.findElement(done_btn).click();
		if(name.toLowerCase().contains("xpal")&&driver.findElements(settingsScreen).isEmpty()){
			return true;
			}
			return false;
}
	public void disablePin() {
		driver.findElement(disablePinBtn).click();
	}
}