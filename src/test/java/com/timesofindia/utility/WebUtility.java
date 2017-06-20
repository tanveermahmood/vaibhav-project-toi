package com.timesofindia.utility;

import org.aspectj.apache.bcel.generic.SwitchBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.qmetry.qaf.automation.ui.AbstractTestPage.*;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver.*;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.util.ExpectedCondition;
import com.qmetry.qaf.automation.ui.util.QAFWebDriverWait;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import static com.qmetry.qaf.automation.step.CommonStep.*;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import java.sql.Driver;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WebUtility extends WebDriverBaseTestPage<WebDriverTestPage> {
	public String mainHandle=driver.getWindowHandle();
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
//	static WebDriver driver;

	 /*parallel browser selection */
/*	public WebDriver openBrowser(String browsername) {
		try {
			if (browsername.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}
			if (browsername.equalsIgnoreCase("Chrome")) {

				System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
				driver = new ChromeDriver();
			}
			if (browsername.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		} catch (WebDriverException e) {

			System.out.println("Browser not found" + e.getMessage());
		}
		get("/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}*/

	/* click method */

	public static void clickOnElement(QAFWebElement element) {
		element.isEnabled();
		element.click();

	}

	/* click using javascript executor */
	public void clickOnelementUsingJavascriptExecutor(QAFWebElement element) {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);

			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element " + e.getStackTrace());
		}
	}

	 /*verification of text using senkeys method */
	public static void sendTextToElement(QAFWebElement element, String text) {
		element.isPresent();
		element.clear();
		element.sendKeys(text);
	}

	/* check for alert present or not */

	public boolean isAlertPresent() {
		try {
			
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/* Handle alert option will depends on user */
	public void invokedAlert(int SelectOption) {
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			switch (SelectOption) {
			case 0:
				System.out.println("Alert text :" + alert.getText());
				alert.accept();
				break;
			case 1:
				System.out.println("Alert text :" + alert.getText());
				alert.dismiss();
				break;
			default:
				System.out.println("not able to select the option");
				break;
			}

		} else {
			System.out.println("Alert is not present");
		}
	}
/*
	 checkbox selection */

	public static void selectCheckbox(QAFWebElement element) {
		try {
			if (element.isSelected()) {
				System.out.println("Checkbox: " + element + "is already selected");
			} else {
				element.click();
			}
		} catch (Exception e) {
			System.out.println("Unable to select the checkbox: " + element);
		}

	}

	/* select checkbix from list */

	public void selectTheCheckBoxfromList(WebElement element, String valueToSelect) {
		List<WebElement> allOptions = element.findElements(By.tagName("input"));
		for (WebElement option : allOptions) {
			System.out.println("Option value is " + option.getText());
			if (valueToSelect.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}

	 /*checkbox deselection(if chekcbox is already selected) */
	public static void DeselectCheckbox(QAFWebElement element) {
		try {
			if (element.isSelected()) {
				element.click();
			} else {
				System.out.println("checknox is already deselected: " + element);
			}
		} catch (Exception e) {
			System.out.println("Unable to deselect checkbox :" + element);
		}
	}

	 /*dropdown selection using all three methods */
	public static void selectDropdown(QAFWebElement element, int args) {
		Select se = new Select(element);
		se.selectByIndex(args);
	}

	public static void selectDropdownByText(QAFWebElement element, String text) {
		Select se = new Select(element);
		se.selectByVisibleText(text);
	}

	public static void selectDropdownByValue(QAFWebElement element, String value) {
		Select se = new Select(element);
		se.selectByValue(value);
	}

/*	 Auto-suggest dropdown */
	public void selectAutoSuggestionDropdown(QAFWebElement element, String value) {
		element.click();
		element.sendKeys(value);
		element.sendKeys(Keys.TAB);
	}

	 /*mouseover action method */
	public void MouseOver(QAFWebElement element) {
		Actions action = new Actions(driver);
		//Actions actObj = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	  
	/* handle window */
	public void handleWindow(){
		String mainHandle=driver.getWindowHandle();
		for(String childWindow:driver.getWindowHandles()){
			driver.switchTo().window(childWindow);
			waitForPageToLoad();
		}
	}
	/* get the current window handle */
	public String getMainWindowHandle() {
		return driver.getWindowHandle();
	}
}