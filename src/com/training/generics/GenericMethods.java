package com.training.generics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Naveen
 * @see this class will help when you want to do custom business logic, since in
 *      POM we dont do dynamic elements available, when you want to iterate the
 *      table/accordion etc
 * @since 17-Dec-2018
 */
public class GenericMethods {
	WebDriver driver;

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 
	 * @param locator
	 * @param type
	 * @see type is id, name, xpath, text, partialtext
	 * @see locator will be the element to be found on DOM
	 * @return WebElement this method shall give provided it has single enty in the
	 *         DOM
	 */
	public WebElement getElement(String locator, String type) {
		WebElement element = null;
		type = type.toLowerCase();

		if (type.equals("id")) {
			element = driver.findElement(By.id(locator));
		} else if (type.equals("css")) {
			element = driver.findElement(By.cssSelector(locator));
		} else if (type.equals("name")) {
			element = driver.findElement(By.name(locator));
		} else if (type.equals("xpath")) {
			element = driver.findElement(By.xpath(locator));
		}
		if (checkSingleEntry(locator, type)) {
			System.out.println("Element Found and Returned");
			return element;
		}
		System.out.println("Sorry Element not found, so not returned...");
		return null;

	}

	// shall give if it has multiple entries as a list in DOM

	public List<WebElement> getElementsAsList(String locator, String type) {
		type = type.toLowerCase();
		if (type.equals("id")) {
			return driver.findElements(By.id(locator));
		} else if (type.equals("name")) {
			return driver.findElements(By.name(locator));
		} else if (type.equals("xpath")) {
			return driver.findElements(By.xpath(locator));
		} else if (type.equals("class")) {
			return driver.findElements(By.className(locator));
		} // other TODO
		return null;
	}

	// return true if element exists
	// this method works for us when we have more than 1 element
	// to be found for
	public boolean isElementFound(String locator, String type) {
		return getElementsAsList(locator, type).size() > 0;
	}

	// this method gives true only where there is an single entry
	// in the DOM
	public boolean checkSingleEntry(String locator, String type) {
		return getElementsAsList(locator, type).size() == 1;
	}

	// generic methods to RealEstate

	// To sendkeys

	public void sendKeys(WebElement we, String value) {
		we.click();
		we.sendKeys(value);
	}

	// To click
	public void clickToElement(WebElement we) {
		we.click();
	}


	public void jseClick(WebDriver driver, WebElement we) {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", we);
	}

	public void mouseAction(WebDriver driver, WebElement we) {

		Actions builder = new Actions(driver);
		builder.moveToElement(we).click(we);
		builder.perform();
		System.out.println("Done Mouse hover on 'Music' from Menu");

	}

	public void scrollUpAction() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(500,0)");
		System.out.println("window.scrollBy");
	}

	public void scrollDownAction() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		System.out.println("window.scrollBy");
	}

	// dropdown

	public void drodown(WebElement we, String s) {
		Select dropdown = new Select(we);
		dropdown.selectByVisibleText(s);
		we.click();
		System.out.println("Dropdown selected");
	}
}