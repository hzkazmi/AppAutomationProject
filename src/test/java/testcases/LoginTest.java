package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import locators.ContactLocators;
import locators.LoginLocators;

public class LoginTest {
	private LoginLocators loginPage;
	private ContactLocators chatsPage;
	private AndroidDriver driver;
	
	@Test
	public void login() {
	UiAutomator2Options options=new UiAutomator2Options();
	options.setCapability("udid","emulator-5554");
	options.setApp("C:\\...\\eclipse-workspace\\xPalApp\\src\\test\\java\\resources\\app-debug.apk");
	options.setCapability("autoGrantPermissions", true);
	try {
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	BasePage basePage=new BasePage(driver);
	String xID="....";
	loginPage=basePage.gotoLogin();
	chatsPage=loginPage.verifyChatPage(xID,"...");
	Assert.assertTrue(chatsPage.getxID(xID));
	driver.quit();
}
}