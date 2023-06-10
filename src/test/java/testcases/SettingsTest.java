package testcases;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;


import baseTest.BaseTest;
import locators.SettingsLocators;

public class SettingsTest extends BaseTest{
	
	private SettingsLocators settingsPage;
	
	@Test(priority=1)
	public void changePin() {
		settingsPage=chatsPage.gotoSettingsMenu();
		String alert=settingsPage.verifyPin();
		Assert.assertEquals(alert,"PIN changed successfully");
	}
	
	@Test(priority=2)
	public void changePassword() {
		String new_password="...";
		settingsPage=chatsPage.gotoSettingsMenu();
		String alert=settingsPage.verifyPassword("...",new_password);
		try {
			updatePassword(new_password);
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(alert,"Password changed successfully");
	}
	
	@Test(priority=5)
	public void enableReverse() {
		settingsPage=chatsPage.gotoSettingsMenu();
		Assert.assertTrue(settingsPage.reverseEnable());
	}
	
	@Test(priority=6,dependsOnMethods= {"enableReverse"})
	public void reversePin() {
		Assert.assertTrue(chatsPage.verifyReverse());
	}
	
	@Test(priority=3)
	public void enabletwoStepVerification() {
		settingsPage=chatsPage.gotoSettingsMenu();
		Assert.assertEquals(settingsPage.setTwoStep("..."), "You have successfully enabled the Two-Step Verification");
	}
	
	@Test(priority=4)
	public void disabletwoStepVerification() {
		settingsPage=chatsPage.gotoSettingsMenu();
		settingsPage.disableTwoStep(password);
	}
	
	
}
