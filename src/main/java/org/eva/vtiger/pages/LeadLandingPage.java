package org.eva.vtiger.pages;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadLandingPage extends LeadLandingPageOR {
   public WebUtil wu;
	
	
	
	public LeadLandingPage(WebUtil wuObject) {
		  super(wuObject);
		 wu=wuObject;  // hear i am insalizing WebUtil Object if you will make Object of the class and you will pass in parameter WebUtil object so it will automatically insalized.
		
	 
		
		
	}
	
	public void clickOnLeadCreateBtn() {
		
		 wu.click(this.getLeadCreateButton(), "createLeadBtn");
		
		
		
	}
	
	
	
}
