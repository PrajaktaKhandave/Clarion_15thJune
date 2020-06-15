package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.propmisespages.HomePage;
import com.propmisespages.LoginPage;
import com.propmisespages.PromisesPage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Promises_TestCases {
	public  WebDriver driver=null;
	public Logger log=Logger.getLogger(Promises_TestCases.class);
	public Properties proobj=null;
	LoginPage loginpage;
	HomePage homePage;
	PromisesPage promisespage;
	@BeforeSuite
	public void setupbeofeSuite()
	{
		try
		{
			FileInputStream fis=new FileInputStream("Properties/configProperties.properties");
			 proobj=new Properties();
			 proobj.load(fis);
			log.info("Property file loaded");
			System.out.println("loaded");
			Assert.assertTrue(true);
			
		}catch(Exception e)
		{
			log.error("Got Exception : "+e);
			Assert.assertTrue(false);
		}
	}
	@BeforeClass
	public void setup()
	{
		try
		{
			
			log.info("Lunching Clarion Promises");
			System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver.exe"); //illegalstateException
			System.out.println("setup driver");
			driver=new ChromeDriver();
			loginpage=new LoginPage(driver,proobj);
			homePage=new HomePage(driver);
			promisespage=new PromisesPage(driver);
			driver.get(proobj.getProperty("url"));
			System.out.println("URL :"+proobj.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			log.info("Application is luanch");
		
		}
		catch(Exception e) {
			log.error("Got Exception : "+e);
			System.out.println("Exception : "+e);
			Assert.assertTrue(false);
		}	
		
	}

	@Test(priority=1)
	public void verifyAuthentication()
	{
		System.out.println("Test 1: Authentication message with fields are blank");
		Assert.assertTrue(loginpage.verifyAuthentication());
	}
	@Test(priority=2)
	public void login()
	{
		System.out.println("Test 2: Verify that User should able to login with valid credentials");
		Assert.assertTrue(loginpage.verfiyLogin());
	}
	@Test(priority=3,dependsOnMethods="login")
	public void addPromise()
	{
		System.out.println("Test 3: Verify that User should able to add Prmise");
		Assert.assertTrue(homePage.addPromise());
	}
	@Test(priority=4)
	public void searchPromise()
	{
		System.out.println("Test 4: Verify that User should able to search added Prmise");
		Assert.assertTrue(promisespage.searchPromise());
	}
	@Test(priority=5)
	public void logout()
	{
		System.out.println("Test 5: Verify that User should able to logout");
		Assert.assertTrue(promisespage.logout());
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
}
