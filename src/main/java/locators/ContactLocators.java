package locators;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;


public class ContactLocators extends BasePage{
	private AndroidDriver driver;
	
	private By add_icon=By.xpath("(//android.widget.TextView)[8]");
	
	
	private By pendingChat=By.xpath("//android.widget.TextView[@text='Sent you a contact request']");
	private By allowBtn=By.xpath("//android.widget.TextView[@text='Allow Communication']");
	private By contactName_field=By.xpath("//android.widget.TextView[@text='Contact Name']/preceding-sibling::android.widget.EditText");
	private By save_btn=By.xpath("//android.widget.TextView[@text='Save']");
	private By newMessageScreen=By.xpath("//android.widget.TextView[@text='New Message']");
	private By invite_btn=By.xpath("//android.widget.TextView[@text='Invite Friends']");
	private By inviteLink=By.id("android:id/content_preview_text");
	private By settings_btn=By.xpath("//android.widget.TextView[matches(@text,'[\\d]{3}\\s[\\d]{3}\\s[\\d]{3}')]/parent::android.view.ViewGroup/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup");
	private By msg_friend2=By.xpath("//android.widget.TextView[@text='...']/parent::android.view.ViewGroup/parent::android.view.ViewGroup/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.view.ViewGroup[1]");
	private By chat=By.xpath("//android.widget.TextView[@text='Say Hello to ...']");
	private By pin1=By.xpath("//android.widget.TextView[@text='1']");
	private By pin2=By.xpath("//android.widget.TextView[@text='2']");
	private By pin3=By.xpath("//android.widget.TextView[@text='3']");
	private By pin4=By.xpath("//android.widget.TextView[@text='4']");
	private By block_btn=By.xpath("//android.widget.TextView[@text='Block']");
	private By confirmBtn=By.id("android:id/button1");
	private By confirm_msg=By.id("android:id/message");
	private By msg_field=By.xpath("//android.widget.EditText[@text='Enter text here']");
	private By friend2_header=By.xpath("//android.widget.TextView[@text='Friend2']");
	private By friend1_chat=By.xpath("//android.widget.TextView[@text='... (NewRegister2)']");
	
	
	public ContactLocators(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public boolean getxID(String ID) {
		boolean isPresent=false;
		waitforElementPresent(xID);
		List<WebElement> Ids=driver.findElements(xID);
		for(WebElement Id:Ids) {
			if(Id.getText().equals(ID)) {
				isPresent=true;
			}
		}
		return isPresent;
		
	}
	public String verifyContactAdded(String contactName,String friend_xID) {
		
		driver.findElement(chat_icon).click();
		driver.findElement(dialpad_icon).click();
		driver.findElement(searchId_field).sendKeys(friend_xID);
		driver.findElement(add_icon).click();
		driver.findElement(contactName_field).clear();
		driver.findElement(contactName_field).sendKeys(contactName);
		driver.findElement(save_btn).click();
		waitforElementPresent(newMessageScreen);
		driver.findElement(back_btn).click();
		waitforElementPresent(xID);
		driver.findElement(contact_icon).click();
		waitforElementPresent(contacts_screen);
		List<WebElement> contacts=driver.findElements(xID);
		for(WebElement contact:contacts) {
			if(contact.getText().equals(friend_xID)) {
				return contact.getText();
			}
		}
		return "Contact not added";
	}
	public boolean verifyLinkGenerated() {
		driver.findElement(invite_btn).click();
		waitforElementPresent(inviteLink);
		return true;
	}
	
	public SettingsLocators gotoSettingsMenu() {
		driver.findElement(settings_btn).click();
		waitforElementPresent(settingsScreen);
		return new SettingsLocators(driver);
	}
	public boolean verifyReverse() {
		
		boolean isEmpty=false;
		driver.runAppInBackground(Duration.ofSeconds(5));
		driver.findElement(pin4).click();
		driver.findElement(pin3).click();
		driver.findElement(pin2).click();
		driver.findElement(pin1).click();
		List<WebElement> chats_list=driver.findElements(chat);
		driver.findElement(contact_icon).click();
		waitforElementPresent(contacts_screen);
		List<WebElement> contacts_list=driver.findElements(xID);
		if(chats_list.size()==0&&contacts_list.size()==0) {
			isEmpty=true;
		}
		return isEmpty;
	}
	public String verifyBlocked() {
		driver.findElement(contact_icon).click();
		driver.findElement(msg_friend2).click();
		waitforElementPresent(msg_field);
		driver.findElement(friend2_header).click();
		scrollTo("Block");
		driver.findElement(block_btn).click();
		driver.findElement(confirmBtn).click();
		waitforElementPresent(confirm_msg);
		return driver.findElement(confirm_msg).getText();
	}
	public String verifyUnBlocked() {
		driver.findElement(contact_icon).click();
		waitforElementPresent(contacts_screen);
		return driver.findElement(xID).getText();
	}
	public SingleChatLocators openChat(String friend_xID) {
		driver.findElement(chat_icon).click();
		driver.findElement(dialpad_icon).click();
		driver.findElement(searchId_field).sendKeys(friend_xID);
		driver.findElement(msg_icon).click();
		return new SingleChatLocators(driver);
	}
	public SingleChatLocators openReceivedChat() {
		driver.findElement(friend1_chat).click();
		return new SingleChatLocators(driver);
	}
	public SingleChatLocators sendPending(String friend_xID) {
		driver.findElement(chat_icon).click();
		driver.findElement(dialpad_icon).click();
		driver.findElement(searchId_field).sendKeys(friend_xID);
		driver.findElement(msg_icon).click();
		driver.findElement(confirmBtn).click();
		return new SingleChatLocators(driver);
	}
	public void openPending() {
		driver.findElement(contact_icon).click();
		driver.findElement(pendingChat).click();
		driver.findElement(allowBtn).click();
		
	}
	public boolean isAllowed() {
		waitforElementPresent(msg_field);
		return true;
	}
}