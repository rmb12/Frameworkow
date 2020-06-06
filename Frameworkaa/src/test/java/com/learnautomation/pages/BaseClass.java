package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	
	 public WebDriver driver;
	 public ExcelDataProvider excel;
	 public ConfigDataProvider config;
	 public ExtentReports report;
	 public ExtentTest logger;
	 
	 @BeforeSuite
	 public void setupSuite()
	 {
		Reporter.log("Setting up reports and test started", true); //this is for just debug purpose
	 excel=new ExcelDataProvider();
	 config=new ConfigDataProvider();
	 
	 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
	 report=new ExtentReports();
	 report.attachReporter(extent);
	 Reporter.log("Setting done and test started", true);
	 }
	 
	@BeforeClass
	public void setup()
	{
		Reporter.log("trying to start browser and getting application ready", true);
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
		Reporter.log("Browser and application up and running", true);
	}

	@AfterClass	
public void tearDown()
{
	BrowserFactory.quitBrowser(driver);
}
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.captureScreenshot(driver);
			logger.fail("Test Failed" ,MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			//Helper.captureScreenshot(driver);
			logger.pass("Test Passed" ,MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();
		Reporter.log("tests completed>>>reports generated"+ "36", true);
	}	
}
