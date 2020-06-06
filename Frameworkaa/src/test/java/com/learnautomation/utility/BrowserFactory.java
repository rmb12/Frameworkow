package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			

		} else if (browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			//driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			//driver = new ChromeDriver();

		} else {
			System.out.println("we dont support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		return driver;
	}

	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
}
