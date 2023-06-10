package locators;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class CallLocators extends BasePage{
	private AndroidDriver driver;
	private By audioCallIcon=By.xpath("(//android.widget.TextView)[6]");
	private By videoCallIcon=By.xpath("	//android.widget.TextView[contains(@text,'xID')]/parent::android.view.ViewGroup/parent::android.view.ViewGroup/parent::android.view.ViewGroup/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup");
	private By ringingStatus=By.xpath("//android.widget.TextView[@text='Ringing...']");
	private By acceptCallBtn=By.xpath("//android.widget.TextView[@text='Accept']/preceding-sibling::android.view.ViewGroup");
	private By callTimer=By.xpath("//android.widget.TextView[matches(@text,'[\\d]{2}\\s:\\s[\\d]{2}')]");
	private By callDuration=By.xpath("(//android.view.ViewGroup)[34]/android.widget.TextView[2]");
	private By cameraOffIcon=By.xpath("(//android.view.View)[2]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup");
	private By receiverID=By.xpath("//android.widget.TextView[matches(@text,'[\\d]{3}\\s[\\d]{3}\\s[\\d]{3}')]");
	private String callTime;
	private String recordedCallTime;

	public CallLocators(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void makeCall(String friend_xID,String callType) {
		driver.findElement(chat_icon).click();
		driver.findElement(dialpad_icon).click();
		driver.findElement(searchId_field).sendKeys(friend_xID);
		if(callType.equals("Audio Call")) {
			driver.findElement(audioCallIcon).click();
		}
		else {
			driver.findElement(msg_icon).click();
			driver.findElement(videoCallIcon).click();
		}
		waitforElementPresent(ringingStatus);
	}
	
	public void acceptAudioCall(){
		driver.findElement(acceptCallBtn).click();
		waitforElementPresent(callTimer);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
	        public Boolean apply(WebDriver driver)  
	        {
	        	String timerText = driver.findElement(callTimer).getText().replaceAll("\\s", "");
	        	String[] splitTime = timerText.split(":");
		        int mins = Integer.parseInt(splitTime[0].trim());
		        int secs = Integer.parseInt(splitTime[1].trim());
		        int totalSeconds = mins * 60 + secs;
		        return totalSeconds >= 20;	
	        }
	    });
	}
	public void acceptVideoCall(){
		driver.findElement(acceptCallBtn).click();
		waitforElementPresent(callTimer);
	}
	public boolean endVideoCall(){
		tapByCoordinates(400,1080);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		boolean isCameraOn=wait.until(new ExpectedCondition<Boolean>() {
		    public Boolean apply(WebDriver driver) {
		    	if(driver.findElements(cameraOffIcon).isEmpty()) {
		    		return true;
		    	}
		    	return false;
		    }
				});
		WebDriverWait waitForTime=new WebDriverWait(driver,Duration.ofSeconds(30));
		waitForTime.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
	        public Boolean apply(WebDriver driver)  
	        {
	        	String timerText = driver.findElement(callTimer).getText().replaceAll("\\s", "");
	        	String[] splitTime = timerText.split(":");
		        int mins = Integer.parseInt(splitTime[0].trim());
		        int secs = Integer.parseInt(splitTime[1].trim());
		        int totalSeconds = mins * 60 + secs;
		        return totalSeconds >= 30;	
	        }
	    });
		tapByCoordinates(330,640);
		waitforElementPresent(receiverID);
		callTime=driver.findElement(callTimer).getText();
		tapByCoordinates(600,1080);
		new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(callTimer));
		recordedCallTime=driver.findElement(callDuration).getText();
		return isCameraOn;
	}
	public void endAudioCall() {
		callTime=driver.findElement(callTimer).getText();
		tapByCoordinates(600,1080);
		new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(callTimer));
	}
	public boolean audioCallDuration() {
		driver.findElement(msg_icon).click();
		String callLog=driver.findElement(callDuration).getText();
		return (callLog.substring(14).equals(callTime.replaceAll("\\s","")));
	}
	public boolean verifyVideoCallDuration() {
		return (recordedCallTime.substring(14).equals(callTime.replaceAll("\\s","")));
	}
	public void tapByCoordinates(int x,int y) {
		PointerInput finger = new PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger"); 
		org.openqa.selenium.interactions.Sequence clickPosition = new org.openqa.selenium.interactions.Sequence(finger, 1);
		clickPosition .addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), x,y))
		.addAction(finger.createPointerDown(MouseButton.LEFT.asArg())) .addAction(finger.createPointerUp(MouseButton.LEFT.asArg())); 
		driver.perform(Arrays.asList(clickPosition));
	}
}
