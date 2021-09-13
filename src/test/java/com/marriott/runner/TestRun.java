package com.marriott.runner;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.marriott.pageobjects.Homepage;
import com.marriott.reusablecomponents.ReusableComponents;
import com.marriott.reusablecomponents.ReusableMethods;
import com.marriott.stepDefinitions.HomePageStepDefinitions;
import com.marriott.uistore.HomepageUI;
import com.marriott.uistore.HotelSearchPage;
import com.marriott.uistore.MemberBenefits;
import com.marriott.utilities.ExtentReport;
import com.marriott.utilities.Log;
import com.marriott.utilities.PropertyFileReader;

public class TestRun {
	
	private ExtentReports report = ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(HomePageStepDefinitions.class.getName());
	WebDriver driver;

//	@Test
//	void checkjwMarriott() {
//		
//		WebDriver driver = 	ReusableComponents.loadDriver();
//		ReusableMethods.loadURL(driver);
//		ReusableMethods.click(HomepageUI.ourBrand, driver);
//		ReusableMethods.click(HomepageUI.jwMarriott, driver);
//		System.out.println(driver.findElement(HomepageUI.jwMarriott));
//		
//		
//	}
//	
//	@Test
//	void checkjwMarriott2() {
//		
//		WebDriver driver = 	ReusableComponents.loadDriver();
//		ReusableMethods.loadURL(driver);
//		Homepage.search(driver, "Paris", log);
//		
//		System.out.println(driver.findElement(HotelSearchPage.addressBar).getAttribute("data-city"));
//		
//		
//	}
//	
	@Test
	void checkjwMarriott3() {
		
		WebDriver driver = 	ReusableComponents.loadDriver();
		ReusableMethods.loadURL(driver);
		ReusableMethods.click(HomepageUI.memberBenefits, driver);
		
		List<WebElement> allOptions = driver.findElements(MemberBenefits.mobileCheckInAndKey);
	    for ( WebElement we: allOptions) { 
	    	System.out.println(we.getText());
	       if(we.getText().contains("Mobile Check-In and Mobile Key"))
	       { System.out.println(we.getText());
	       	return;}
	    }
		
		
	}
	
}
