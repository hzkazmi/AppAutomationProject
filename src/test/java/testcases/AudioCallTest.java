package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import locators.CallLocators;
import locators.LoginLocators;

public class AudioCallTest {
	public AndroidDriver driver;
	private AndroidDriver driver1;
	private LoginLocators loginPage;
	private CallLocators callLocators1;
	private CallLocators callLocators2;
	private AndroidDriver driver2;
	private String friendToCall="....";
	
	@BeforeMethod
	public void BeforeChat() {
		UiAutomator2Options options1=new UiAutomator2Options();
		options1.setApp("C:\\....\\eclipse-workspace\\xPalApp\\src\\test\\java\\resources\\app-debug.apk");
		options1.setCapability("autoGrantPermissions", true);
		options1.setCapability("udid", "emulator-5554");
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
		loginPage.verifyChatPage("....","Aa1");
		callLocators1=new CallLocators(driver1);
		UiAutomator2Options options2=new UiAutomator2Options();
		options2.setApp("C:\\.....\\eclipse-workspace\\xPalApp\\src\\test\\java\\resources\\app-debug.apk");
		options2.setCapability("autoGrantPermissions", true);
		options2.setCapability("udid", "06081330BT105920");
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
		loginPage.verifyChatPage(friendToCall,"Aa1");
		callLocators2=new CallLocators(driver2);
		driver=driver1;
	}
	
	@Test
	public void AudioCall() {
		callLocators1.makeCall(friendToCall,"Audio Call");
		driver=driver2;
		callLocators2.acceptAudioCall();
		driver=driver1;
		callLocators1.endAudioCall();
		Assert.assertTrue(callLocators1.audioCallDuration());
	}
	
	@AfterMethod
	public void quit() {
		driver1.quit();
		driver2.quit();
	}
	

}	
