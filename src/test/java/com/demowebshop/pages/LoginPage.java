package com.demowebshop.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.commons.*;
import com.demowebshop.commons.*;

public class LoginPage {
	
	@FindBy(xpath="//a[text()='Log in']")
	private WebElement LogIn;
	
	@FindBy(id="Email")
	private WebElement Username;
	
	@FindBy(id="Password")
	private WebElement Password;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement LogIn_btn;
	
	@FindBy(xpath="//div[@class='header-links']//a[@class='account']")
	private WebElement User_acc_ID;
	
	@FindBy(xpath="//div[@class='header-links']//span[text()='Shopping cart']")
	private WebElement Shopping_cart;
	
	@FindBy(xpath="//td[@class='qty nobr']//input")
	private WebElement Qty_Enter;
	
	@FindBy(xpath="//input[@name='updatecart']")
	private WebElement Update_Cart;
	
	public LoginPage(){
		PageFactory.initElements(SuperPage.driver, this);
	}
	// Defining all the user actions (Methods) on login page
	// This method is to click on login
	public void ClickOnLogin()
	{
		LogIn.click();
     }
	public void EnterLoginCredentials(String UsernameValue, String PasswordValue)
	{
		
		//Enter Username(Email)
		Username.sendKeys(UsernameValue);
        //Enter Password
		Password.sendKeys(PasswordValue);
        //Click Login Button
        LogIn_btn.click();
	}
	//On homepage there should be username in left corner
	public String VerifyUsername()
	{
		return User_acc_ID.getText();     
		 
	}
	public void ClickOnShoppingCart()
	{
		Shopping_cart.click();  //click on shopping cart
		Qty_Enter.clear();      //Delete all items in shopping cart by changing quantity value to zero
		Qty_Enter.sendKeys("0");
		Update_Cart.click();
		
     }
	
}
	
	
