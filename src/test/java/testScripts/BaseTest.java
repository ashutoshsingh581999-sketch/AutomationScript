package testScripts;

import java.lang.reflect.Method;

import org.eva.vtiger.pages.HomePage;
import org.eva.vtiger.pages.LoginPage;
import org.eva.vtiger.utils.WebUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
    private WebUtil wuObj;
    ExtentReports ext;
	ExtentTest exTest;
	@BeforeSuite
	public void beforeSuite() {
		ext= new ExtentReports();
		ExtentSparkReporter esr = new ExtentSparkReporter("extentReports/reports.html");
		ext.attachReporter(esr);
		
	}
	
	@BeforeMethod
	public void beforeMethod(Method mt) {
		wuObj= new WebUtil();
		
		exTest =ext.createTest(mt.getName());
		wuObj.setExtentTest(exTest);
		wuObj.launchBrowser("chrome");
		wuObj.openUrl("http://localhost:8888/");
		LoginPage lg = new LoginPage(wuObj);
		lg.validLogin();
		
		
		
	}
	@Test(enabled= false)
	public void clickOnleadPg() {
	HomePage homepg	= new HomePage(wuObj);
	homepg.clickLeadsLink();
		
	}
	
	
	@AfterMethod
	public void  afterMethod(ITestResult isr,Method mt) {
		if(!isr.isSuccess()) {
			String projectCurPath= System.getProperty("user.dir");
			wuObj.takeScreeShotFullpage( projectCurPath+"\\"+"extentReports\\"+mt.getName());
			exTest.addScreenCaptureFromPath(mt.getName()+"image.png");
		}
		ext.flush();
		
		
	}
	
	@AfterSuite
	public void afterSuite() {
		ext.flush();
	}
	
	
	
	
}
