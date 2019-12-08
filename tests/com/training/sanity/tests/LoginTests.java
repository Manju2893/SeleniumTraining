package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.realestate.LoginRealEstate;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private LoginRealEstate loginRealEstate;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		loginRealEstate=new LoginRealEstate(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority = 1)
	public void apartment_SearchRETC_009() throws Exception {
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		loginRealEstate.clickPlots();
		Thread.sleep(5000);
		loginRealEstate.enterAddress();
		System.out.println("Address Entered");
		loginRealEstate.dropDownDisplay();
		Thread.sleep(1000);
		loginRealEstate.selectAnyRegionDropdown();
		loginRealEstate.clickSearch();
		Thread.sleep(5000);
		screenShot.captureScreenShot("Capture_apartment_SearchRETC_009");
		Thread.sleep(5000);
		
	}

	
	@Test (priority = 2)
	public void dashboard_SearchRETC_011()  throws Exception {
		Thread.sleep(1000);
		loginRealEstate.realEstateLogin();
		loginRealEstate.Signin();
		Thread.sleep(5000);
		System.out.println("DashBoard Page displyed");
		screenShot.captureScreenShot("Capture_apartment_SearchRETC_011");
		Thread.sleep(5000);
	}
	//reset password link is not working
//	@Test (priority = 3)
//	public void resetPassword_SearchRETC_012() throws InterruptedException, IOException
//	{   Thread.sleep(1000);
//		loginRealEstate.recoverPassword();
//		Thread.sleep(5000);
//		screenShot.captureScreenShot("Capture_apartment_SearchRETC_012");
//		Thread.sleep(2000);
//	}
	
	@Test (priority = 4)
	public void userlinks_SearchRETC_022() throws InterruptedException, IOException
	{   Thread.sleep(1000);
	
	    loginRealEstate.realEstateLogin();
	    loginRealEstate.Signin();
		loginRealEstate.changeRole();
		Thread.sleep(2000);
		screenShot.captureScreenShot("Capture_apartment_SearchRETC_022");
		
		Thread.sleep(2000);
		
	}
	
}
