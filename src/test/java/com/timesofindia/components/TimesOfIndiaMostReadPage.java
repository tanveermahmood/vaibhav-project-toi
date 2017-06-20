package com.timesofindia.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class TimesOfIndiaMostReadPage extends QAFWebComponent {

	public TimesOfIndiaMostReadPage(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	/* components for read news */
	@FindBy(locator = "latest.stories.list")
	private QAFWebElement latestStorieslist;

	@FindBy(locator = "header.latest.child")
	private QAFWebElement headerlatestchild;

	/* components for news title & Description */
	@FindBy(locator = "mostpopular.past24hrs.newsTitle")
	private QAFWebElement mostpopularnewsTitle;

	@FindBy(locator = "mostpopular.past24hrs.description")
	private QAFWebElement mostpopulardescription;

	@FindBy(locator = "mostpopular.past24hrs.descdiv")
	private QAFWebElement mostpopulardescdiv;

	@FindBy(locator = "most.read.description")
	private QAFWebElement mostreaddescription;

	public QAFWebElement getMostpopulardescdiv() {
		return mostpopulardescdiv;
	}

	public QAFWebElement getLatestStorieslist() {
		return latestStorieslist;
	}

	public QAFWebElement getHeaderlatestchild() {
		return headerlatestchild;
	}

	public QAFWebElement getMostpopularnewsTitle() {
		return mostpopularnewsTitle;
	}

	public QAFWebElement getMostpopulardescription() {
		return mostpopulardescription;
	}

	public QAFWebElement getMostreaddescription() {
		return mostreaddescription;
	}

}
