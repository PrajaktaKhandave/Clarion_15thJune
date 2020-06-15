package com.propmisespages;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	
	Logger log;
	Properties proobj;
	WebDriverWait wait;
	private WebDriver driver;
	
	public BasePageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void waitUntilPageIsLoaded()
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void waitUntilVisibility(WebElement element)
	{
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void clickAtElement(WebElement element)
	{
		try
		{
			element.click();
			waitUntilPageIsLoaded();
		}
		catch(Exception e)
		{
			
		}
	}
}
