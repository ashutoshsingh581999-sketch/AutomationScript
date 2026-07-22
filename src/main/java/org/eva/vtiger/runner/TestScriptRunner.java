package org.eva.vtiger.runner;

import org.eva.vtiger.testscripts.LeadAutomationScripts;
import org.eva.vtiger.testscripts.SearchLeadAutomationScript;

public class TestScriptRunner  {
	
	
	
	public static void main(String[] args) {
		
//		LeadAutomationScripts ld= new LeadAutomationScripts();
//		ld.testLeadCreationWithRequiredFieldsOnly();
		
		
		SearchLeadAutomationScript serchLed = new SearchLeadAutomationScript();
		serchLed.searchLeadAccordingToValue();
		
	} 

}
