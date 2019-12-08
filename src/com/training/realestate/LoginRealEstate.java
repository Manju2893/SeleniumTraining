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
	
	@FindBy(xpath ="//*[@id='menu-item-570']/a")
	private WebElement plots;
	@FindBy(id="keyword_search")
	private WebElement addTextBox;
	@FindBy(css="#_property_type_chosen > a")
	private WebElement propertyTyp;
//	@FindBy(xpath="//*[@id='_property_type_chosen']/div/ul/li")
//	private WebElement dropdown;
	@FindBy(xpath="//*[@id='realteo-search-form']/div[2]/div[2]/div/a/div")
	private WebElement anyRegion;
	@FindBy(css="button.button")
	private WebElement Search;
	
	//RETC_011
	
	@FindBy(xpath="//*[@class='sign-in']")
	private WebElement LogIn;
	@FindBy(id="user_login")
	private WebElement Username;
	@FindBy(id="user_pass")
	private WebElement Password;
	@FindBy(className="login")
	private WebElement SignIn;
	@FindBy(xpath="//*[@type='submit']")
	private WebElement Send;
	
	
	//RETC_012
	
	@FindBy(xpath="//*[@class='login']/p[4]/a")
	private WebElement lostPassword;
	@FindBy(id="user_login")
	private WebElement EmailAddress;
	@FindBy(xpath="//*[@value='Reset Password']")
	private WebElement ResetPassword;
	
	//RETC_022
	@FindBy(id="menu-users")
	private WebElement users;
	@FindBy(id="cb-select-all-1")
	private WebElement Username_checkbox;
	@FindBy(id="new_role")
	private WebElement Newrole;
	@FindBy(id="changeit")
	private WebElement Change;
	@FindBy(xpath="//*[@id='wpbody-content']/div[3]/div[3]")
	private WebElement ChangeroleMessage;
	
	public void clickPlots() {
		plots.click(); 
		
	}

	public void enterAddress()
	{
		addTextBox.click();
	    addTextBox.sendKeys("Electronic City");
	}
	
	public void dropDownDisplay()
	{
	   propertyTyp.click();
	   System.out.println("propertyTyp clicked ");
	   List<WebElement> options=driver.findElements(By.xpath("//*[@id='_property_type_chosen']/div/ul/li"));
       for(WebElement we:options)
         {
	        System.out.println(we.getText());
         }
       System.out.println("Dropdown values printed  ");
       options.get(3).click();
       System.out.println("plots selected ");
       
    }
	
	public void selectAnyRegionDropdown()
	{
		 anyRegion.click();
		 List<WebElement> dropdownoptions=driver.findElements(By.xpath("//*[@id='realteo-search-form']/div[2]/div[2]/div/div/ul/li"));
         for(WebElement we:dropdownoptions)
        {
 	     System.out.println(we.getText());
        }
         System.out.println("Dropdown values printed  "); 
         dropdownoptions.get(6).click();
         System.out.println("Centarl selected ");
         
	}
	
	public void clickSearch()
	{
		Search.click();
	}
	
	public void realEstateLogin() throws InterruptedException
	{
		LogIn.click();
		System.out.println("Login clicked");
		Username.sendKeys("admin");
		System.out.println("entred username");
		Password.sendKeys("admin@123");
		
		System.out.println("entred Password");
	}
	public void Signin() throws InterruptedException
	{
		Send.click();
		System.out.println("Logged In");
	
	}
	
	public void recoverPassword() throws InterruptedException
	{
		LogIn.click();
		System.out.println("Login clicked");
		lostPassword.click();
		Thread.sleep(10000);
		System.out.println("LostPassword clicked");
		EmailAddress.sendKeys("manju.lak2806@gmail.com");
		System.out.println("Email Address entred");
		ResetPassword.click();
		Thread.sleep(7000);
	}

	public void changeRole() throws InterruptedException
	{
		users.click();
		Username_checkbox.click();
	    WebElement testDropDown = Newrole;  
	    Select dropdown = new Select(testDropDown); 
	    dropdown.selectByVisibleText("Agent");
	    Change.click();
	    System.out.println(ChangeroleMessage.getText());
		
		Thread.sleep(2000);
	}
}
