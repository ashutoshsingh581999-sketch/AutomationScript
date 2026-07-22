package org.eva.vtiger.pages;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPageOR extends BasePage {
	// no need to create setterMethod hear because you no need to change value hear when rarelly xpath will change the you will come change value of xpath that's sit.
	public CreateLeadPageOR(WebUtil wu){
		super(wu);
		PageFactory.initElements(wu.getDriver(), this);
		
	}
	
	@FindBy(xpath="//input[contains(@name,'firstname')]")
	  private  WebElement firstname;
       
	
	 public WebElement getFirstname() {
        	
        	return  firstname;        	
        }
	
	@FindBy(xpath="//input[contains(@name,'lastname')]")
	  private WebElement lastname;
	     
	  public WebElement getLastname() {
      	
      	return  lastname;        	
      }
	
	
	@FindBy(xpath="//input[contains(@name,'company')]")
	 private  WebElement companyName;
	
	  public WebElement getCompanyname() {
      	
      	return  companyName;        	
      }
	
	
	@FindBy(xpath="//input[@id='designation']")
	   WebElement title;
	
	  public WebElement getTitle() {
      	
      	return  title;        	
      }
	
	@FindBy(xpath="//input[@id='phone']")
	   WebElement phoneNum;
	
	  public WebElement getPhomeNum() {
      	
      	return phoneNum;        	
      }
	@FindBy(xpath="//input[@id='mobile']")
	   WebElement mobileNum;
	
	  public WebElement getMobileNum() {
      	
      	return  mobileNum;        	
      }
	
	@FindBy(xpath="//textarea[@class='detailedViewTextBox']")
	    WebElement street;
	  public WebElement getStreet() {
      	
      	return  street;        	
      }
	
	

}
