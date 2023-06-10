package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import locators.SettingsLocators;

public class PrivacyTest extends BaseTest{
	SettingsLocators settingsPage;
	
	@Test
	public void block() {
		Assert.assertEquals("User blocked successfully", chatsPage.verifyBlocked());
	}
	
	@Test(dependsOnMethods= {"block"})
	public void verifyBlockedList() {
		settingsPage=chatsPage.gotoSettingsMenu();
		Assert.assertTrue(settingsPage.isBlocked());
	}
	
	@Test(dependsOnMethods= {"verifyBlockedList"})
	public void unblock() {
		settingsPage=chatsPage.gotoSettingsMenu();
		Assert.assertTrue(settingsPage.unblock());
	}
	
	@Test(dependsOnMethods= {"unblock"})
	public void isUnblocked() {
		Assert.assertEquals(chatsPage.verifyUnBlocked(), "....");
	}
	
	@Test
	public void setupQuestions() {
		settingsPage=chatsPage.gotoSettingsMenu();
		settingsPage.addQuestions(password, "a");
	}
	
	@Test
	public void setupPhrase() {
		settingsPage=chatsPage.gotoSettingsMenu();
		settingsPage.addPhrase(password, "a b");
	}
}
