package locators;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import basePage.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;

public class SingleChatLocators extends BasePage{
	private AndroidDriver driver;
	
	private By contact_icon=By.xpath("(//android.widget.TextView)[3]");
	private By msg_btn=By.xpath("//android.widget.TextView[@text='...']/parent::android.view.ViewGroup/parent::android.view.ViewGroup/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.view.ViewGroup[1]");
	private By msg_field=By.xpath("//android.widget.EditText[@text='Enter text here']");
	private By send_btn=By.xpath("//android.widget.EditText/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[2]");
	private By deliveredStatus=By.xpath("//android.widget.TextView[@text='Delivered']");
	private By sentStatus=By.xpath("//android.widget.TextView[@text='Sent']");
	private By addMedia_btn=By.xpath("//android.widget.EditText[@text='Enter text here']/parent::android.view.ViewGroup/preceding-sibling::android.view.ViewGroup");
	private By addDisMediaBtn=By.xpath("//android.widget.EditText[@text='Enter disappearing text']/parent::android.view.ViewGroup/preceding-sibling::android.view.ViewGroup");
	private By camera_btn=By.xpath("//android.widget.TextView[@text='Open Camera']");
	private By captureBtn=By.xpath("(//android.view.ViewGroup)[25]");
	private By browseImg_btn=By.xpath("//android.widget.TextView[@text='Browse Images']");
	private By browseVideo_btn=By.xpath("//android.widget.TextView[@text='Browse Video']");
	private By cancel_btn=By.xpath("//android.widget.TextView[@text='Cancel']");
	private By navBar=AppiumBy.accessibilityId("Show roots");
	private By navTitle=By.xpath("//android.widget.TextView[@text='Open from']");
	private By storageBtn=By.xpath("//android.widget.TextView[@text='sdk_gphone64_x86_64']");
	private By picturesBtn=By.xpath("//android.widget.TextView[@text='Pictures']");
	private By downloadBtn=By.xpath("//android.widget.TextView[@text='Download']");
	private By mediaFile=By.id("com.google.android.documentsui:id/thumbnail");
	private By sendMedia_btn=By.xpath("//android.widget.TextView[@text='...']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup");
	private By sendRecordedVideo_btn=By.xpath("//android.widget.TextView[@text='...']/parent::android.view.ViewGroup/child::android.view.ViewGroup");
	private By shareContact_btn=By.xpath("//android.widget.TextView[@text='Share Contact']");
	private By sharedContact_item=By.xpath("//android.widget.TextView[@text='Friend2']");
	private By disappearing_btn=By.xpath("//android.widget.EditText[@text='Enter text here']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]");
	private By msg_time=By.xpath("//android.widget.TextView[matches(@text,'^(1[0-2]|0?[1-9]):[0-5][0-9]\\s(AM|PM)$')]");
	private By wheelTitle=By.xpath("//android.widget.TextView[@text='Timer']");
	private By setTimer_btn=By.xpath("//android.widget.TextView[@text='Set Timer']");
	private By disappearing_field=By.xpath("//android.widget.EditText[@text='Enter disappearing text']");
	private By chatHeader=By.xpath("//android.widget.TextView[@text='xID: ...']");
	private By invalidToast=By.xpath("//android.widget.Toast[@text='The file should be less than 50 MB']");
	private By selectBtn=By.id("com.google.android.documentsui:id/action_menu_select");
	private By alertMsg=By.id("android:id/message");
	private By downloadImgBtn=By.xpath("//android.widget.TextView[@text='Tap to download']/preceding-sibling::android.view.ViewGroup");
	private By disappearingOnBtn=By.xpath("//android.widget.EditText[@text='Enter disappearing text']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]");
	private By xPalPushTitle=By.xpath("//android.widget.TextView[@text='xPalDev']");
	private By xPalPushText=By.id("android:id/big_text");
	private By pinScreen=By.xpath("//android.widget.TextView[@text=' Enter 4-Digit PIN']");
	
	public SingleChatLocators(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public boolean cancel() {
		driver.findElement(contact_icon).click();
		driver.findElement(msg_btn).click();
		driver.findElement(addMedia_btn).click();
		driver.findElement(cancel_btn).click();
		return(driver.findElement(msg_field).isDisplayed());
	}
	
	public void sendText(String msg,String status) {
		driver.findElement(msg_field).sendKeys(msg);
		driver.findElement(send_btn).click();
		if(status.equals("Delivered")) {
		waitforElementPresent(deliveredStatus);
		}
		else if(status.equals("Sent")) {
			waitforElementPresent(sentStatus);
		}
		
	}
	public void captureImg() {
		driver.findElement(addMedia_btn).click();
		driver.findElement(camera_btn).click();
		new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(camera_btn));
		driver.findElement(captureBtn).click();
	    driver.findElement(sendMedia_btn).click();
		waitforElementPresent(deliveredStatus);
	}
	public void captureVid() {
		driver.findElement(addMedia_btn).click();
		driver.findElement(camera_btn).click();
		new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(camera_btn));
		WebElement capture=driver.findElement(captureBtn);
		driver.executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)capture).getId(),"duration",6000));
		driver.findElement(sendRecordedVideo_btn).click();
		waitforElementPresent(deliveredStatus);
	}
	public void browseImg() {
		driver.findElement(addMedia_btn).click();
		driver.findElement(browseImg_btn).click();
		driver.findElement(navBar).click();
		waitforElementPresent(navTitle);
		driver.findElement(storageBtn).click();
		driver.findElement(picturesBtn).click();
		driver.findElement(mediaFile).click();
		driver.findElement(sendMedia_btn).click();
		waitforElementPresent(deliveredStatus);
	}
	public void browseImages() {
		driver.findElement(addMedia_btn).click();
		driver.findElement(browseImg_btn).click();
		List<WebElement> images=driver.findElements(mediaFile);
		WebElement firstImage=images.get(0);
		driver.executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)firstImage).getId(),"duration",2000));
		for (int i = 1; i < images.size()-1; i++) {
		   images.get(i).click();
		}
		driver.findElement(selectBtn).click();
		driver.findElement(sendMedia_btn).click();
		waitforElementPresent(deliveredStatus);
	}
	public String browseInvalidImages() {
		driver.findElement(addMedia_btn).click();
		driver.findElement(browseImg_btn).click();
		List<WebElement> images=driver.findElements(mediaFile);
		WebElement firstImage=images.get(0);
		driver.executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)firstImage).getId(),"duration",2000));
		for (int i = 1; i < images.size(); i++) {
		   images.get(i).click();
		}
		driver.findElement(selectBtn).click();
		WebElement alert=waitforElementPresent(alertMsg);
		return alert.getText();
	}
	
	public void browseVid() {
		driver.findElement(addMedia_btn).click();
		driver.findElement(browseVideo_btn).click();
		driver.findElement(storageBtn).click();
		driver.findElement(downloadBtn).click();
		List<WebElement> list_Videos=driver.findElements(mediaFile);
		list_Videos.get(1).click();
		driver.findElement(sendMedia_btn).click();
		waitforElementPresent(deliveredStatus); 
	}
	public boolean browseInvalidVid() {
		driver.findElement(addMedia_btn).click();
		driver.findElement(browseVideo_btn).click();
		driver.findElement(storageBtn).click();
		driver.findElement(downloadBtn).click();
		List<WebElement> list_Videos=driver.findElements(mediaFile);
		list_Videos.get(0).click();
		waitforElementPresent(invalidToast);
		return true;
	}
	public void contact() {
		driver.findElement(addMedia_btn).click();
		driver.findElement(shareContact_btn).click();
		driver.findElement(sharedContact_item).click();
		waitforElementPresent(deliveredStatus);
		}
	
	public void disappearingMsg(String msg) {
		driver.findElement(disappearing_btn).click();
		waitforElementPresent(wheelTitle);
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 362, 869));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(new Pause(finger, Duration.ofMillis(200)));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),362,779));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
		driver.findElement(setTimer_btn).click();
		waitforElementPresent(disappearing_field);
		driver.findElement(disappearing_field).sendKeys(msg);
		driver.findElement(send_btn).click();
		waitforElementPresent(deliveredStatus);
	}
	public boolean checkMsgs(){
		waitforElementPresent(chatHeader);
		List<WebElement> msg=driver.findElements(msg_time);
		if (msg.size()==1) {
			return true;
		}
		return false;
	}
	public void seeMessage() {
		driver.findElement(disappearingOnBtn).click();
		waitforElementPresent(wheelTitle);
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 362, 920));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(new Pause(finger, Duration.ofMillis(200)));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),362,978));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
		driver.findElement(setTimer_btn).click();	
	}
	public boolean hasMessageDisappeared() {
		return new WebDriverWait(driver,Duration.ofSeconds(25)).until(ExpectedConditions.invisibilityOfElementLocated(msg_time));
	}
	public boolean checkMultiImages(){
		waitforElementPresent(chatHeader);
		List<WebElement> msg=driver.findElements(msg_time);
		scrollTo("Today");
		msg.add(driver.findElement(msg_time));
		if(msg.size()==4) {
			return true;
		}
		return false;
}
	public void sendDisappearingImage() {
		driver.findElement(disappearing_btn).click();
		waitforElementPresent(wheelTitle);
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 362, 869));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(new Pause(finger, Duration.ofMillis(200)));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),362,779));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
		driver.findElement(setTimer_btn).click();
		waitforElementPresent(disappearing_field);
		driver.findElement(addDisMediaBtn).click();
		driver.findElement(browseImg_btn).click();
		driver.findElement(storageBtn).click();
		driver.findElement(picturesBtn).click();
		driver.findElement(mediaFile).click();
		driver.findElement(sendMedia_btn).click();
		waitforElementPresent(deliveredStatus);
	}
	public void downloadDisappearingImage(){
		waitforElementPresent(chatHeader);
		driver.findElement(disappearingOnBtn).click();
		waitforElementPresent(wheelTitle);
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 362, 920));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(new Pause(finger, Duration.ofMillis(200)));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),362,978));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
		driver.findElement(setTimer_btn).click();
		driver.findElement(downloadImgBtn).click();
	}
	public boolean hasImageDisappeared() {
		return new WebDriverWait(driver,Duration.ofSeconds(35)).until(ExpectedConditions.invisibilityOfElementLocated(msg_time));
	}
	
	public void backgroundAndOffline() {
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
		driver.setConnection(new ConnectionStateBuilder().withDataDisabled().build());
	}
	public void Online() {
		driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
		driver.setConnection(new ConnectionStateBuilder().withDataEnabled().build());
	}
	
	public void openPush() {
		driver.openNotifications();
		waitforElementPresent(xPalPushTitle);
		driver.findElement(xPalPushText).click();
		waitforElementPresent(pinScreen);
		enterPin();
	}
}