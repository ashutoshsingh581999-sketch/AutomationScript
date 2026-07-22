package org.eva.vtiger.pages;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePageOR {
	
	public BasePageOR(WebUtil wu) {
		
		PageFactory.initElements(wu.getDriver(),this);
		
		
	}
	
	@FindBy(xpath="//input[contains(@value,'  Save  ')]")
     private WebElement saveButton; 

    public WebElement getSaveButton() {
 	
 	return  saveButton;        	
    }
 
	@FindBy(xpath="//input[contains(@value,'  Cancel')]")
	 private WebElement cancelButton;
      
	public WebElement getCancelButton() {
   	 return cancelButton;
   	       	  
   	         }
	
	@FindBy(xpath="//input[contains(@value,'  Delete')]")
	  private WebElement deleteButton;
	
	public WebElement getDeleteButton() {
		
		return deleteButton;
		
	}
	
	@FindBy(xpath="//input[@value='Mass Edit']") 
	   private WebElement massEditButton;
	
	public WebElement getMassEditButton() {
		return  massEditButton;
		
	}
	
	@FindBy(xpath="//input[@name='search_text']")
	   private WebElement searchTextBox ;
	
	public WebElement getsearchforTextBox() {
		   return searchTextBox;
		
		
	}
	
	@FindBy(xpath="//select[@id='bas_searchfield']")
	  private WebElement searchInTextBox;
	
	public WebElement getSearchInTextBox() {
		
		return searchInTextBox;
		
		
	}
	
	@FindBy(xpath="//input[@value=' Search Now ']")
	  private WebElement searchNowButton;

	public WebElement getSearchNowButton() {
		
		return searchNowButton;
		
	}
	

	
	
	@FindBy(xpath="//a[text()='New']")
	  private WebElement newButton;
	
	public WebElement getNewButton() {
		
		return newButton;
		
		
	}
	
	@FindBy(xpath="//input[@value='Send SMS']")
	  private WebElement sendSmsButton;
	
	public WebElement getSendSmsButton() {
		
		return  sendSmsButton;
		
	}
	
	
	@FindBy(xpath="//input[@value='Send Mail']")
	  private WebElement sendEmailButton;
	
	public WebElement getSendEmailButton() {
		
		return  sendEmailButton;
		
	}
	

}
