/**
 * @author Prachi
 *
 */
package com.demowebshop.userscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.ShppingCartPage;
import com.demowebshop.commons.ExcelLibClass;
import com.demowebshop.commons.SuperPage;
import com.demowebshop.pages.CheckOutPage;


public class BuyComputerAndCheckout extends SuperPage
{
	
	
	@Test(priority=0)                //priority 0 means this test will run first
	public void LoginTodemowebshop() throws Exception {
		
		String UsernameValue=ExcelLibClass.readXlsData("Sheet1", 1, 1);  //get username
		String PasswordValue =ExcelLibClass.readXlsData("Sheet1", 1, 2); //get password
		LoginPage loginpage=new LoginPage();                             //create object of LoginPage where all xpaths and methods of login page are stored
		loginpage.ClickOnLogin();                                        //click on login
		loginpage.EnterLoginCredentials(UsernameValue, PasswordValue);   //enter username password and click on log in
		
		//Login to N11 with first row of the login data
      	
		assertEquals(loginpage.VerifyUsername(), ExcelLibClass.readXlsData("Sheet1", 1,1)); //verify if username displayed on homepage	
		loginpage.ClickOnShoppingCart();                                                    //click on shopping cart and delete all items 
		
	}	
	
	@Test(priority=1)                 //priority 1 means this test will run Second
	public void AddComputerToShoppingCart() throws Exception 
	
	{
		HomePage homepage=new HomePage();         //create object of HomePage where all xpaths and methods of home page are stored
		homepage.MouseHoverOnCopmuterMenu();      //hover on computer menu and click on desktop submenu    
		homepage.AddDesktopToCart(); 			//Add desktop to cart and click on shopping cart
	}
		
     
	@Test(priority=2)
	public void ShoppingCartPage() throws Exception 
	{
		ShppingCartPage shoppingcartpage= new ShppingCartPage(); //create object of ShoppingCart page where all xpaths and methods of Shopping cart page are stored
		shoppingcartpage.ClickOnShoppingCart();             //click on shopping cart
		shoppingcartpage.ClickOntermsofservice();           //click on term of service checkbox
		shoppingcartpage.ClickOnCheckout();                 //click on checkout button
		
	}
	@Test(priority=3)
	public void CheckOutPage() throws Exception 
	{
		CheckOutPage checkoutpage= new CheckOutPage(); //create object of Checkout page where all xpaths and methods of Checkout page are stored
		checkoutpage.selectBillingAddress();         //If "Select a billing address from your address book or enter a new address" exists, select “New Address” From the drop down,
		checkoutpage.selectshippingAddress();       //Select the “Shipping Address” as same as “Billing Address” from “Shipping Address” drop down and click on “Continue”.
		checkoutpage.selectshippingMethod();        //Select the shipping method as “Next Day Air” and click on “Continue”
		checkoutpage.PaymentMethod();               //Choose the payment method as COD (Cash on delivery) and click on “Continue” Validate the message “You will pay by COD” and click on “Continue”
		checkoutpage.VerifyOrderPlacedMsg();        //Verify the order confirmation message on the page
		checkoutpage.ClickOnLogOut();               //logout
		
		
	}
	
	
}
