package org.eva.vtiger.pages;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageOR extends BasePage {
	
	public HomePageOR(WebUtil wu) {
		super(wu);
		 PageFactory.initElements(wu.getDriver(),this);
		
	}
	
	   
	@FindBy(xpath="//a[normalize-space()='Marketing']")
	 private WebElement marketingLink ;
	
	public WebElement getMarketingLink() {
		
		
		return marketingLink;
	}
	
	@FindBy(xpath="//div[contains(@id,'Marketing_sub')]//a[normalize-space()='Lead']")
	  private WebElement leadsLink;
	
   public WebElement getLeadsLink() {
		
		
		return leadsLink;
	}
	

}
