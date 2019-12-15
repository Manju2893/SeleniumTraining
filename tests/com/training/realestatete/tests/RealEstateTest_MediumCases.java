package com.training.realestatete.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class RealEstateTest_MediumCases {

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

	@Test(priority = 1)
	public void propertylinks_SearchRETC_039() throws InterruptedException, IOException {
		Thread.sleep(1000);
		loginRealEstate.realEstateLogin();
		genericMethods.clickToElement(loginRealEstate.Send);
		Thread.sleep(5000);
		Thread.sleep(3000);
		genericMethods.clickToElement(loginRealEstate.Posts);
		Thread.sleep(3000);
		genericMethods.clickToElement(loginRealEstate.Categories);
		Thread.sleep(1000);
		genericMethods.sendKeys(loginRealEstate.Name, "New Launches");
		genericMethods.sendKeys(loginRealEstate.slug, "launchs");
		genericMethods.sendKeys(loginRealEstate.description, "New Launches of villas, apartments, flats"); //
		genericMethods.clickToElement(loginRealEstate.AddNewCatergory);
		Thread.sleep(2000);
		genericMethods.clickToElement(loginRealEstate.Posts);
		Thread.sleep(5000);
		genericMethods.clickToElement(loginRealEstate.AllPosts);
		Thread.sleep(2000);
		genericMethods.clickToElement(loginRealEstate.Addnew);
		genericMethods.sendKeys(loginRealEstate.titlebox, "NewLaunches1");
		genericMethods.sendKeys(loginRealEstate.content, "newNew Launch in 1Home1");
		genericMethods.clickToElement(loginRealEstate.category_Checkbox);
		System.out.println("Checkbox selected ");
		Thread.sleep(5000);
		genericMethods.jseClick(driver, loginRealEstate.publish);
		Thread.sleep(5000);
		System.out.println("published");
		genericMethods.clickToElement(loginRealEstate.Viewpost);
		System.out.println("postviewd");
		System.out.println(loginRealEstate.blog.getText());
		Thread.sleep(5000);
		screenShot.captureScreenShot("Capture_apartment_SearchRETC_039");

	}

	@Test(priority = 2)
	public void propertylinks_SearchRETC_046() throws InterruptedException, IOException {
		Thread.sleep(1000);
		loginRealEstate.realEstateLogin();
		genericMethods.clickToElement(loginRealEstate.Send);
		genericMethods.clickToElement(loginRealEstate.properties);
		genericMethods.clickToElement(loginRealEstate.Addnew);
		genericMethods.sendKeys(loginRealEstate.titlebox, "prestige-1");
		System.out.println("titlebox");
		genericMethods.sendKeys(loginRealEstate.content, "home town-1");
		System.out.println("content");
		genericMethods.clickToElement(loginRealEstate.Featurecheckbox);
		System.out.println("Featurecheckbox selected");
		Thread.sleep(5000);
		genericMethods.clickToElement(loginRealEstate.Regioncheckbox);
		System.out.println("Regioncheckbox selected ");
		Thread.sleep(5000);
		genericMethods.jseClick(driver, loginRealEstate.publish);
		Thread.sleep(5000);
		System.out.println("published");
		genericMethods.clickToElement(loginRealEstate.Viewpost);
		System.out.println("post viewd");
		Thread.sleep(5000);
		screenShot.captureScreenShot("Capture_apartment_SearchRETC_046");
		

	}

	@Test(priority = 3)
	public void new_Feature_047() throws InterruptedException, IOException {
		Thread.sleep(1000);
		loginRealEstate.realEstateLogin();
		genericMethods.clickToElement(loginRealEstate.Send);
		genericMethods.clickToElement(loginRealEstate.properties);
		Thread.sleep(5000);
		genericMethods.clickToElement(loginRealEstate.Addnew);
		Thread.sleep(5000);
		genericMethods.clickToElement(loginRealEstate.Feature);
		Thread.sleep(5000);
		genericMethods.sendKeys(loginRealEstate.Name, "Best");
		System.out.println("Name Entered");
		genericMethods.drodown(loginRealEstate.ParentFeature, "interior");
		Thread.sleep(5000);
		genericMethods.clickToElement(loginRealEstate.Newfeature);
		Thread.sleep(5000);
		// need to use from keyboard
		driver.navigate().refresh();
		Thread.sleep(5000);
		genericMethods.clickToElement(loginRealEstate.properties);
		genericMethods.clickToElement(loginRealEstate.Addnew);
		genericMethods.sendKeys(loginRealEstate.titlebox, "prestige");
		System.out.println("titlebox Entered");
		genericMethods.sendKeys(loginRealEstate.content, "home town");
		System.out.println("content Entered");
		genericMethods.clickToElement(loginRealEstate.Featurecheckbox);
		System.out.println("Featurecheckbox Selected");
		Thread.sleep(5000);
		genericMethods.jseClick(driver, loginRealEstate.publish);
		System.out.println("published");
		Thread.sleep(5000);
		screenShot.captureScreenShot("Capture_apartment_SearchRETC_047");
	}

}
