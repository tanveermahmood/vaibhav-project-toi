package com.timesofindia.test;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.timesofindia.pages.TimesOfIndiaHomePage;
import com.timesofindia.pages.TimesOfIndiaTopStoriesNewsPage;
import com.timesofindia.utility.WebUtility;

public class TimesOfIndiaHomeTestPage extends WebDriverTestCase {
	TimesOfIndiaHomePage homePage = new TimesOfIndiaHomePage();
	TimesOfIndiaTopStoriesNewsPage topStoriesPage = new TimesOfIndiaTopStoriesNewsPage();
	WebUtility commonMethods = new WebUtility();

/* Web*/
	@Test
//	@Parameters({"browsername" })
	public void HomePage() throws Throwable {
//		WebDriver driver=commonMethods.openBrowser(browsername);
		homePage.launchPage(null);
		homePage.verifyPage();
		homePage.clickOnNotNowBtn();
		topStoriesPage.verifyTopNewsStories();
		topStoriesPage.switchNewTopStories();
	}	
	
}
