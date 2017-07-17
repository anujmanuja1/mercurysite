package com.qurate.assessment;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Mercury_Validations extends BaseSetUp{
	MercuryWelcomePage wlcmpObj;
	MercurySearchFlightPage sfpObj;
	MercurySelectFlightPage selfpObj;
	
	String actualTitle;
	String expTitle;
	
	
	SoftAssert softAssrt = new SoftAssert();

				
	@BeforeClass 
	public void getdriverObject()
	{
		System.out.println("Inside getdriverObject");
		wlcmpObj = new MercuryWelcomePage(driver);
		sfpObj = new MercurySearchFlightPage(driver);
		selfpObj = new MercurySelectFlightPage(driver);
	}
	
	
	@Test (priority=0)
	public void validateDate() {
		//int guru99seleniumlink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i")));
		
		System.out.println("TESTCASE 1: HOMEPAGE- Validating the date");
		
		DateFormat df = new SimpleDateFormat("MMM d, yyyy");
		Date dcurrentDate = new Date();
		String currentDate = df.format(dcurrentDate);
		
		String displayedDate = wlcmpObj.getCurrentDate();
		
		System.out.println("Displayed Date: ["+displayedDate + "]    Actual System Date: [" + currentDate + "]");
		Assert.assertEquals(displayedDate, currentDate);
			
	}

	@Test (priority=1)
	public void validateImage() {
		System.out.println("TESTCASE 2:	Verify that image of Aruba is displayed under featured destination");
		Assert.assertEquals(wlcmpObj.getImage(), true);
		
	}
	
	@Parameters({"incorrectuname1", "incorrectpassword1","incorrectuname2","incorrectuname2" }) 
//	@Test (priority=2)
	public void loginWithInvalidCredentials(String incorrectuname1, String incorrectpassword1,String incorrectuname2, String incorrectpassword2) throws InterruptedException {
		System.out.println("TESTCASE 3: Login With Invalid Credentials");
		wlcmpObj.login(incorrectuname1, incorrectuname1);
		Thread.sleep(4000);
		actualTitle = wlcmpObj.getPageTitle();
		System.out.println(actualTitle);
		expTitle = "Sign-on: Mercury Tours";
		softAssrt.assertEquals(actualTitle, expTitle );
		
					
		wlcmpObj.login(incorrectuname2, incorrectuname2);
		Thread.sleep(4000);
		actualTitle = wlcmpObj.getPageTitle();

		softAssrt.assertEquals(actualTitle, expTitle );
		
		softAssrt.assertAll();
	}
	
	@Parameters({"correctuname", "correctpassword" }) 
	@Test (priority=3)
	public void loginWithValidValues(String correctuname, String correctpassword) {
		System.out.println("TESTCASE 4: Login With Valid Credentials");
		wlcmpObj.login(correctuname, correctpassword);
		actualTitle = sfpObj.getPageTitle();
		expTitle = "Find a Flight: Mercury Tours:";
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expTitle);
		
	}
	
	@Test (priority=4)
	public void validateDropdown() {
		System.out.println("TESTCASE 5: Validate Dropdown values");
		String text = sfpObj.getDepartDdValues();
		String strValue = "India";

		if (text.contains("\n"+ strValue +"\n")){
			System.out.println("Value ["+ strValue+ "] is displayed in Dropdown");
		} else {
			System.out.println("Value ["+ strValue+ "] is not present in Dropdown");
			Assert.assertEquals(false, true);
		}
	}
	
	@Test (priority=5)
	public void searchFlight() throws InterruptedException {
		System.out.println("TESTCASE 6: Search for flight with valid values");
		sfpObj.setDepartFrom("London");
		Thread.sleep(2000);
		sfpObj.setArriveIn("Sydney");
		Thread.sleep(2000);
		sfpObj.setEconomyClass();
		sfpObj.submitContinue();
		Thread.sleep(2000);
		
		
		actualTitle = selfpObj.getPageTitle();
		expTitle = "Select a Flight: Mercury Tours";
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expTitle);
	}
		
	@Test (priority=6)
	
	public void validateColor() {
		System.out.println("TESTCASE 7: Verify that the background color of headers is blue");
		Assert.assertEquals(selfpObj.getHeaderColor(), "#003399");
		selfpObj.validateSortingbyPrice();
		
	}

	

		

}
