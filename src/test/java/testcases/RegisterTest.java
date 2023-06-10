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
import locators.RegisterLocators;


public class RegisterTest{
	public AndroidDriver driver;
	public BasePage basePage;
	public RegisterLocators registerPage;
	
	
	@BeforeMethod
	public void setup() {
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		basePage=new BasePage(driver);
		registerPage=basePage.gotoRegister();
	}
	@Test
	public void Register() throws MalformedURLException {
		Assert.assertTrue(registerPage.verifyRegister("Automator1","..."));
	}
	
	@Test
	public void invalidRegister(){
		Assert.assertTrue(registerPage.verifyInvalidRegister("..."));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}