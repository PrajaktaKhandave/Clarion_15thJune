package com.propmisespages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PromisesPage extends BasePageObject {

	WebDriver driver;
	@FindBy(id="cboEmp")
	WebElement promisor;
	@FindBy(name="btnSearch")
	WebElement searchbtn;
	@FindBy(xpath="//a/b[text()='LOGOUT']")
	WebElement logout;
	@FindBy(xpath="//img[@id='idImg1']")
	WebElement calendaricon;
	@FindBy(xpath="//td[@class='day selected today']")
	WebElement todaysdate;
	public PromisesPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public boolean searchPromise()
	{
		try
		{
			
			Select promisordd=new Select(promisor);
			promisordd.selectByVisibleText("Sonali test");
			calendaricon.click();
			waitUntilPageIsLoaded();
			todaysdate.click();
			waitUntilPageIsLoaded();
			searchbtn.click();
			waitUntilPageIsLoaded();
			
			String fpart="//td[text()'";
			String lpart="']";
			String xpath=fpart+"test 19994934"+lpart;
			WebElement promises=driver.findElement(By.xpath(xpath));
			if(promises.isDisplayed())
			{
				System.out.println("Promise is added and its searched");
				return true;
			}
			else
			{
				System.out.println("Promiss is not searchable");
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Got Exception : "+e);
			return false;
		}
		
	}
	public boolean logout()
	{
		try
		{
			logout.click();
			System.out.println("Logout Sucessfully");
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Got Exception : "+e);
			return false;
		}
	}
}
