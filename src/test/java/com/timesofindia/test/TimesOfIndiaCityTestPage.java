package com.timesofindia.test;

import org.testng.annotations.Test;

import com.timesofindia.pages.TimesOfIndiaCityPage;
import com.timesofindia.pages.TimesOfIndiaHomePage;

public class TimesOfIndiaCityTestPage {
	@Test
	public void cityPage() throws Throwable {
		TimesOfIndiaHomePage homePage = new TimesOfIndiaHomePage();
		TimesOfIndiaCityPage cityPage=new TimesOfIndiaCityPage();
		homePage.launchPage(null);
		homePage.navigateToHomePage();
		homePage.verifyPage();
		cityPage.clickOnHeaderOptionAndSelectSubOption("City", "Pune");
		cityPage.verifyothercitipage();
		cityPage.getReadNewsAndTime();
		cityPage.verifyReadOption();
		cityPage.clickOnCommentedTab();
		cityPage.clickOnMostPopularNews();
		cityPage.clickOnPast24hrsNews();
		cityPage.clickOnSharedTabAndClickMostpopularNews();	
		cityPage.clickOnPast4Days();
		cityPage.clickOnEntireWebSite();
		cityPage.clickOnCommentedAndEntireWebsite();
		cityPage.clickOnSharedAndEntireWebsite();

	}

}
