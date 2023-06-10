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
import io.appium.java_client.service.local.AppiumDriverLocalService;
import locators.ContactLocators;
import locators.LoginLocators;
import locators.SettingsLocators;
import locators.SingleChatLocators;


public class ChatTest{
	
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	private AndroidDriver driver1;
	private LoginLocators loginPage;
	private ContactLocators chatsPage1;
	private ContactLocators chatsPage2;
	private AndroidDriver driver2;
	private SingleChatLocators singleChatLocators1;
	private SingleChatLocators singleChatLocators2;
	private final String user2="....";
	
	
	@BeforeMethod
	public void BeforeChat() {
		UiAutomator2Options options1=new UiAutomator2Options();
		options1.setNewCommandTimeout(Duration.ofSeconds(90));
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
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BasePage basePage=new BasePage(driver1);
		loginPage=basePage.gotoLogin();
		chatsPage1=loginPage.verifyChatPage("....","Aa1");
		UiAutomator2Options options2=new UiAutomator2Options();
		options1.setNewCommandTimeout(Duration.ofSeconds(90));
		options2.setApp("C:\\....\\eclipse-workspace\\xPalApp\\src\\test\\java\\resources\\app-debug.apk");
		options2.setCapability("autoGrantPermissions", true);
		options2.setCapability("udid", "emulator-5556");
		options2.setSystemPort(9000);
		try {
			driver2=new AndroidDriver(new URL("http://127.0.0.1:4725"),options2);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		basePage=new BasePage(driver2);
		loginPage=basePage.gotoLogin();
		chatsPage2=loginPage.verifyChatPage(user2,"Aa1");
		driver=driver1;
	}
	
	@Test(priority=1)
	public void textMsg(){
		singleChatLocators1=chatsPage1.openChat(user2);
		singleChatLocators1.sendText("txt","Delivered");
		driver=driver2;
		singleChatLocators2=chatsPage2.openReceivedChat();
		Assert.assertTrue(singleChatLocators2.checkMsgs());		
	}
	
	@Test(priority=2)
	public void captureImage(){
		singleChatLocators1=chatsPage1.openChat(user2);
		singleChatLocators1.captureImg();
		driver=driver2;
		singleChatLocators2=chatsPage2.openReceivedChat();
		Assert.assertTrue(singleChatLocators2.checkMsgs());
	}
	
	@Test(priority=3)
	public void browseImage(){
		singleChatLocators1=chatsPage1.openChat(user2);
		singleChatLocators1.browseImg();
		driver=driver2;
		singleChatLocators2=chatsPage2.openReceivedChat();
		Assert.assertTrue(singleChatLocators2.checkMsgs());
	}
	
	@Test(priority=4)
	public void browseMultiImage(){
		singleChatLocators1=chatsPage1.openChat(user2);
		singleChatLocators1.browseImages();
		driver=driver2;
		singleChatLocators2=chatsPage2.openReceivedChat();
		singleChatLocators2.checkMultiImages();
	}
	
	@Test(priority=5)
	public void browseValidVideo(){
		singleChatLocators1=chatsPage1.openChat(user2);
		singleChatLocators1.browseVid();
		driver=driver2;
		singleChatLocators2=chatsPage2.openReceivedChat();
		Assert.assertTrue(singleChatLocators2.checkMsgs());
	}
	
	@Test(dependsOnMethods={"testcases.AddContactTest.addContact"})
	public void shareContact(){
		singleChatLocators1=chatsPage1.openChat(user2);
		singleChatLocators1.contact();
		driver=driver2;
		singleChatLocators2=chatsPage2.openReceivedChat();
		Assert.assertTrue(singleChatLocators2.checkMsgs());
	}
	
	@Test(priority=6)
	public void captureVideo(){
		singleChatLocators1=chatsPage1.openChat(user2);
		singleChatLocators1.captureVid();
		driver=driver2;
		singleChatLocators2=chatsPage2.openReceivedChat();
		Assert.assertTrue(singleChatLocators2.checkMsgs());
	}
	
	@Test(priority=7)
	public void disappearingMsg() {
		singleChatLocators1=chatsPage1.openChat(user2);
		singleChatLocators1.disappearingMsg("text");
		driver=driver2;
		singleChatLocators2=chatsPage2.openReceivedChat();
		singleChatLocators2.checkMsgs();
		singleChatLocators2.seeMessage();
		boolean hasDisappearedFromReceiver=singleChatLocators2.hasMessageDisappeared();
		driver=driver1;
		boolean hasDisappearedFromSender=singleChatLocators1.hasMessageDisappeared();
		Assert.assertTrue(hasDisappearedFromReceiver&&hasDisappearedFromSender);
	}
	
	@Test(priority=8)
	public void disappearingImage() {
		singleChatLocators1=chatsPage1.openChat(user2);
		singleChatLocators1.sendDisappearingImage();
		driver=driver2;
		singleChatLocators2=chatsPage2.openReceivedChat();
		singleChatLocators2.downloadDisappearingImage();
		boolean hasDisappearedFromReceiver=singleChatLocators2.hasImageDisappeared();
		driver=driver1;
		boolean hasDisappearedFromSender=singleChatLocators1.hasImageDisappeared();
		Assert.assertTrue(hasDisappearedFromSender&&hasDisappearedFromReceiver);
	}
	
	@Test(priority=9)
	public void sendPendingMsg() {
		driver=driver2;
		SettingsLocators settingsLocators=chatsPage2.gotoSettingsMenu();
		settingsLocators.setToByApprovalOnly();
		driver=driver1;
		singleChatLocators1=chatsPage1.sendPending(user2);
		singleChatLocators1.sendText("txt1","Delivered");
		singleChatLocators1.sendText("txt2","Delivered");
		driver=driver2;
		chatsPage2.openPending();
		driver=driver1;
		Assert.assertTrue(chatsPage1.isAllowed());
	}
	
	@Test
	public void offlineMessages() {
		driver=driver2;
		SingleChatLocators singleChatLocators2=new SingleChatLocators(driver2);
		singleChatLocators2.backgroundAndOffline();
		driver=driver1;
		singleChatLocators1=chatsPage1.openChat(user2);
		singleChatLocators1.sendText("txt","sent");
		driver=driver2;
		singleChatLocators2.Online();
		singleChatLocators2.openPush();
		Assert.assertTrue(singleChatLocators2.checkMsgs());
	}
		
	@AfterMethod
	public void afterChat() {
		driver1.quit();
		driver2.quit();
	}
}
