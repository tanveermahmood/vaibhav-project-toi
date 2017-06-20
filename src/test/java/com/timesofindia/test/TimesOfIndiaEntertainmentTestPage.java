package com.timesofindia.test;

import org.testng.annotations.Test;

import com.timesofindia.pages.TimesOfIndiaHomePage;
import com.timesofindia.pages.TimesOfIndiaEntertainmentPage;
import com.timesofindia.pages.TimesOfIndiaHindiEntertainmentPage;

public class TimesOfIndiaEntertainmentTestPage {

	TimesOfIndiaHomePage homePage = new TimesOfIndiaHomePage();
	TimesOfIndiaEntertainmentPage entertainmentPage=new TimesOfIndiaEntertainmentPage();
	TimesOfIndiaHindiEntertainmentPage hindiEntertainmentPage=new TimesOfIndiaHindiEntertainmentPage();
	/* Entertainment Page */
	@Test
	public void EntertainmentPage() throws Throwable{
		homePage.launchPage(null);
		homePage.navigateToHomePage();
		homePage.verifyPage();
		entertainmentPage.verifyEntertainmentLink();
		entertainmentPage.getEntertainmentLinkCount();
		entertainmentPage.getCountOfImagesInEntertainmentSection();
		entertainmentPage.verificationOfEntertainmentFromMainMenu();
		entertainmentPage.verifyLanguagesAndLinks();
		hindiEntertainmentPage.clickOnHindi();
		hindiEntertainmentPage.verifyHindiLanguagesNewsPage();
		hindiEntertainmentPage.verifyTradingNow();
		hindiEntertainmentPage.verifyImagesForLanguages();
	}
}
