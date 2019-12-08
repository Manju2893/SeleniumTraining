package com.training.realestate;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	//RETC_010
	
	@FindBy(id="/html/body/div[1]/header/div[2]/nav/div/ul/li[2]/a")
	private WebElement NewLaunch;
	@FindBy(xpath="//*[@id='wrapper']/div[3]/div[2]/div/div/div[2]/div/div[2]/div/a/div[2]/ul/li[1]/span")
	private WebElement NewLaunch1;
	@FindBy(name="your-name")
	private WebElement Name;
	@FindBy(name="your-email")
	private WebElement Email;
	@FindBy(name="your-subject")
	private WebElement Subject;
	@FindBy(name="your-message")
	private WebElement Message;
	
	
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
	@FindBy(xpath="//*[@id='tab1']/form/p[4]")
	private WebElement lostPassword;
	@FindBy(id="user_login")
	private WebElement EmailAddress;
	@FindBy(xpath="//*[@value='Reset Password']")
	private WebElement ResetPassword;
	
	
	
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
		
		Thread.sleep(5000);
		System.out.println("Title"+driver.getTitle());
		
	}
	
	public void newLaunch() throws InterruptedException
	{
		NewLaunch.click();
		
		System.out.println("Clicked newlaunch");
		NewLaunch1.click();
		Thread.sleep(2000);
		System.out.println("Clicked newlaunch1");
	}
	
	public void contactForm() {
		Name.sendKeys("reva");
		Email.sendKeys("revasharma@gmail.com");
		Subject.sendKeys("apartments");
		Message.sendKeys("looking for an apartments");
		Send.click();
		
		
	}
	
	public void recoverPassword() throws InterruptedException
	{
		LogIn.click();
		lostPassword.click();
		Thread.sleep(2000);
		EmailAddress.sendKeys("revasharma@gmail.com");
		ResetPassword.click();
	}

	
	
}
