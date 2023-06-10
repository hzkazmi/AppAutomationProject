package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import locators.SingleChatLocators;

public class ChatErrorValidationsTest extends BaseTest{
	
	private SingleChatLocators singleChatLocators;
	private String user2="....";
	
	@Test(priority=2)
	public void browseInvalidVideo(){
		
		singleChatLocators=chatsPage.openChat(user2);
		Assert.assertTrue(singleChatLocators.browseInvalidVid());
	}
	
	@Test(priority=1)
	public void selectMoreThan4Images(){
		
		singleChatLocators=chatsPage.openChat(user2);
		Assert.assertEquals(singleChatLocators.browseInvalidImages(),"Maximum 4 images can be sent");
	}
	
}
