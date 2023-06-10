package testcases;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import locators.CallLocators;
import locators.LoginLocators;

public class VideoCallTest {
	public AndroidDriver driver;
	private AndroidDriver driver1;
	private LoginLocators loginPage;
	private CallLocators callLocators1;
	private CallLocators callLocators2;
	private AndroidDriver driver2;
	private String friendToCall="...";
	
	
	@BeforeTest
	public void Setup() {
		UiAutomator2Options options1=new UiAutomator2Options();
		options1.setApp("C:\\...\\eclipse-workspace\\xPalApp\\src\\test\\java\\resources\\app-debug.apk");
		options1.setCapability("autoGrantPermissions", true);
		options1.setCapability("udid", "emulator-5554");
		options1.setNewCommandTimeout(Duration.ofSeconds(90));
		options1.setSystemPort(8300);
		try {
			driver1=new AndroidDriver(new URL("http://127.0.0.1:4723"),options1);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		BasePage basePage=new BasePage(driver1);
		loginPage=basePage.gotoLogin();
		loginPage.verifyChatPage("...","...");
		callLocators1=new CallLocators(driver1);
		UiAutomator2Options options2=new UiAutomator2Options();
		options2.setApp("C:\\...\\eclipse-workspace\\xPalApp\\src\\test\\java\\resources\\app-debug.apk");
		options2.setCapability("autoGrantPermissions", true);
		options2.setCapability("udid", "06081330BT105920");
		options2.setNewCommandTimeout(Duration.ofSeconds(90));
		options2.setSystemPort(9000);
		try {
			driver2=new AndroidDriver(new URL("http://127.0.0.1:4725"),options2);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		basePage=new BasePage(driver2);
		loginPage=basePage.gotoLogin();
		loginPage.verifyChatPage(friendToCall,"...");
		callLocators2=new CallLocators(driver2);
		driver=driver1;
	}
	@Test
	public void videoCall(){
		callLocators1.makeCall(friendToCall, "Video Call");
		callLocators1.tapByCoordinates(400,1080);
		driver=driver2;
		callLocators2.acceptVideoCall();
		driver=driver1;
		Assert.assertTrue(callLocators1.endVideoCall());
		}
	
	@Test(dependsOnMethods= {"videoCall"})
	public void videoCallDuration() {
		callLocators1.verifyVideoCallDuration();
}
	
	@AfterTest
	public void quitDrivers() {
		driver1.quit();
		driver2.quit();
	}
}