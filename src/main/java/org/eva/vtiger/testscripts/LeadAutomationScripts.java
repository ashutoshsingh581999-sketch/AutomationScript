package org.eva.vtiger.testscripts;

import org.eva.vtiger.pages.CreateLeadPage;
import org.eva.vtiger.pages.HomePage;
import org.eva.vtiger.pages.LeadInformationPage;
import org.eva.vtiger.pages.LeadLandingPage;
import org.eva.vtiger.pages.LoginPage;
import org.eva.vtiger.utils.WebUtil;

public class LeadAutomationScripts {
	
	
	public void testLeadCreationWithRequiredFieldsOnly() {
		WebUtil wu = new WebUtil();
		// this for launch browser and hit url
		wu.launchBrowser("chrome");
		wu.maiximizeWindow();
		wu.openUrl("http://localhost:8888/");
		// hear i am going to login.
		LoginPage lg = new LoginPage(wu);
		lg.validLogin();
		
		// home page > clicking on leadLink
		
		HomePage hm = new HomePage(wu);
		hm.clickLeadsLink();
		
		// clickOn createLead btn
		LeadLandingPage leadPg =   new LeadLandingPage(wu);
		leadPg.clickOnLeadCreateBtn();
		
		
		// now i am on the CreateLeadPage so we fill all mandatory fields.
		CreateLeadPage crtLedPg=new CreateLeadPage(wu);  
		// 34 line - this line will load all static and non static var and method , call constructor and when ye dekehega ki iske andr bhi BasePage extends hai to phle ye parent ke constructor ko chlyega but depend krata hai apne super() likha hai ki nhi and in first line aur ise WebUtil ka object dege.
		// aur ye constructor ke andr ki line chlyega to ( PageFactory.initElements(wu.getWebUtil(),this) aur basepage ke sare Elements ko insalize krega uske bad CreateLeadPage ke bhi sare elements ko insalize kr dega no need to write ( PageFactory.initElements(wu.getWebUtil(),this)  this line
	 
		  crtLedPg.verifyCreateLeadPageWhithMandatoryFiled();
		
		  LeadInformationPage ledInfo= new LeadInformationPage(wu);
		  ledInfo.clickOnEditButton();
		
		 // ledInfo.getAllInputBoxText();
	   
                
	  
	  
	    
		    
		
	}
	
	
	
	
	
	
	
	

}
