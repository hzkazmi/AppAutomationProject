package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import locators.SettingsLocators;

public class EditProfileTest extends BaseTest{
	private SettingsLocators settingsLocators;

	@Test
	public void editProfile() {
		settingsLocators=chatsPage.gotoSettingsMenu();
		Assert.assertTrue(settingsLocators.verifyProfileEdited("name"));
	}
	
	@Test
	public void invalidProfileName() {
		settingsLocators=chatsPage.gotoSettingsMenu();
		Assert.assertTrue(settingsLocators.verifyInvalidName("xpal"));
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
}
