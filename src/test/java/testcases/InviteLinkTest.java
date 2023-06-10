package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;

public class InviteLinkTest extends BaseTest{
	
	@Test(priority=3)
	public void generateLink() {
		Assert.assertTrue(chatsPage.verifyLinkGenerated());
	}
}
