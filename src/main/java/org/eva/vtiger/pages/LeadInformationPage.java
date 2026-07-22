package org.eva.vtiger.pages;

import java.util.List;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LeadInformationPage {
	public WebUtil wu;
	
	@FindBy(xpath="//input[@name='Edit']")
	 WebElement editButton;
	
	@FindBy(xpath="//input[@name='Delete']")
	 WebElement deleteButton;
	
	@FindBy(xpath="//input[@name='Duplicate']")
	 WebElement duplicateButton;
	
	
	public  LeadInformationPage(WebUtil wuObject) {
		
		wu = wuObject;
		PageFactory.initElements(wu.getDriver(), this);
		
	}
	public void clickOnEditButton() {
		wu.click(editButton, "edit button");
		
		
	}
	
	public void clickOnDeleteButton() {
		wu.click(deleteButton, "delete button");
		
		
	}
	
	public void clickOnDuplicateButton() {
		wu.click(duplicateButton, "duplicate button");
		
		
	}
	
     
		 
		 
	 }


