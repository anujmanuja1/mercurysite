package com.qurate.assessment;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MercuryWelcomePage {
	WebDriver driver;
	
	public By dtLable = By.xpath("//form[@name = 'home']/table/tbody/tr/td/font/b");
	public By image = By.xpath("//img[contains(@alt,'Featured Destination')]/parent::p/img[contains(@src,'featured_destination.gif')]");
	public By username = By.name("userName");
	public By password = By.name("password");
	public By loginButton = By.name("login");

	
	
	public MercuryWelcomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentDate() {
		return driver.findElement(dtLable).getText();
	}
	
	public boolean getImage() {
		return driver.findElement(image).isEnabled();
	}
	
	public void login (String userName, String passWord) {
		driver.findElement(username).sendKeys(userName);
		driver.findElement(password).sendKeys(passWord);
		driver.findElement(loginButton).click();
	}

}



