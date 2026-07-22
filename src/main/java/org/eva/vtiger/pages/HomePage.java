package org.eva.vtiger.pages;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends HomePageOR {
	private WebUtil wu;
	

	
	
	public HomePage(WebUtil wuObject) {
	    super(wuObject);
		wu = wuObject;
	  
	}
	
	
	public void clickLeadsLink() {
		
		 
	
		 wu.mouseHover(this.getMarketingLink(), "marketingLink");
		 
		 wu.clickByJs(this.getLeadsLink(), "leadLink");
		
		
	}
	
	

	  
	
	
	
	
	
	
	
	
	
	
}
