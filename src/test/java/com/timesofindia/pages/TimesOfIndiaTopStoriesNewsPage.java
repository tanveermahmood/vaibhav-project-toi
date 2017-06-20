package com.timesofindia.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static com.qmetry.qaf.automation.step.CommonStep.*;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.StringMatcher;
import com.qmetry.qaf.automation.util.Validator;


public class TimesOfIndiaTopStoriesNewsPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "topStories.News.Text")
	private QAFWebElement topNewsStoriesTxt;

	@FindBy(locator = "topStories.News.Link")
	private List<QAFWebElement> allStoriesLinks;

	
	@FindBy(locator="android.storieslink")
	private List<QAFWebElement> storieslink;
	
	/*getters & setters */
	public QAFWebElement getTopNewsStoriesTxt() {
		return topNewsStoriesTxt;
	}

	public void setTopNewsStoriesTxt(QAFWebElement topNewsStoriesTxt) {
		this.topNewsStoriesTxt = topNewsStoriesTxt;
	}

	public List<QAFWebElement> getAllStoriesLinks() {
		return allStoriesLinks;
	}

	public void setAllStoriesLinks(List<QAFWebElement> allStoriesLinks) {
		this.allStoriesLinks = allStoriesLinks;
	}

	public List<QAFWebElement> getStorieslink() {
		return storieslink;
	}

	/* verification of top news stories text */

	public void verifyTopNewsStories() throws Throwable {
		Assert.assertEquals(getTopNewsStoriesTxt().getText(), "TOP NEWS STORIES");
	}

	/* get current window title */

	public String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}

	/* get link of available top stories & get title of each page */

	public void switchNewTopStories() throws Throwable {
		List<QAFWebElement> linksize =getAllStoriesLinks();
		int linksCount = linksize.size();
		System.out.println("Total no of links Available: " + linksCount);
		String links[] = new String[linksCount];
		System.out.println("List of links Available: ");

		// print all the links from webpage
		for (int i = 0; i < linksCount; i++) {
			links[i] = linksize.get(i).getAttribute("href");
			System.out.println(linksize.get(i).getAttribute("href"));
		}
		// navigate to each Link on the webpage
		for (int i = 0; i < linksCount; i++) {
			driver.navigate().to(links[i]);
			System.out.println("Title of opened page" + driver.getTitle());
			driver.navigate().back();
			waitForPageToLoad();
		}
	}

	/* mobile automation methods */	

	public void clicOnEachTopNewsStories(){
		List<QAFWebElement> linksize =getStorieslink();
		int linksCount = linksize.size();
		System.out.println("Total no of links Available: " + linksCount);
		String links[] = new String[linksCount];
		System.out.println("List of links Available: ");
	
	}
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

}
