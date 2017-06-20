package com.timesofindia.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.testng.Assert;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import com.timesofindia.utility.WebUtility;

public class TimesOfIndiaHindiEntertainmentPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	WebUtility webUtility = new WebUtility();

	@FindBy(locator = "entertainment.hindi.languages.news")
	private QAFWebElement entertainmentHindiLanguagesNews;

	@FindBy(locator = "entertainment.hindi.languages.tradingnow")
	private QAFWebElement entertainmenthinditradingnow;

	@FindBy(locator = "entertainment.hindi.languages.trading")
	private List<QAFWebElement> entertainmenthindilanguagestrading;

	@FindBy(locator = "entertainment.hindi.languages.hindientertainment")
	private List<QAFWebElement> entertainmenthindientertainment;

	@FindBy(locator = "entertainment.hindi.languages.hindientertainment.imges")
	private QAFWebElement entertainmenthindilanguagesimges;

	/* getter methods */
	public QAFWebElement getEntertainmentHindiLanguagesNews() {
		return entertainmentHindiLanguagesNews;
	}

	public QAFWebElement getEntertainmenthinditradingnow() {
		return entertainmenthinditradingnow;
	}

	public List<QAFWebElement> getEntertainmenthindilanguagestrading() {
		return entertainmenthindilanguagestrading;
	}

	public List<QAFWebElement> getEntertainmenthindientertainment() {
		return entertainmenthindientertainment;
	}

	public QAFWebElement getEntertainmenthindilanguagesimges() {
		return entertainmenthindilanguagesimges;
	}

	/* Click on hindi languages */
	public void clickOnHindi() {
		getEntertainmentHindiLanguagesNews().isPresent();
		webUtility.clickOnElement(getEntertainmentHindiLanguagesNews());
		waitForPageToLoad();
	}

	/* Verify that we are in choosen languages page */
	public void verifyHindiLanguagesNewsPage() {
		waitForPageToLoad();
		String title = driver.getTitle();
		System.out.println("Title of hindi page");
		Assert.assertEquals(title, "Bollywood Movies News, Latest Hindi Movies Gossip, Videos & Photos | Entertainment - Times of India");
	}

	/* Verify trading now news & get the text of each news */
	public void verifyTradingNow() {
		getEntertainmenthinditradingnow().isDisplayed();
		List<QAFWebElement> tradingNowLink = getEntertainmenthindilanguagestrading();
		int tradingLinkCount = tradingNowLink.size();
		System.out.println("trading links count are:" + tradingLinkCount);
		
	}

	/* verify the image for hindi news */

	public void verifyImagesForLanguages() {
		List<QAFWebElement> allhindiNewsLinks = getEntertainmenthindientertainment();
		String allimages = getEntertainmenthindilanguagesimges().getAttribute("id");
		Map<String, String> map = new HashMap<String, String>();
		System.out.println("hind entertainment news " + allhindiNewsLinks.size());
		for (int i = 0; i < allhindiNewsLinks.size(); i++) {
			webUtility.MouseOver(allhindiNewsLinks.get(i));
			for (Map.Entry<String, String> entry : map.entrySet()) {
				System.out.println(entry.getKey() + "/" + entry.getValue());
				String key = entry.getKey();
				String value = entry.getValue();
				if (key == value) {
					System.out.println("imges are chaning as per news changing");

				} else {
					System.out.println("Images are not matching as per news changing");
				}

			}
		}

		/*
		 * String
		 * previous=getEntertainmenthindilanguagesimges().getAttribute("id");
		 * System.out.println("Previous images :" +previous);
		 */
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}
}
