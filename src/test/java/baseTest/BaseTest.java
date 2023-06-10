package baseTest;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


import basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import locators.ContactLocators;
import locators.LoginLocators;


public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public LoginLocators loginPage;
	public ContactLocators chatsPage;
	public String password;
	
	
	@BeforeMethod
	public void configureAppium() throws IOException {
	/*service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Ensx-pc\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();
	service.start();
	*/
	UiAutomator2Options options=new UiAutomator2Options();
	options.setCapability("udid", "emulator-5554");
	options.setApp("C:\\....\\eclipse-workspace\\xPalApp\\src\\test\\java\\resources\\app-debug.apk");
	options.setCapability("autoGrantPermissions", true);
	driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	BasePage basePage=new BasePage(driver);
	String xID="....";
	loginPage=basePage.gotoLogin();
	getData();
	chatsPage=loginPage.verifyChatPage(xID,password);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		//service.stop();
	}
	public List<HashMap<String, String>> getListData(String filePath) throws IOException {
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
		});
		return data;
	}
	public HashMap<String, String> getJsonDatatoMap(String filePath) throws IOException {
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		HashMap<String,String> data=mapper.readValue(jsonContent, new TypeReference<HashMap<String,String>>(){
		});
		return data;
	}
	
	public void getData() throws IOException{
		
		HashMap<String,String> data=getJsonDatatoMap(System.getProperty("user.dir")+"//src//test//java//data//credentials.json");
		password=data.get("password");
		
	}
	public void updatePassword(String new_password) throws StreamWriteException, DatabindException, IOException {
		HashMap<String, String> data=new HashMap<String,String>();
		try {
			data = getJsonDatatoMap(System.getProperty("user.dir")+"//src//test//java//data//credentials.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data.put("password", new_password);
		ObjectMapper mapper = new ObjectMapper();
		 mapper.writerWithDefaultPrettyPrinter().writeValue(new File(System.getProperty("user.dir")+"//src//test//java//data//credentials.json"), data);
	}
}
