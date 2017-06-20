package com.timesofindia.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.timesofindia.utility.WebUtility;

public class TimesOfIndiaEntertainmentPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	WebUtility webUtility = new WebUtility();

	@FindBy(locator = "entertainment.Text")
	private QAFWebElement entertainmenttext;

	@FindBy(locator = "entertainment.links")
	private List<QAFWebElement> entertainmentlinks;

	@FindBy(locator = "entertainment.image")
	private List<QAFWebElement> entertainmentImages;

	@FindBy(locator = "entertainment.slider.next")
	private QAFWebElement entertainmentSliderNext;

	@FindBy(locator = "entertainment.mainMenu.Text")
	private QAFWebElement entertainmentMainMenuText;

	@FindBy(locator = "entertainment.languages.links")
	private QAFWebElement elementlanguageslinks;

	@FindBy(locator = "entertainment.languages.news.links")
	private List<QAFWebElement> entertainmentlangugesnewslinks;

	@FindBy(locator = "entertainment.languages.popup")
	private QAFWebElement entertainmentlanguagespopup;

	@FindBy(locator = "entertainment.news.images")
	private List<QAFWebElement> entertainmentnewsimages;
	
	@FindBy(locator="entertainment.news.advertisement")
	private QAFWebElement entertainmentAdvertisement;

	/* getter for locators */

	public QAFWebElement getEntertainmenttext() {
		return entertainmenttext;
	}

	public List<QAFWebElement> getEntertainmentlinks() {
		return entertainmentlinks;
	}

	public List<QAFWebElement> getEntertainmentImages() {
		return entertainmentImages;
	}

	public QAFWebElement getEntertainmentSliderNext() {
		return entertainmentSliderNext;
	}

	public QAFWebElement getEntertainmentMainMenuText() {
		return entertainmentMainMenuText;
	}

	public QAFWebElement getElementlanguageslinks() {
		return elementlanguageslinks;
	}

	public List<QAFWebElement> getEntertainmentlangugesnewslinks() {
		return entertainmentlangugesnewslinks;
	}

	public QAFWebElement getEntertainmentlanguagespopup() {
		return entertainmentlanguagespopup;
	}

	public List<QAFWebElement> getEntertainmentnewsimages() {
		return entertainmentnewsimages;
	}

	
	
	public QAFWebElement getEntertainmentAdvertisement() {
		return entertainmentAdvertisement;
	}

	/* verify the Entertainment link is available or not */
	public void verifyEntertainmentLink() {
		getEntertainmenttext().isPresent();
		assertEquals(getEntertainmenttext().getText(), "ENTERTAINMENT");
		waitForPageToLoad();
	}

	/* get count of link present in entertainment */
	public void getEntertainmentLinkCount() throws Throwable {
		List<QAFWebElement> linksize = getEntertainmentlinks();
		int linksCount = linksize.size();
		System.out.println("Total no of links Available: " + linksCount);
		waitForPageToLoad();
		Thread.sleep(15000);
	}
	
	/* check for advertisemennt is present or not */
	 public void clickOnAdvertisement(){
		 if(getEntertainmentAdvertisement().isDisplayed()){
			 webUtility.clickOnElement(getEntertainmentAdvertisement());
			 waitForPageToLoad();
		 }
	 }

	/* click on slider & get the count of images */
	public void getCountOfImagesInEntertainmentSection() throws Throwable {
		int counter = 1;
		List<QAFWebElement> ele = getEntertainmentnewsimages();
		System.out.println("Size ::" + ele.size());
		for (QAFWebElement element : ele) {
			{
				if (counter > 1) {
					break;
				}
				int loopIncrementSize = ele.size() / element.getTagName().length();
				for (int j = 0; j < loopIncrementSize; j++)
				{	
					System.out.println("length of images::" + element.getTagName().length());
					getEntertainmentSliderNext().waitForVisible(20000);
					getEntertainmentSliderNext().click();
					waitForPageToLoad();
					counter++;
				}

			}
		}
	}

	/* verification of entertainment tab from main menu */

	public void verificationOfEntertainmentFromMainMenu() throws Throwable {
		getEntertainmentMainMenuText().isPresent();
	/*	QAFExtendedWebElement menuCatogoryElement = new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("entertainment.mainMenu.option"), menuname));
		webUtility.MouseOver(menuCatogoryElement);*/
		webUtility.MouseOver(getEntertainmentMainMenuText());
	//	compareEntertainmentNews();
		waitForTextPresent("Hindi");
	}

	/* Verify languages & verify news according to languages */
	public void verifyLanguagesAndLinks() {
		String languages[] = { "Hindi", "English", "Marathi", "Tamil", "Telugu", "Gujarati" };		
		for (int j = 0; j < languages.length; j++) {
			getEntertainmentlanguagespopup().isDisplayed();
			QAFExtendedWebElement catogoryElement = new QAFExtendedWebElement(String
					.format(ConfigurationManager.getBundle().getString("entertainment.languages.links"), languages[j]));
			webUtility.MouseOver(catogoryElement);
			for (int i = 0; i < getEntertainmentlangugesnewslinks().size(); i++) {
				int newsCount = getEntertainmentlangugesnewslinks().size();
				System.out.println("Total size of news links are" + newsCount);
				System.out.println("Newslinks" + getEntertainmentlangugesnewslinks().get(i).getText());
			}
		}
	}

	/* Compare the links from home entertainment page & menu Entertainment */
	public void compareEntertainmentNews() {
		if (getEntertainmentlinks() != null && getEntertainmentlangugesnewslinks() != null
				&& getEntertainmentlinks().size() == getEntertainmentlangugesnewslinks().size()) {
			System.out.println("Entertainment news are same in both section");
		} else {
			System.out.println("Enetertainment news are not same in both section");
		}
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

}
