package com.learnautomation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		//we can write it in two ways.
		this.driver=ldriver;
		//driver=ldriver;
	}
	//@FindBy(name="username") WebElement uname;
	@FindBy(id="Email") WebElement uname;
	@FindBy(name="Password") WebElement pass;
	
	//@FindBy(xpath="//input[@value='Login']") WebElement loginButton;
	@FindBy(xpath="//input[@value='Log in']") WebElement loginButton;
	
	public void loginToCRM(String usernameApplication,String passwordApplication)
	{
		uname.clear();
		uname.sendKeys(usernameApplication);
		pass.clear();
		pass.sendKeys(passwordApplication);
		
		loginButton.submit();
		
	}
	
	
	}


