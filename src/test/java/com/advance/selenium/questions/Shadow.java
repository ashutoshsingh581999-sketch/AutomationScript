package com.advance.selenium.questions;
import org.eva.vtiger.utils.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Shadow {
	WebDriver driver;
	

	
	
	
	
	
	
	
	@Test()
	public void handleShadowRoot() {
		// testNg report =  for showing report we need to go test-output = emailable-report.html , index.html
		// driver >Shadow host (WebElement) > Shadow root (SearchContext) > findElenent(By.cssSelector )> action(click,sendKey etc).
	   driver = new ChromeDriver();
	   driver.get("https://selectorshub.com/xpath-practice-page/");
		
		WebElement host=driver.findElement(By.xpath("//div[@id='userName']"));
		SearchContext shadowRoot =host.getShadowRoot();
		WebElement user_nameWe= shadowRoot.findElement(By.cssSelector("#kils"));
		user_nameWe.sendKeys("ashutosh singh");
		
	}
	
	/* 1> firstly we go inside shadow and we use shadowRef.findElement(By.xpath/id/cssSelector/name); then actions
	 * 2> now we have to locate frame and switchTo on  frame and perform actions again switchTo() main widow.
	 * 
	 * */
	@Test()
	public void shadowIframeHandling() {
		// driver> locateHost>getShadowRoot() > SearchContex serchObj>serchObj.findElement().
		driver = new ChromeDriver();
		driver.navigate().to("https://selectorshub.com/iframe-in-shadow-dom/");
		WebElement host = driver.findElement(By.xpath("//div[@id='userName']"));
		SearchContext shadowRoot=host.getShadowRoot();	
		
		
		
	}
	
	
	@Test()
	public void handleShadowRootByJS() {
		
		  driver = new ChromeDriver();
		  driver.get("https://selectorshub.com/xpath-practice-page/");
		  WebElement host=driver.findElement(By.xpath("//div[@id='userName']"));
		  JavascriptExecutor jse =(JavascriptExecutor) driver;
		  WebElement userInput= (WebElement) jse.executeScript(" return arguments[0].shadowRoot.querySelector('#kils')",host );  // it will return WebElement because i have used > return
		   userInput.sendKeys("satyam singh");
		  
		   /* 
		    * querySelector() sirf CSS Selector string accept karta hai
		    * querySelector() xpath ko accept nhi krta hai 
		    * host>shadowroot>querySelector>html element> selenium will convert into WebElement  now you can work on element(click,sendKeys any action); 
		    * */
	}
	
	
	/*// this is grouping when we have 1000 thousand testcases so in that satutaion we do this for diffrent -2 test.
	  <suite name="Suite">

  <test name="Smoke Test">

      <groups>
          <run>
              <include name="smoke"/>
          </run>
      </groups>

      <classes>
          <class name="test.LoginTest"/>
      </classes>

  </test>

  <test name="Regression Test">

      <groups>
          <run>
              <include name="regression"/>
          </run>
      </groups>

      <classes>
          <class name="test.PaymentTest"/>
      </classes>

  </test>

  </suite>
	   */
	

}
