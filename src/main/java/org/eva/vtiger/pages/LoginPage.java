package org.eva.vtiger.pages;

import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class LoginPage {
		// hear i am defining WebUtil type variable.which is global and non-static.
		private WebUtil wu;
		
		
		// hear i am searching element and two type of Seraching 1- fastSearching(like findElement()/findElement()s  2- SlowSearching.
 		// We always keep WebElement on top of the page and used pagefacotry because whenever any change in application than no need to change one by one every where
		// only come hear and change Locater Or xpath it;s like global varibale if we will change on time it will be changed all 
		@ FindBy(xpath = "//input[@name='user_name']")
		  private WebElement userName ;
		public WebElement getUserName() {
			
			return userName;
		}
		
		@ FindBy(xpath = "//input[@name='user_password']")
		   public WebElement password ;
		
		@ FindBy(xpath = "//input[@name='Login']")
		   public WebElement loginBtn ;
		
		// hear i am creating constructor for inisalizing WebUtil_Object.
		public LoginPage(WebUtil wuObj) {
			wu = wuObj;
			PageFactory.initElements(wu.getDriver(), this);
			
			
		}
		
		public void validLogin() {
		   
		    // hear I am filling value in username field not searching Element beacasue already serched byHelp PageFactory.
			wu.sendKeys(userName, "admin", "userName");
			
			wu.sendKeys(password, "admin", "passwordField");
			
			wu.click(loginBtn, "loginButton");
			
			
			
			
		}
		
	   public void invalidLogin()
	   {
		  		   	
			wu.sendKeys(userName, "admin", "userName");
		
			wu.sendKeys(password, "adm", "passwordField");
			
			wu.click(loginBtn, "loginButton");
		   
		   
		   
	   }	
		
	 
		

	}


