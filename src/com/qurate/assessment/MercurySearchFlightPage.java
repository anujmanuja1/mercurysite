package com.qurate.assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MercurySearchFlightPage {
	WebDriver driver;
	Select oSelect;
	
	public By departFrom = By.name("fromPort");
	public By arriveIn = By.name("toPort");
	public By serviceClass = By.xpath("//input[@name='servClass'][2]");
	public By btnContinue = By.name("findFlights");
	//public By loginButton = By.name("login");
	
	
	public MercurySearchFlightPage(WebDriver driver) {
		this.driver = driver;
	}
	

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getDepartDdValues() {
		return driver.findElement(departFrom).getText();
	}
	
	public void setDepartFrom (String value) {
		oSelect = new Select (driver.findElement(departFrom));
		oSelect.selectByValue(value);
	}
	
	public void setArriveIn(String value) {
		oSelect = new Select (driver.findElement(arriveIn));
		oSelect.selectByValue(value);
	}
	
	public void setEconomyClass () {
		driver.findElement(serviceClass).click();
	}
	
	public void submitContinue() {
		driver.findElement(btnContinue).click();
	}
	
	
}
