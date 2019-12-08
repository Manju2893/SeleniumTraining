package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
//	@Test(priority = 1)
//	public void apartment_SearchRETC_009() throws Exception {
//		Thread.sleep(1000);
//		System.out.println(driver.getTitle());
//		loginRealEstate.clickPlots();
//		Thread.sleep(1000);
//		loginRealEstate.enterAddress();
//		System.out.println("Address Entered");
//		loginRealEstate.dropDownDisplay();
//		Thread.sleep(1000);
//		loginRealEstate.selectAnyRegionDropdown();
//		loginRealEstate.clickSearch();
//	}
//	@Test
//	public void enquiriesFormthrows_010() throws InterruptedException
//	{   loginRealEstate.newLaunch();
//	    Thread.sleep(3000);
//		loginRealEstate.contactForm();
//		 Thread.sleep(1000);
//		System.out.println("Submitted  enquiriesForm");	
//	}
	
	@Test (priority = 3)
	public void dashboard_SearchRETC_011()  throws Exception {
		Thread.sleep(1000);
		loginRealEstate.realEstateLogin();
		loginRealEstate.Signin();
		Thread.sleep(4000);
		System.out.println("DashBoard Page displyed");
	}
	
	
}
