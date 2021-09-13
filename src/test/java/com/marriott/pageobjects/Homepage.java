package com.marriott.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.marriott.reusablecomponents.ReusableMethods;
import com.marriott.uistore.HomepageUI;

public class Homepage {

	public static boolean search(WebDriver driver, String searchKey, Logger log) {
		if (ReusableMethods.getElement(HomepageUI.searchBox, driver)) {
			log.info("Clicked on searchbox");
			if (ReusableMethods.sendKeys(HomepageUI.searchBox, searchKey, driver)) {
				if (ReusableMethods.sendKeys(HomepageUI.searchBox, Keys.ENTER, driver)) {
					if (ReusableMethods.click(HomepageUI.findHotelsButton, driver)) {
						return true;

					}
				}
			}
		}
		return false;
	}
}
