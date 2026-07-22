package testScripts;

import org.eva.vtiger.testscripts.SearchLeadAutomationScript;
import org.testng.annotations.Test;

public class TestCaseRuner extends BaseTest {

	
	@Test
	public void serchScnarios() {
	SearchLeadAutomationScript serchLed = new SearchLeadAutomationScript();
	serchLed.searchLeadAccordingToValue(); 
	}
}
