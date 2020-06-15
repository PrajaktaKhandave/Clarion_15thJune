package com.propmisespages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;

public class HomePage extends BasePageObject{
	
	WebDriver driver;
	@FindBy(xpath="//select[@name='cboEmp']")
	WebElement selectpromis;
	@FindBy(xpath="//textarea[@id='txtPromise']")
	WebElement promiseare;
	@FindBy(id="btnSubmit")
	WebElement logpromise;
		
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public boolean addPromise()
	{
		try
		{
			driver.findElement(By.linkText("Log Promise")).click();
			waitUntilPageIsLoaded();
			Select promisdd=new Select(selectpromis);
			promisdd.selectByVisibleText("Sonali test");
			waitUntilPageIsLoaded();
			
			promiseare.sendKeys("test 19994934");
		
			clickAtElement(logpromise);
			System.out.println("Promisse added");
			waitUntilPageIsLoaded();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Got Exception : "+e);
			return false;
		}
		
	}

}
