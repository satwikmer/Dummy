package com.demowebshop.pages;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demowebshop.commons.*;
import com.demowebshop.commons.*;

public class CheckOutPage {
	// Using FindBy for locating elements
	
	@FindBy(xpath="//select[@id='billing-address-select']")
	private WebElement SelectBillingAdd_Dropdown;
	
	@FindBy(xpath="//select[@id='shipping-address-select']")
	private WebElement SelectShippingAdd_Dropdown;
	
	@FindBy(xpath="//p[text()='You will pay by COD']")
	private WebElement You_will_pay_by_COD_Msg;
	
	@FindBy(xpath="//input[@value='Next Day Air___Shipping.FixedRate']")
	private WebElement NextDayAir_Radio_btn;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement BillingAdd_Continue_btn;
	
	@FindBy(xpath="//div[@id='shipping-buttons-container']//input[@value='Continue']")
	private WebElement ShippingAdd_Continue_btn;
	
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']//input[@value='Continue']")
	private WebElement ShippingMethod_Continue_btn;
	
	@FindBy(xpath="//div[@id='payment-method-buttons-container']//input[@value='Continue']")
	private WebElement PaymentMethod_Continue_btn;
	
	@FindBy(xpath="//div[@id='payment-info-buttons-container']//input[@value='Continue']")
	private WebElement PaymentInfo_Continue_btn;
	
	@FindBy(xpath="//input[@value='Confirm']")
	private WebElement Confirm_btn;
	
	@FindBy(xpath="//div[@class='page checkout-page']")
	private WebElement ConfirmationMessage;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	private WebElement LogOut;
	
	@FindBy(xpath="//*[text()='Your order has been successfully processed!']")
	private WebElement OrderConfirmationMsg;
	
	// Defining all the user actions (Methods) on Checkout page
    
	
	

	public CheckOutPage(){
		PageFactory.initElements(SuperPage.driver, this);
	}
	// This method is to set select Billing Address from dropdown
	public void selectBillingAddress() throws Exception {
		if(SelectBillingAdd_Dropdown.isDisplayed())
		{
		Select select=new Select(SelectBillingAdd_Dropdown);		
		select.selectByIndex(2);
		BillingAdd_Continue_btn.click();
		}
	}
	// This method is to set select Shipping Address from dropdown
	public void selectshippingAddress() throws Exception {
		Select select=new Select(SelectShippingAdd_Dropdown);		
		select.selectByIndex(2);
		ShippingAdd_Continue_btn.click();
	
      }
	// This method is to set select Shipping method
	public void selectshippingMethod() throws Exception 
	{
		NextDayAir_Radio_btn.click();
		ShippingMethod_Continue_btn.click();
		
		
	}
	// This method is to set payment Method
	public void PaymentMethod() throws Exception 
	{
		PaymentMethod_Continue_btn.click();
		PaymentInfo_Continue_btn.click();
		Confirm_btn.click();
		
				
		
	}
	
	// This method is to verify the thank you message on order confirmation page
	public void VerifyOrderPlacedMsg()
	{
		assertTrue(OrderConfirmationMsg.isDisplayed());
		BillingAdd_Continue_btn.click();
	}
	
	// This method is to logOut
	public void ClickOnLogOut()
	{
		LogOut.click();
     }
	}