package com.training.realestate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginRealEstate {

	private WebDriver driver;

	public LoginRealEstate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//RETC_009

	@FindBy(xpath = "//*[@id='menu-item-570']/a")
	private WebElement plots;
	@FindBy(id = "keyword_search")
	private WebElement addTextBox;
	@FindBy(css = "#_property_type_chosen > a")
	private WebElement propertyTyp;
//	@FindBy(xpath="//*[@id='_property_type_chosen']/div/ul/li")
//	private WebElement dropdown;
	@FindBy(xpath = "//span[contains(text(),'Any Regions')]")
	private WebElement anyRegion;
	@FindBy(css = "button.button")
	public WebElement Search;

	// RETC_011

	@FindBy(xpath = "//*[@class='sign-in']")
	private WebElement LogIn;
	@FindBy(id = "user_login")
	private WebElement Username;
	@FindBy(id = "user_pass")
	private WebElement Password;
	@FindBy(className = "login")
	private WebElement SignIn;
	@FindBy(xpath = "//*[@type='submit']")
	public WebElement Send;

	// RETC_022
	@FindBy(id = "menu-users")
	private WebElement users;
	@FindBy(id = "cb-select-all-1")
	private WebElement Username_checkbox;
	@FindBy(id = "new_role")
	private WebElement Newrole;
	@FindBy(id = "changeit")
	private WebElement Change;
	@FindBy(xpath = "//*[@id='wpbody-content']/div[3]/div[3]")
	private WebElement ChangeroleMessage;

	// RETC_027
	@FindBy(xpath = "//*[@id='menu-posts-property']/a")
	private WebElement Properties;
	@FindBy(xpath = "//*[@id='menu-posts-property']/ul/li[4]/a")
	private WebElement Features;
	@FindBy(id = "tag-name")
	public WebElement Name;
	@FindBy(id = "tag-slug")
	public WebElement slug;
	@FindBy(id = "tag-description")
	public WebElement description;
	@FindBy(id = "submit")
	public WebElement Newfeature;
	@FindBy(id = "tag-search-input")
	private WebElement SearchBox;
	@FindBy(id = "search-submit")
	private WebElement SearchFeatures;

	// RETC_039

	@FindBy(xpath = "//div[contains(text(),'Posts')]")
	public WebElement Posts;
	@FindBy(xpath = "//li[@id='menu-posts']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Categories')]")

	public WebElement Categories;
	@FindBy(xpath = "//*[@id='submit']")
	public WebElement AddNewCatergory;
	@FindBy(linkText = "All Posts")
	public WebElement AllPosts;
	@FindBy(xpath = "//a[@class='page-title-action']")
	//// tr[@id='post-7686']//a[@class='row-title'][contains(text(),'New Launches')]
	public WebElement Addnew;
	@FindBy(id = "title")
	public WebElement titlebox;
	@FindBy(xpath = "//textarea[@id='content']")
	public WebElement content;
	@FindBy(id = "in-category-717")
	public WebElement category_Checkbox;
	@FindBy(id = "publish")
	public WebElement publish;
	@FindBy(xpath = "//a[contains(text(),'View post')]")
	public WebElement Viewpost;
//	@FindBy(xpath="//span[@id='sample-permalink")
//	public WebElement Viewpost;
	@FindBy(xpath = "//h2[contains(text(),'Blog')]")
	public WebElement blog;

	// RETC_046

	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	public WebElement properties;
	@FindBy(xpath = "//input[@id='in-property_feature-560']")
	public WebElement Featurecheckbox;
	@FindBy(xpath = "//input[@id='in-region-558']")
	public WebElement Regioncheckbox;

	// RETC_047

	@FindBy(xpath = "//ul[@class='wp-submenu wp-submenu-wrap']//a[contains(text(),'Features')]")
	public WebElement Feature;
	@FindBy(xpath = "//select[@id='parent']")
	public WebElement ParentFeature;

	// Complex
	// RETC_76

	@FindBy(xpath = "//div[contains(text(),'Users')]")
	public WebElement Users;
	@FindBy(xpath = "//li[@id='menu-users']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	public WebElement Users_Addnew;

	@FindBy(id = "user_login")
	public WebElement User_name;
	@FindBy(id = "email")
	public WebElement User_email;
	@FindBy(id = "first_name")
	public WebElement User_first_name;
	@FindBy(id = "last_name")
	public WebElement User_last_name;
	@FindBy(id = "url")
	public WebElement User_url;
	@FindBy(xpath = "//button[contains(@class,'button wp-generate-pw hide-if-no-js')]")
	public WebElement User_showPassword;
	@FindBy(xpath = "//span[contains(text(),'Hide')]")
	public WebElement User_Hide;
	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	public WebElement User_Cancel;
	@FindBy(id = "pass1-text")
	public WebElement User_PasswordText;
	@FindBy(xpath = "//select[@id='role']")
	public WebElement User_role;
	@FindBy(id = "createusersub")
	public WebElement AddNewUser;
	@FindBy(xpath = "//a[contains(text(),'Edit user')]")
	public WebElement CreatedNewUser;
    @FindBy(xpath = "//p[contains(text(),': This username is already registered. Please choo')]")
	public WebElement UserName_Error;
    @FindBy(xpath = "//p[contains(text(),': This email is already registered, please choose')]")
	public WebElement Email_Error;
    
    
    
	// RETC_80

	@FindBy(id = "_price")
	public WebElement Price;
	@FindBy(xpath = "//input[@id='_price_per']")
	public WebElement Price_per;
	@FindBy(linkText = "Main Details")
	public WebElement MainDetails;
	@FindBy(id = "_status")
	public WebElement status;
	@FindBy(id = "_location")
	public WebElement location;
	@FindBy(id = "_possession")
	public WebElement possession;
	@FindBy(linkText = "Location")
	public WebElement Location_tab;
	@FindBy(xpath = "//input[@id='_friendly_address']")
	public WebElement Address;
	@FindBy(xpath = "//input[@id='_address']")
	public WebElement MapAddress;
	@FindBy(xpath = "//input[@id='_geolocation_lat']")
	public WebElement latitude;
	@FindBy(xpath = "//input[@id='_geolocation_long']")
	public WebElement Longitude;
	@FindBy(linkText = "Details")
	public WebElement Details_tab;
	@FindBy(xpath = "//input[@id='_storage_room']")
	public WebElement Storage;
	@FindBy(xpath = "//*[@class='categorychecklist-holder']//following-sibling::span[contains(text(),'Central Bangalore')]")
	public WebElement Checkbox1;
	@FindBy(xpath = "//img[contains(@class,'avatar avatar-26 photo')]")
	public WebElement logouticon;
	@FindBy(xpath = "//a[contains(@class,'ab-item')][contains(text(),'Log Out')]")
	public WebElement Logout;
	@FindBy(xpath = "//a[contains(text(),'Real Estate')]")
	public WebElement RealEstate;

	//

	public void clickPlots() {
		plots.click();

	}

	public void enterAddress() {
		addTextBox.click();
		addTextBox.sendKeys("Electronic City");
	}

	public void dropDownDisplay() {
		propertyTyp.click();
		System.out.println("propertyTyp clicked ");
		List<WebElement> options = driver.findElements(By.xpath("//*[@id='_property_type_chosen']/div/ul/li"));
		for (WebElement we : options) {
			System.out.println(we.getText());
		}
		System.out.println("Dropdown values printed  ");
		options.get(3).click();
		System.out.println("plots selected ");

	}

	public void selectAnyRegionDropdown() {
		anyRegion.click();
		List<WebElement> dropdownoptions = driver
				.findElements(By.xpath("//*[@id='realteo-search-form']/div[2]/div[2]/div/div/ul/li"));
		for (WebElement we : dropdownoptions) {
			System.out.println(we.getText());
		}
		System.out.println("Dropdown values printed  ");
		dropdownoptions.get(6).click();
		System.out.println("Centarl selected ");

	}

	public void clickSearch() {
		Search.click();
	}

	public void realEstateLogin() throws InterruptedException {
		LogIn.click();
		System.out.println("Login clicked");
		Username.sendKeys("admin");
		System.out.println("entred username");
		Password.sendKeys("admin@123");

		System.out.println("entred Password");
	}

	public void Signin() throws InterruptedException {
		Send.click();
		System.out.println("Logged In");

	}

	public void changeRole() throws InterruptedException {
		users.click();
		Username_checkbox.click();
		WebElement testDropDown = Newrole;
		Select dropdown = new Select(testDropDown);
		dropdown.selectByVisibleText("Agent");
		Change.click();
		System.out.println(ChangeroleMessage.getText());

		Thread.sleep(2000);
	}

	public void properties() throws InterruptedException {

		System.out.println("Login clicked");
		Properties.click();
		Features.click();
		Thread.sleep(3000);
		Name.sendKeys("New Launches");
		slug.sendKeys("launch");
		description.sendKeys("New Launches of vilas, apartments, flats");
		Newfeature.click();
		Thread.sleep(3000);

	}

	public void plots() throws InterruptedException {

		System.out.println("Login clicked");
		Properties.click();
	}

}
