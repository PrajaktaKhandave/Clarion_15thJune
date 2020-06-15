package com.propmisespages;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePageObject {
	private WebDriver driver;
	Properties proobj;
	
	@FindBy(xpath="//input[@type='Submit']")
	WebElement loginbutton;
	@FindBy(xpath="//*[text()='Invalid Username/password']")
	WebElement invalidUNPWD;
	@FindBy(xpath="//input[@name='txtUsername']")
	WebElement username;
	@FindBy(xpath="//input[@name='txtPassword']")
	WebElement password;
	@FindBy(xpath="//*[text()='HOME']")
	WebElement home;
	
	
	
	public LoginPage(WebDriver driver, Properties proobj) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		this.proobj=proobj;
		PageFactory.initElements(driver,this);
		
	}


	public boolean verifyAuthentication()
	{
		try

		{
			System.out.println("started test case");
			waitUntilVisibility(loginbutton);
			clickAtElement(loginbutton);
			Assert.assertEquals(invalidUNPWD.getText(), "Invalid Username/password","No test after clicking login button");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Got Exception : "+e);
			return false;
		}
		
	}
	public boolean verfiyLogin()
	{
		try
		{
			
			username.sendKeys(proobj.getProperty("username"));
			password.sendKeys(proobj.getProperty("password"));
			
			clickAtElement(loginbutton);
			waitUntilPageIsLoaded();
			
			if(home.isDisplayed())
			{
				System.out.println("Login Successfull");
			return true;
			}
			else
			{
				System.out.println("Login is not Successfull");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Got Exception : "+e);
			return false;
		}
	}

	
}
