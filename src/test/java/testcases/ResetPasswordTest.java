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
import locators.ContactLocators;
import locators.LoginLocators;
import locators.ResetPasswordLocators;



public class ResetPasswordTest{
	
	private LoginLocators loginPage;
	public AndroidDriver driver;
	private String xID="...";
	private ResetPasswordLocators resetPassword;
	
	@BeforeMethod
	public void configure() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setCapability("udid","emulator-5554");
		options.setApp("C:\\...\\eclipse-workspace\\xPalApp\\src\\test\\java\\resources\\app-debug.apk");
		options.setCapability("autoGrantPermissions", true);
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		BasePage basePage=new BasePage(driver);
		basePage.gotoLogin();
		resetPassword=new ResetPasswordLocators(driver);
	}
	
	@Test
	public void resetByQs() {
		String password="...";
		loginPage=resetPassword.resetbyQuestions(xID,password,"...");
		ContactLocators chatsPage=loginPage.verifyChatPage(xID, password);
		Assert.assertTrue(chatsPage.getxID(xID));
	}
	
	@Test
	public void resetByPhrase() {
		String password="...";
		loginPage=resetPassword.resetbyPhrase(xID,password,"...");
		ContactLocators chatsPage=loginPage.verifyChatPage(xID, password);
		Assert.assertTrue(chatsPage.getxID(xID));
	}
	
	@Test
	public void resetByEmail() {
		String password="...";
		loginPage=resetPassword.resetbyEmail(xID,password,"...");
		ContactLocators chatsPage=loginPage.verifyChatPage(xID, password);
		Assert.assertTrue(chatsPage.getxID(xID));
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
