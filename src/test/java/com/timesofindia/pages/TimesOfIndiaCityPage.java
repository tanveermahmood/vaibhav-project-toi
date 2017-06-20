package com.timesofindia.pages;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import com.timesofindia.beans.TimesOfIndiaMostReadBean;
import com.timesofindia.components.TimesOfIndiaMostReadPage;
import com.timesofindia.utility.WebUtility;

public class TimesOfIndiaCityPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	WebUtility webutility = new WebUtility();

	@FindBy(locator = "header.metrocities.list")
	private List<QAFWebElement> headermetrocities;

	@FindBy(locator = "header.latest.stories")
	private QAFWebElement headerLatestStories;

	@FindBy(locator = "latest.stories.ReadSection")
	private QAFWebElement latestStoriesReadSection;

	@FindBy(locator = "latest.stories.inThisSection")
	private QAFWebElement lateststoriesinthisSection;

	@FindBy(locator = "read.inthissection.news")
	private List<QAFWebElement> reasInthisSection;

	@FindBy(locator = "mostpopular.commentd.tab")
	private QAFWebElement mostPopularcommenttab;

	@FindBy(locator = "mostpopular.mostpopular.news")
	private QAFWebElement mostpopularnews;

	@FindBy(locator = "mostpopular.mostpopular.anyTime")
	private QAFWebElement mostpopularanytimenews;

	@FindBy(locator = "mostpopular.past24hrs")
	private QAFWebElement mostpopularpast24hrs;

	@FindBy(locator = "latest.shared")
	private QAFWebElement latestshared;

	@FindBy(locator = "latest.Read.Entired")
	private QAFWebElement latestReadEntiredWebsite;

	@FindBy(locator = "most.popular.past4days")
	private QAFWebElement mostpopularpast4days;

	@FindBy(locator = "latest.stories.1dayago")
	private List<QAFWebElement> lateststories1dayago;

	@FindBy(locator = "most.popular.bean")
	private List<TimesOfIndiaMostReadPage> mostReadNewsBean;

	@FindBy(locator = "header.latest.parent")
	private List<TimesOfIndiaMostReadPage> headerlatestparent;

	public List<TimesOfIndiaMostReadPage> getHeaderlatestparent() {
		return headerlatestparent;
	}

	public List<TimesOfIndiaMostReadPage> getMostReadNewsList() {
		return mostReadNewsBean;
	}

	public List<QAFWebElement> getHeadermetrocities() {
		return headermetrocities;
	}

	public QAFWebElement getHeaderLatestStories() {
		return headerLatestStories;
	}

	public QAFWebElement getLatestStoriesReadSection() {
		return latestStoriesReadSection;
	}

	public List<QAFWebElement> getReasInthisSection() {
		return reasInthisSection;
	}

	public QAFWebElement getLateststoriesinthisSection() {
		return lateststoriesinthisSection;
	}

	public QAFWebElement getMostPopularcommenttab() {
		return mostPopularcommenttab;
	}

	public QAFWebElement getMostpopularanytimenews() {
		return mostpopularanytimenews;
	}

	public QAFWebElement getMostpopularpast24hrs() {
		return mostpopularpast24hrs;
	}

	public QAFWebElement getMostpopularnews() {
		return mostpopularnews;
	}

	public QAFWebElement getLatestshared() {
		return latestshared;
	}

	public QAFWebElement getLatestReadEntiredWebsite() {
		return latestReadEntiredWebsite;
	}

	public QAFWebElement getMostpopularpast4days() {
		return mostpopularpast4days;
	}

	public List<QAFWebElement> getLateststories1dayago() {
		return lateststories1dayago;
	}

	/*
	 * select menuname from header & verify the metro cities & click on submenu
	 */

	public void clickOnHeaderOptionAndSelectSubOption(String menuName, String submenuName) throws Throwable {
		QAFExtendedWebElement menuCatogoryElement = new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("header.menu.Text"), menuName));
		webutility.MouseOver(menuCatogoryElement);
		// waitForTextPresent("METRO CITIES");
		List<QAFWebElement> metrocitieslinksize = getHeadermetrocities();
		int linksCount = metrocitieslinksize.size();
		System.out.println("Total no of metro cities  Available: " + linksCount);
		for (int i = 0; i < metrocitieslinksize.size(); i++) {
			String metrocititext = getHeadermetrocities().get(i).getText();
			System.out.println("cities as follows:::" + metrocititext);
			Thread.sleep(2000);
		}

		// for (QAFWebElement ele : getHeadermetrocities()) {

		QAFExtendedWebElement submenuCatogoryElement = new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("header.submenu.text"), submenuName));
		webutility.clickOnElement(submenuCatogoryElement);
		waitForPageToLoad();
	}

	/* verify that we are on pune city page or not */
	public void verifyothercitipage() {
		waitForPageToLoad();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Pune News, Latest Pune News Headlines & Live Updates - Times of India");

	}

	/* verify bydefault option selected */
	public void verifyReadOption() {
		getLatestStoriesReadSection().isDisplayed();
		if (getLatestStoriesReadSection().getAttribute("Class") == "active") {
			System.out.println("Read & in this section is selected by default");
			List<QAFWebElement> readNews = getReasInthisSection();
			int linkCount = readNews.size();
			System.out.println("Total news in this section are::" + linkCount);
			for (int i = 0; i < getReasInthisSection().size(); i++) {
				System.out.println("news from read section::" + getReasInthisSection().get(i).getText());
			}
			waitForPageToLoad();
		}

	}

	/* click on Commented tab From most popular */
	public void clickOnCommentedTab() throws Throwable {
		getMostPopularcommenttab().isPresent();
		webutility.clickOnelementUsingJavascriptExecutor(getMostPopularcommenttab());
		waitForPageToLoad();
		if (getMostPopularcommenttab().getAttribute("class") == "active") {
			System.out.println("By default anytime option is selected");
		}
	}

	/* click on most popular news */
	public void clickOnMostPopularNews() throws Throwable {
		getMostpopularnews().isPresent();
		Thread.sleep(10000);
		webutility.clickOnelementUsingJavascriptExecutor(getMostpopularnews());
		webutility.handleWindow();
		waitForTextPresent("ANYTIME");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Most Commented News Stories, Top Commented Articles - Times of India");
		if (getMostpopularanytimenews().getAttribute("class") == "active") {
			System.out.println("By default anytime option is selected");
		}
	}

	/* click on past 24 hrs news */
	public void clickOnPast24hrsNews() throws Throwable {
		getMostpopularpast24hrs().isDisplayed();
		webutility.clickOnElement(getMostpopularpast24hrs());
		waitForPageToLoad();
		getTitleAndDescription();
		driver.close();
		driver.switchTo().window(webutility.mainHandle);
	}

	/* click on shared tab & click on most popular news */
	public void clickOnSharedTabAndClickMostpopularNews() throws Throwable {
		waitForPageToLoad();
		getLatestshared().isPresent();
		webutility.clickOnelementUsingJavascriptExecutor(getLatestshared());
		getMostpopularnews().waitForVisible();
		webutility.clickOnelementUsingJavascriptExecutor(getMostpopularnews());
		waitForPageToLoad();
		webutility.handleWindow();
		waitForTextPresent("ANYTIME");
		if (getMostpopularanytimenews().getAttribute("class") == "active") {
			System.out.println("By default anytime option is selected");
			String title = driver.getTitle();
			Assert.assertEquals(title, "Most Commented News Stories, Top Commented Articles - Times of India");
		}
	}

	/* click on past 4days */
	public void clickOnPast4Days() throws Throwable {
		getMostpopularpast4days().isPresent();
		webutility.clickOnElement(getMostpopularpast4days());
		waitForPageToLoad();
		getTitleAndDescription();
		driver.close();
		driver.switchTo().window(webutility.mainHandle);

	}

	/* click on Read & Entie Website */
	public void clickOnEntireWebSite() {
		getLatestStoriesReadSection().isPresent();
		webutility.clickOnelementUsingJavascriptExecutor(getLatestStoriesReadSection());
		getLatestReadEntiredWebsite().isPresent();
		webutility.clickOnelementUsingJavascriptExecutor(getLatestReadEntiredWebsite());
		waitForPageToLoad();
	}

	/* click on commented & click on entire website */
	public void clickOnCommentedAndEntireWebsite() throws Throwable {
		getMostPopularcommenttab().isPresent();
		webutility.clickOnelementUsingJavascriptExecutor(getMostPopularcommenttab());
		getLatestReadEntiredWebsite().isPresent();
		webutility.clickOnelementUsingJavascriptExecutor(getLatestReadEntiredWebsite());
		getMostpopularnews().waitForVisible();
		webutility.clickOnelementUsingJavascriptExecutor(getMostpopularnews());
		waitForPageToLoad();
		webutility.handleWindow();
		waitForTextPresent("ANYTIME");
		if (getMostpopularanytimenews().getAttribute("class") == "active") {
			System.out.println("By default anytime option is selected");
			String title = driver.getTitle();
			Assert.assertEquals(title, "Most Commented News Stories, Top Commented Articles - Times of India");
		}
		clickOnPast24hrsNews();
		getTitleAndDescription();
	}

	/* click on shared & click on entire website */
	public void clickOnSharedAndEntireWebsite() throws Throwable {
		getLatestshared().isPresent();
		webutility.clickOnelementUsingJavascriptExecutor(getLatestshared());
		waitForPageToLoad();
		getLatestReadEntiredWebsite().isPresent();
		webutility.clickOnelementUsingJavascriptExecutor(getLatestReadEntiredWebsite());
		getMostpopularnews().waitForVisible();
		webutility.clickOnelementUsingJavascriptExecutor(getMostpopularnews());
		waitForPageToLoad();
		webutility.handleWindow();
		if (getMostpopularanytimenews().getAttribute("class") == "active") {
			System.out.println("By default anytime option is selected");
			String title = driver.getTitle();
			Assert.assertEquals(title, "Most Commented News Stories, Top Commented Articles - Times of India");
		}
		clickOnPast4Days();
		getTitleAndDescription();
	}

	/* get the title and description for 10 news */

	public void getTitleAndDescription() {
		for (int i = 0; i < getMostReadNewsList().size(); i++) {
			if (i == 10) {
				break;
			}
			try {
				if (getMostReadNewsList().get(i).getMostpopulardescdiv().isPresent()) {
					System.out.println("Title of first 10 news::  "
							+ getMostReadNewsList().get(i).getMostpopularnewsTitle().getText());
					if(!getDescription(i).contentEquals("")){
					System.out.println("description ::" + getDescription(i));
				} else {
					System.out.println(""+ "Description is not available");
				}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private String getDescription(int i) {
		try {
			QAFWebElement ele = getMostReadNewsList().get(i).getMostpopulardescription();
			if (ele.isPresent())
				return ele.getText();
			else
				return "";
		} catch (Exception e) {
			return "";
		}
	}

	/* verification for the news */

	public void verifyMostReadPage() {
		getMostReadNewsList().get(0).waitForVisible();
		Validator.verifyThat("verify most read page", getMostReadNewsList().size(), Matchers.greaterThan(0));
	}

	/* get the title and description for 10 news */

	/*public void getTitleAndDescription() throws Throwable {
		verifyMostReadPage();
		for (int i = 0; i < getMostReadNewsList().size(); i++) {
			if (i == 10) {
				break;
			}
		//	QAFTestBase.pause(10000);
			System.out.println("Title :" + getMostReadNewsList().get(i).getMostpopularnewsTitle().getText());
			if (getMostReadNewsList().get(i).getMostpopulardescription().isDisplayed()) {
				System.out.println("Description :" + getMostReadNewsList().get(i).getMostpopulardescription().getText());
			} else {
				System.out.println("Description NOT Available");
			}
		}*/

			/*
			 * catch(Exception e){ System.out.println("Title :" +
			 * getMostReadNewsList().get(i).getMostpopularnewsTitle().getText()
			 * + "Description NOT Available"); }
			 */
		//}
	

	/* read the news & get days or time to for news & read one day ago news */
	public void getReadNewsAndTime() {
		int count = 0;
		for (int i = 0; i < getHeaderlatestparent().size(); i++) {
			if (getHeaderlatestparent().get(i).isDisplayed()
					&& getHeaderlatestparent().get(i).getHeaderlatestchild().getText().equalsIgnoreCase("1 DAY AGO")) {
				count++;
				if (getHeaderlatestparent().get(i).getLatestStorieslist().isPresent()) {
					System.out.println(
							"Title of news::" + getHeaderlatestparent().get(i).getLatestStorieslist().getText());
					System.out.println(
							"Times for each news::" + getHeaderlatestparent().get(i).getHeaderlatestchild().getText());

				} else {
					System.out.println("advertisement  news");
				}
			}
		}
		System.out.println("count of link page ::" + count);
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

}
