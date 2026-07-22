package org.eva.vtiger.pages;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadLandingPageOR extends BasePage{
	
	 // hear we can make private and protected but best practice is (private) because 
	// when you will make private the you will make getterMethod() for getting value 
    // protected is only access where you will extends and again you want to use any other class then how will you use.
    // again hear you need to make getterMethod() for getting value of . that's the reason we create private and make a public getterMethod().

     public LeadLandingPageOR(WebUtil wu) {
    	  super(wu);
    	  PageFactory.initElements(wu.getDriver(), this);  // this line is must for inisalizing for WebElment that's we put in constructor when we make Object of the class automatically constructor will run and insalized all Webelments.  
    	 
    	 
     }
	
	
	@FindBy(xpath="//img[contains(@title,'Create Lead...')]")
	  private WebElement leadCreateBtn;               	 
	
	public WebElement getLeadCreateButton() {
		 
		return leadCreateBtn;
	  } 
	
	
	
	
	
	
	
}