package org.eva.vtiger.testscripts;

import org.eva.vtiger.pages.HomePage;
import org.eva.vtiger.pages.LeadLandingPage;
import org.eva.vtiger.pages.LoginPage;
import org.eva.vtiger.utils.WebUtil;

public class SearchLeadAutomationScript {
	
	
	public void searchLeadAccordingToValue() {
		
	WebUtil wu = new WebUtil();
		wu.launchBrowser("chrome");
		wu.maiximizeWindow();
		wu.openUrl("http://localhost:8888/");
		
		LoginPage lg = new LoginPage(wu);
		lg.validLogin();
		
		HomePage hp= new HomePage(wu);
		hp.clickLeadsLink();
		
		hp.sendValueInSearchForTextBox("singh");
		hp.sendValueInSearchTextBox("Last Name");
		hp.clickOnSearchNowButton();
		
		
		
		
	}
	
	

}
