package com.marriott.uistore;

import org.openqa.selenium.By;

public class HomepageUI {

	public static By ourBrand = By.partialLinkText("Our Brands");
	public static By jwMarriott = By.partialLinkText("JW Marriott");;
	public static By searchBox = By.name("destinationAddress.destination");
	public static By findHotelsButton = By.cssSelector("button[class='submit']");
	public static By memberBenefits = By.xpath("//a[@href='/loyalty/member-benefits.mi']");
	
	
}
