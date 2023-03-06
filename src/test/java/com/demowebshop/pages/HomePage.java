package com.demowebshop.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.commons.*;

public class HomePage {
	
	@FindBy(xpath="//ul[@class='top-menu']//li//a[contains(@href, '/desktops')]")
	private WebElement DesktopSubMenu;
	
	@FindBy(xpath="//img[@alt='Picture of Build your own cheap computer']")
	private WebElement SelectComputer;
	
	@FindBy(id="add-to-cart-button-72")
	private WebElement AddToCart_Btn;
	
	@FindBy(xpath="//input[@id='addtocart_72_EnteredQuantity']")
	private WebElement QuantityOfComp;
	
	@FindBy(xpath="//div[@class='add-to-cart-panel']//input[@class='qty-input']")
	private WebElement QtyTextbox;
	

	@FindBy(xpath="//*[@class='top-menu']//a[contains(text(),'Computers')]")
	private WebElement ComputerMenu;
	
	@FindBy(name="//div[@class='header-links']//span[text()='Shopping cart']")
	private WebElement shopping_cart;
	
	
	
	
	public HomePage(){
		PageFactory.initElements(SuperPage.driver, this);
	}
	// Defining all the user actions (Methods) on home page
		// This method is to Hover on computer Menu
	public void MouseHoverOnCopmuterMenu() throws Exception
	{
		Actions act=new Actions(SuperPage.driver);
		act.moveToElement(ComputerMenu).build().perform();
		Thread.sleep(2000);
		
     }
	// This method is to add desktop to shopping cart
	public void AddDesktopToCart()
	{
		DesktopSubMenu.click();           //click on desktop submenu
		SelectComputer.click();              //select first desktop
		
		JavascriptExecutor js=(JavascriptExecutor) SuperPage.driver; 			//to interact with javascript element and scroll down
		js.executeScript("scroll(0, 350);"); js.executeScript("scroll(0, 350);"); //scroll to the y-axis mentioned
		 
		
		//SuperPage.driver.
		QtyTextbox.click();      //to click on quantity textbox
		QtyTextbox.clear();
		QtyTextbox.sendKeys("2");
		AddToCart_Btn.click();   //click on add to cart
		
	}
	

}
