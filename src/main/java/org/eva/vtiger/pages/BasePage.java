package org.eva.vtiger.pages;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends BasePageOR  {
      private WebUtil wu;  // wu = null 
	
	public BasePage(WebUtil wuObject) {
		super(wuObject);
		wu = wuObject;  // hear this is insialized .
		
	
	}
	
	public void clickOnSaveButton() {
		
	   wu.click(this.getSaveButton(), "SaveButton");	
		
	}
	
	
	
	public void clickOnCancelButton() {
		
		wu.click(this.getCancelButton(), "CancelButton");
		
	}
	
	public void clickOnDeleteButton() {
		
		wu.click(this.getDeleteButton(), "deleteButton");
		
	}
	
	public void clickOnMassEditButton() {
		
		wu.click(this.getMassEditButton(), "massEditButton");
		
	}
	// hear we will fill value of like lastName =  singh, singhaniya like this
	  public void sendValueInSearchForTextBox(String value) {
		  wu.sendKeys(this.getsearchforTextBox(), value, "searchforTextbox");
		  
	  }
	
	// hear we select value according to want fetch data like (First ,Last,CompanyName,WebSite,Email like this)
	public void sendValueInSearchTextBox(String value) {
		
		wu.sendKeys(this.getSearchInTextBox(), value,"SearchTextBox");
		
	}
	
	public void clickOnSearchNowButton() {
		
		wu.click(this.getSearchNowButton(), "SearchNowbutton");
	
	}
	
	
	public void clickOnSendEmailButton() {
		
		wu.click(this.getSendEmailButton(), "SendEmailButton");
		
	}
	
	
   public void clickOnSendSmsButton() {
		
		wu.click(this.getSendSmsButton(), "SendSmsButton");
		
	}
   
   public void clickOnNewButton() {
		
		wu.click(this.getNewButton(), "NewButton");
		
	}
	
 	// hear we will create method releated to base page and work on it
	
	
	
}
