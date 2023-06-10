package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import locators.ContactLocators;
import locators.LoginLocators;
import locators.RegisterLocators;
import locators.SettingsLocators;

public class SignOutTest extends BaseTest{
	private SettingsLocators settingsPage;
	
	@Test
	public void signOut() {
		settingsPage=chatsPage.gotoSettingsMenu();
		Assert.assertTrue(settingsPage.signout());	
	}
	
	@Test
	public void switchAccount() {
		settingsPage=chatsPage.gotoSettingsMenu();
		RegisterLocators registerPage=settingsPage.switchAccount();
		LoginLocators loginPage=registerPage.gotoLogin();
		ContactLocators chatsPage=loginPage.verifyChatPage("...", "...");
		Assert.assertTrue(chatsPage.getxID("..."));
	}
}
