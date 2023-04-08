package com.demowebshop.commons;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners(Listener.class)
public class SuperPage {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentTest test;
	public static ExtentReports reports;
	private static String DRIVER_PATH="./resources/drivers/";      //download drivers and save in this folder path
	private static String TESTING_URL="http://demowebshop.tricentis.com/";    //Enter Url which is statis
	
	@BeforeSuite
	public void setup(){
			
		String browser="chrome";             
		
		if(browser.equalsIgnoreCase("FF")) {        //to instatiate firefox browser
			System.setProperty("webdriver.gecko.driver", DRIVER_PATH+"geckodriver.exe");
			driver=new FirefoxDriver();
			FirefoxProfile profile=new FirefoxProfile();
			profile.setPreference("permissions.default.desktop-notification", 1);
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			
		}else if(browser.equalsIgnoreCase("chrome"))           //to instatiate chrome browser
		{
			System.setProperty("webdriver.chrome.driver", DRIVER_PATH+"chromedriver.exe");
			driver=new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("IE"))                    //to instatiate IE browser
		{
			System.setProperty("webdriver.gecko.driver", DRIVER_PATH+"IEDriverServer.exe");
			driver=new InternetExplorerDriver();	
		}else                                                
		{
			System.out.println("Invalid Browser....");
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(TESTING_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterSuite                                         //this method will run after suite means to last
	public void postAction() {
		driver.close();                                 //It will close all driver instances
		driver.quit();                                  //It will exit all the running tasks of browser
	}
	
	@BeforeTest 
	public void startTest()                           //this method will run before @test
	{
		reports = new ExtentReports("./Reports/ExtentReportResults.html",true);
		reports.loadConfig(new File("./extent-config.xml"));
		test = reports.startTest("ExtentReportOutput");
		
	}
	@AfterTest
	public void endTest()                             //this method will run after @test
	{
		reports.endTest(test);
		reports.flush();
	}
	
	

}
