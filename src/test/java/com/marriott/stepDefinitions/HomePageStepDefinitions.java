package com.marriott.stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.marriott.pageobjects.Homepage;
import com.marriott.reusablecomponents.ReusableComponents;
import com.marriott.reusablecomponents.ReusableMethods;
import com.marriott.uistore.HomepageUI;
import com.marriott.uistore.HotelSearchPage;
import com.marriott.uistore.MemberBenefits;
import com.marriott.utilities.ExtentReport;
import com.marriott.utilities.Log;

@RunWith(Cucumber.class)
public class HomePageStepDefinitions {

	private ExtentReports report = ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(HomePageStepDefinitions.class.getName());
	WebDriver driver;

	@Given("^I am on homepage$")
	public void i_am_on_homepage() throws Throwable {
		driver = ReusableComponents.loadDriver();
		ReusableMethods.loadURL(driver);

	}

	@When("^I click on Our Brands$")
	public void i_click_on_Our_Brands() throws Throwable {
		ReusableMethods.click(HomepageUI.ourBrand, driver);

	}

	@Then("^JW Marriott must be listed there$")
	public void jw_Marriott_must_be_listed_there() throws Throwable {
		WebElement jwMarriott = driver.findElement(HomepageUI.jwMarriott);
		assertEquals(jwMarriott.getText(), "JW Marriott");
	}

	@When("^I search for (.+)$")
	public void i_search_for(String city) throws Throwable {
		Homepage.search(driver, city, log);
	}

	@Then("^first hotel in the search result should contain (.+) name$")
	public void first_hotel_in_the_search_result_should_contain_name(String citySearched) throws Throwable {
		String cityResult = driver.findElement(HotelSearchPage.addressBar).getAttribute("data-city");
		assertEquals(citySearched, cityResult);
	}


	@When("^I go to Members Benefits Page$")
	public void i_go_to_Members_Benefits_Page() throws Throwable {
		ReusableMethods.click(HomepageUI.memberBenefits, driver);
	}

	@Then("^Mobile Check-In and Mobile Key must be present there$")
	public void mobile_Check_In_and_Mobile_Key_must_be_present_there() throws Throwable {
		
		List<WebElement> allOptions = driver.findElements(MemberBenefits.mobileCheckInAndKey);
		boolean isFound = false;
	    for ( WebElement we: allOptions) {
	       if(we.getText().contains("Mobile Check-In and Mobile Key")) {
	    	   isFound = true;
	    	   return;
	       }
	       	
	    }
	    assertEquals(true, isFound);
	}
	
	@And("^Close the browser$")
    public void close_the_browser() throws Throwable {
        driver.close();
    }

}
