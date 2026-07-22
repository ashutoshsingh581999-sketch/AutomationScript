package org.eva.vtiger.pages;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage extends CreateLeadPageOR {
	private WebUtil wu ; // we do not  declare this 
	  
	// hear i am creating constructor.

	public CreateLeadPage(WebUtil wuObject) {
		  
		super(wuObject);  // agr parameter na ho Parent me to by default ye parent ka constructor ka hi chlayega. so we can write no issues.
		wu = wuObject;
		   
		
	}
	

	public void verifyCreateLeadPageWhithMandatoryFiled() {
		wu.sendKeys(getFirstname(), "Ashutosh", "FirstName");  // this indecates current object .
		wu.sendKeys(getLastname(), "Singh", "LastName");
		wu.sendKeys(getCompanyname(), "NGO AshuFoundation", "CompanyName");
		
		this.clickOnSaveButton();
		
		
	}
	
	
	public void verifyCreateLeadPageWhithoutMandatoryFiled() {
		
		wu.sendKeys(getFirstname(), "Ashutosh", "FirstName");
	
		wu.sendKeys(getCompanyname(), "NGO AshuFoundation", "CompanyName");
		this.clickOnSaveButton();
	
	}
	
	


	
	
	
}
