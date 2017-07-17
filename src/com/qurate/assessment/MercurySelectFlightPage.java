package com.qurate.assessment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MercurySelectFlightPage {
	WebDriver driver;
	//Select oSelect;
	
//	public By bckColorFlight = By.xpath("//font[contains(text(),'FLIGHT')]/parent::td[@bgcolor='#003399']");
	public By tableHeader=By.xpath("//td[@class='frame_header_info']");
	public By tablePrice = By.xpath("//b[contains(text(),'Price')]");
	
	
	public MercurySelectFlightPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getHeaderColor() {
		return driver.findElement(tableHeader).getAttribute("bgcolor");
	}
	
	public void validateSortingbyPrice() {
		List<WebElement> priceTxt = driver.findElements(tablePrice);	
		for (WebElement obs : priceTxt)
		{
			int ii=0;
			String PriceValue=obs.getText();

			String parts=PriceValue.substring(8);

			int value=Integer.parseInt(parts);
		//a[ii]=value;

			ii=ii+1;

		}		
//		for(j = 0; j < 3; j ++);{
//
//			if (a[j] < a[j+1]) {
//				sort= true;
//
//			} 
//			else
//			{
//				sort=false;
//			}
//		}

//		Assert.assertEquals(sort, true);
	}

}
