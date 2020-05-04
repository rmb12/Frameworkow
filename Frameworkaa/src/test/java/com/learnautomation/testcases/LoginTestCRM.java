package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.pages.BaseClass;

public class LoginTestCRM extends BaseClass {
	
	
	@Test
	public void loginApp()
	{
		
		//driver=BrowserFactory.startApplication(driver, "chrome", "https://classic.crmpro.com/index.cfm");
		//System.out.println(driver.getTitle());
		logger=report.createTest("Login To CRM");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("starting Application");
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		logger.pass("Login sucess");
		//BrowserFactory.quitBrowser(driver);
	}

}
