package com.qurate.assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class BaseSetUp {
public static WebDriver driver;
	
		
	@Parameters({"browsername", "appURL" }) 
	@BeforeTest
	public static void InvokeAppInBrowser(String browsername, String appURL) throws InterruptedException{
		System.out.println("Inside InvokeAppInBrowser");
//		String appURL = "http://newtours.demoaut.com/";
		switch(browsername){
			case "IE":
				System.out.println("Internet Explorer browser has been invoked");
				System.setProperty("webdriver.ie.driver","C:/SeleniumProjects/IEDriverServer_Win32_2.53.1/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "FF":
				System.out.println("FF browser has been invoked");
				driver = new FirefoxDriver();
				break;
			case "CH":
				System.out.println("Chrome browser has been invoked");
				System.setProperty("webdriver.chrome.driver", "C:/SeleniumProjects/chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
				break;
		}	
		driver.manage().window().maximize();
		
		driver.get(appURL);
		System.out.println("URL : " + appURL + " - opened successfully");
	}
	
	@AfterTest
	public static void closeApplication()
	{
		System.out.println("Inside closeApplication");
		driver.quit();
	}
	
}
