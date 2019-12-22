package com.training.realestatete.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.realestate.LoginRealEstate;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealEstateTest_ComplecCases {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private LoginRealEstate loginRealEstate;

	private GenericMethods genericMethods;

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
		loginRealEstate = new LoginRealEstate(driver);
		genericMethods = new GenericMethods(driver);
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

	// Complex
	

	// RETC_79
	@Test(priority = 1)
	public void multiple_NewFeature_079() throws InterruptedException, IOException {
		Thread.sleep(1000);
		loginRealEstate.realEstateLogin();
		genericMethods.clickToElement(loginRealEstate.Send);
		genericMethods.clickToElement(loginRealEstate.properties);
		Thread.sleep(5000);
		genericMethods.clickToElement(loginRealEstate.Feature);
		Thread.sleep(5000);
		genericMethods.sendKeys(loginRealEstate.Name, "Best");
		System.out.println("Name Entered");
		genericMethods.drodown(loginRealEstate.ParentFeature, "interior");
		Thread.sleep(5000);
		genericMethods.clickToElement(loginRealEstate.Newfeature);
		Thread.sleep(5000);
		screenShot.captureScreenShot("Capture_apartment_SearchRETC_079");
	}

	// RETC_80
	@Test(priority = 2)
	public void property_Details_80() throws InterruptedException, IOException {
		Thread.sleep(1000);
		Thread.sleep(1000);
		loginRealEstate.realEstateLogin();
		genericMethods.clickToElement(loginRealEstate.Send);
		genericMethods.clickToElement(loginRealEstate.properties);
		Thread.sleep(5000);
		genericMethods.clickToElement(loginRealEstate.Addnew);
		genericMethods.sendKeys(loginRealEstate.titlebox, "new launch");
		genericMethods.sendKeys(loginRealEstate.content, "new launch");
		genericMethods.sendKeys(loginRealEstate.Price, "50000.00");
		genericMethods.sendKeys(loginRealEstate.Price_per, "200.00");
		genericMethods.clickToElement(loginRealEstate.MainDetails);
		Thread.sleep(5000);
		genericMethods.sendKeys(loginRealEstate.status, "New");
		genericMethods.sendKeys(loginRealEstate.location, "Electronic city");
		genericMethods.sendKeys(loginRealEstate.possession, "immediate");
		genericMethods.clickToElement(loginRealEstate.Location_tab);
		Thread.sleep(2000);
		genericMethods.sendKeys(loginRealEstate.Address, "yeshwanthapur");
		genericMethods.sendKeys(loginRealEstate.MapAddress, "yeshwanthapur");
		genericMethods.sendKeys(loginRealEstate.latitude, "120");
		genericMethods.sendKeys(loginRealEstate.Longitude, "56");
		genericMethods.clickToElement(loginRealEstate.Details_tab);
		Thread.sleep(2000);
		genericMethods.sendKeys(loginRealEstate.Storage, "2");
		genericMethods.clickToElement(loginRealEstate.Checkbox1);
		Thread.sleep(5000);
		genericMethods.scrollDownToUpnAction();
		Thread.sleep(5000);
		genericMethods.clickToElement(loginRealEstate.Featurecheckbox);
		System.out.println("Featurecheckbox selected");
		Thread.sleep(5000);
		genericMethods.clickToElement(loginRealEstate.Regioncheckbox);
		System.out.println("Regioncheckbox selected ");
		Thread.sleep(5000);
		genericMethods.jseClick(driver, loginRealEstate.publish);
		Thread.sleep(5000);
		genericMethods.mouseAction(driver, loginRealEstate.logouticon);
		System.out.println("Logged out");
		genericMethods.clickToElement(loginRealEstate.Logout);
		genericMethods.clickToElement(loginRealEstate.RealEstate);
		System.out.println("Verified Properties");
		screenShot.captureScreenShot("Capture_apartment_SearchRETC_080");
	}
	// RETC_76
		@Test(priority = 3)
		public void user_AddNewRETC_076() throws Exception {
			Thread.sleep(1000);
			loginRealEstate.realEstateLogin();
			genericMethods.clickToElement(loginRealEstate.Send);
			Thread.sleep(5000);
			System.out.println("DashBoard Page displyed");
			genericMethods.clickToElement(loginRealEstate.Users);
			Thread.sleep(5000);
			genericMethods.clickToElement(loginRealEstate.Users_Addnew);
			Thread.sleep(8000);
			System.out.println("LoggedIn");
			genericMethods.sendKeys(loginRealEstate.User_name, "Sowmya182");
			genericMethods.sendKeys(loginRealEstate.User_email, "S1owmya@gmail892.com");
			genericMethods.sendKeys(loginRealEstate.User_first_name, "manjula");
			genericMethods.sendKeys(loginRealEstate.User_last_name, "L");
			genericMethods.sendKeys(loginRealEstate.User_url, "www.te1st.com");
			genericMethods.clickToElement(loginRealEstate.User_showPassword);
			genericMethods.clearExistingText(loginRealEstate.User_PasswordText);
			Thread.sleep(1000);
			genericMethods.sendKeys(loginRealEstate.User_PasswordText, "Manzoor@Mehadi123#");
			System.out.println("Entered password");

			genericMethods.drodown(loginRealEstate.User_role, "Agent");
			System.out.println("Password Entered");
			Thread.sleep(5000);
			genericMethods.clickToElement(loginRealEstate.AddNewUser);
			genericMethods.clickToElement(loginRealEstate.CreatedNewUser);
			System.out.println("Created User");
			screenShot.captureScreenShot("Capture_apartment_SearchRETC_076");

		}
}
