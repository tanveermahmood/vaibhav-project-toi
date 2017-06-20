package com.timesofindia.pages;

import static com.qmetry.qaf.automation.step.CommonStep.get;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class TimesOfIndiaHomePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "homepage.notnow.alert.btn")
	private QAFWebElement homepagenotnowbtn;

	@FindBy(locator = "androidmenubtn")
	private QAFWebElement androidmenubtn;

	@FindBy(locator="homepage.advertisement.btn")
	private QAFWebElement advertisementbtn;
	
	
	public QAFWebElement getAndroidmenubtn() {
		return androidmenubtn;
	}

	public QAFWebElement getAndroidsubmenubtn() {
		return androidsubmenubtn;
	}

	@FindBy(locator = "androidsubmenu")
	private QAFWebElement androidsubmenubtn;

	/* getter methods */
	public QAFWebElement getHomepagenotnowbtn() {
		return homepagenotnowbtn;
	}
	

	
	public QAFWebElement getAdvertisementbtn() {
		return advertisementbtn;
	}

	/* click on Advertisement to move further for homepage*/
	public void navigateToHomePage()
	 {
	  if(getAdvertisementbtn().isPresent())
	   getAdvertisementbtn().click();
	 }
	/* select option in alert */
	public void clickOnNotNowBtn() throws Exception {
		getHomepagenotnowbtn().waitForVisible();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()",homepagenotnowbtn);
		System.out.println("alert is closed" + homepagenotnowbtn);
		waitForPageToLoad();
	}

	/* verify title of home page */
	public void verifyPage() {
		waitForPageToLoad();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"News: India News, Latest Bollywood News, Sports News, Business & Political News, National & International News | Times of India");
	}

	/* implmented method for driver initialization */
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		get("/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	

	/* Mobile automation mehthods */
	public void clickOnMenu() {
		getAndroidmenubtn().isPresent();
		getAndroidmenubtn().click();
		waitForPageToLoad();
	}

	public void clickOnSubMenu() {
		getAndroidsubmenubtn().isPresent();
		getAndroidsubmenubtn().click();
		waitForPageToLoad();
	}
	
	
}
