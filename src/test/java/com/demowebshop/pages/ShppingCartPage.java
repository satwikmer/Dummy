package com.demowebshop.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.commons.*;


public class ShppingCartPage {
	
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement Checkout;
	
	@FindBy(name="//div[@class='header-links']//span[text()='Shopping cart']")
	private WebElement shopping_cart;
	
	@FindBy(name="removefromcart")
	private WebElement Item_checkbox;
	
	@FindBy(xpath="//input[@id='termsofservice']")
	private WebElement termsofservice;
	
	
	public ShppingCartPage(){
		PageFactory.initElements(SuperPage.driver, this);
	}
	// Defining all the user actions (Methods) on shopping cart page
		// This method is to click on shopping cart
	public void ClickOnShoppingCart() throws Exception
	{
		/*
		 * JavascriptExecutor js=(JavascriptExecutor) SuperPage.driver; //to scroll down
		 * js.executeScript("scroll(0, 350);"); js.executeScript("scroll(0, 350);");
		 */
		
		SuperPage.driver.navigate().refresh();
		//js.executeScript("arguments[0].click()", shopping_cart);
		//Thread.sleep(6000);
		shopping_cart.click();
     }
	public void ClickOntermsofservice()
	{
		termsofservice.click();   //click on term of services checkbox
     }
	public void ClickOnCheckout()  // click on checkout button
	{
		Checkout.click();
     }
	
}
	
