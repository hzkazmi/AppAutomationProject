package testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseTest.BaseTest;

public class AddContactTest extends BaseTest{
	String friend_ID="....";
	
	@Test(dataProvider="getDatafromFile")
	public void addContact(HashMap<String,String> input) {
		Assert.assertEquals(chatsPage.verifyContactAdded(input.get("Name"),input.get("xID")),input.get("xID"));
	}
	
	@DataProvider
	public Object[][] getDatafromFile() throws IOException{
		
		List<HashMap<String,String>> data=getListData(System.getProperty("user.dir")+"//src//test//java//data//contacts.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
