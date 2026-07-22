package org.eva.vtiger.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WebUtil {
	private WebDriver driver ;
	private ExtentTest extTest;

	public WebDriver getDriver() {
		return driver;
		
	}
	
	// for reporting we are creating method hear
	
	public void setExtentTest(ExtentTest extTest) {
		this.extTest=extTest;
		
	}
	
	public WebDriver launchBrowser(String browserName) {
		driver =null;
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			extTest.log(Status.INFO, " "+browserName+"Browser lauched successfully..");
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			extTest.log(Status.INFO, " "+browserName+"Browser lauched successfully..");
		}else if(browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			extTest.log(Status.INFO, " "+browserName+"Browser lauched successfully..");
			
		}else if(browserName.equalsIgnoreCase("safari")) {
			
			driver = new SafariDriver();
			extTest.log(Status.INFO, " "+browserName+"Browser lauched successfully..");
			
		}else {
			extTest.log(Status.INFO, "Browser not lauched successfully..");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		return driver;
		
		
	}
	// browser maximize 
	public void maiximizeWindow() {
		driver.manage().window().maximize();
		
		extTest.log(Status.INFO, "maximize window is successfully..");
		
	}
	
	
	
	// this method will set size of browser according to parameter.
	public void setWindowSize(int width,int height) {
		
		Dimension dim = new Dimension(width,height);
			
		driver.manage().window().setSize(dim);
		
		extTest.log(Status.INFO, " window sized fixed is successfully..");
		
	}
	public void navigateForword() {
		driver.navigate().forward();
		extTest.log(Status.INFO, "page navigate forward another page ");
		
		
		
		
	}
	public void navigateBack() {
		driver.navigate().back();
		extTest.log(Status.INFO, "page navigate back ");
		
	}
	public void pageRefresh() {
		driver.navigate().refresh();
		extTest.log(Status.INFO, "page navigate refresh "); // when page is refresh you need to make again WebElement other wise got > StaleElemenetRefrenceException
		
	}
	
	public void openUrl(String url) {
		try {
		driver.get(url);
		extTest.log(Status.INFO, url+ "  Url hit in browser successfully..");
		}catch(NullPointerException e) {
			
				throw e;
				
			}catch(Exception e) {
				throw e;
				
			}
			
			
		}
	   // this method will return page title.
	  public String getTitle() {
		  String title=driver.getTitle();
		 
		  extTest.log(Status.INFO, "geting title successfully..");
		  
		  return title;
		  
	  }
	  // this method will give you page url.
	  public String getUrl() {
		String pageUrl=  driver.getCurrentUrl();
		extTest.log(Status.INFO, "page Url getting successfully..");
		return pageUrl;
		  
	  }
	  
	  public String getAttributeValue(WebElement we,String attributeName) {
		  
		 String attrValue= we.getAttribute(attributeName);
		  extTest.log(Status.INFO, "getting attribute value successfully.. ");
		  return attrValue;
	  }
	
	
	
		 	 
	 
	 
	 
	 // this method will give you single WebElement.
	public WebElement findElement(String xpath) {
		   WebElement we =null;
		try {
		we= driver.findElement(By.xpath(xpath)); 
		 extTest.log(Status.INFO, " element found successfully.");
		}
		 //return we;  
		catch(NoSuchElementException e){
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		    we=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			//return we;
		    extTest.log(Status.INFO, " element found successfully.");
			
		}catch(InvalidSelectorException e){
			 extTest.log(Status.INFO, "Element not found xpath syntax is wrong..");
			  throw e;
			
		}catch(Exception e) {
			  throw e;  // it means code will not execute for further except.  it will print exception
			
			
		}
		
		 return we;   // if you are writing at the end of code > return we. so no need to write in try{} and catch(){} block- return.
		
	}

	
	
	// this method will click all elements one by one
	  public void clickAllElements(String xpath) {
		  List<WebElement> elementsArray=driver.findElements(By.xpath(xpath));
		  for(WebElement element :elementsArray) {
			  element.click();
			  
		   extTest.log(Status.INFO, "clicked on "+element.getText()+" is successfully..");
		  }
		   
	  }
	  // getting all elements text.
	  public List<String> getAllElementsText(String xpath) {
		  List<WebElement> elementsArray=driver.findElements(By.xpath(xpath));
		  List<String> elementstextList= new ArrayList<String>();
		   for(WebElement element :elementsArray) {
                String elementInnerText=element.getText();
                elementstextList.add(elementInnerText);
	       }
		  return elementstextList;
	  }
	  
	  
	
	public void sendKeys(WebElement we,String value,String elementName) {
		
		try {
		we.sendKeys(value); 
		System.out.println(value+" value filled in input box.");
		}catch(ElementClickInterceptedException e) {
			JavascriptExecutor jse =(	JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value='"+value+"'", we);
			System.out.println(value+"  filled in" +elementName+" input box.");
		}
		catch(ElementNotInteractableException e) {
			JavascriptExecutor jse =(	JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value='"+value+"'", we);
			System.out.println(value+" value filled in input box.");
		}catch(Exception e) {
			e.printStackTrace(); // it's only for printing and it will not stoped code 
			throw e;             // it will be print and as well as stop code not run further steps.
			
					}
		
	}
	// (sendKeys) by Javascript but hear - value 
	
	public void  sendKeysByJs(WebElement we,String value,String elementName){
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
		   jse.executeScript("arguments[0].value='"+value+"'", we);
		  
		   extTest.log(Status.INFO,"valued filled on " +elementName+ "is successfully..");
		  
	  }
	
	
	
	// it;s click of WebElement .
	public void click(WebElement we ,String elementName ) {
		try {
		we.click();

		 extTest.log(Status.INFO, "click on" +elementName+" elment is succesfully.");
		}catch(ElementClickInterceptedException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", we);
			extTest.log(Status.INFO, "click on" +elementName+" elment is succesfully.");
		}
		catch(ElementNotInteractableException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", we);
			extTest.log(Status.INFO, "click on" +elementName+" elment is succesfully.");
		}
		
		catch(Exception e) {
			
			throw e;
			
		 }
		
		  }
	
	  // click on element by Javascript .
	
	   public void clickByJs(WebElement we,String elementName) {
		   JavascriptExecutor jse=(JavascriptExecutor) driver;
		   jse.executeScript("arguments[0].click();", we);
		
		   extTest.log(Status.INFO, "clicked on " +elementName+" is successfully..");
		   
		   
		   
		   
	   }
	 
	   
		   
	   
	   // 
	   public void clickByActions(WebElement we,String elementName) {
		     Actions act= new Actions(driver);
		     act.click(we).perform();
		     
		     extTest.log(Status.INFO, "click on " +elementName+"element is succesfully.");
		   
	   }
	
	
	public void selectByVisibleTextdropdown(WebElement we,String value,String elementName) {
		try {
		Select drp = new Select(we);
		drp.selectByVisibleText(value);
		System.out.println("select text " +elementName+" in dropdown is succesfully.");
		}catch(Exception e) {
			throw e;
			
		}
		
		
			}
	
	public void selectByValuedropdown(WebElement we,String attributeValue,String elementName) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(we));
		Select drp = new Select(we);
		drp.selectByValue(attributeValue); 
		System.out.println("select value  " +elementName+" drpDown is succesfully.");
		// attrbute = attr
		}catch(Exception e) {
			throw e;
		}
			}
	
	
	  public void iframeHandling(String idOrName,String elementName) {
		  // if iframe not found then Exception =  NoSuchFrameException. it means iframe is not exits.
		  driver.switchTo().frame(idOrName);
		   System.out.println("switch on " +elementName+"frame is successfully..");
		  
	  }
	  
	  
    public void iframeHandling(WebElement we,String elementName) {
		  
		  driver.switchTo().frame(we);
		  System.out.println("switch on " +elementName+"frame is successfully..");
	  }
    
    public void framesSwitchingOnParentFrm() {
    	   driver.switchTo().parentFrame();
    	   System.out.println("switching on parent frame is successfully..");
    	
    }
    public void switchTodefaultContent() {
    	
    	  driver.switchTo().defaultContent();
    	  System.out.println("switch on main page /dom  is successfully..");
    }
    
    // window handling method
    // window handling by page Title.
    public void windowHandlingByTitle(String pageTitle) {
    	Set<String> handelsValue=driver.getWindowHandles();
    	for(String handleValue:handelsValue) {
    		driver.switchTo().window(handleValue);
    		String title=driver.getTitle();
    		if(title.equalsIgnoreCase(pageTitle)) {
    			System.out.println("focused switched on window - it's title is - "+pageTitle);
    			break;
    		}
    		
    		
    	}}
    	 // switching on window by Url.
    	  public void windowHandlingByUrl(String pageUrl) {
    	    	Set<String> handelsValue=driver.getWindowHandles();
    	    	for(String handleValue:handelsValue) {
    	    		driver.switchTo().window(handleValue);
    	    		String url=driver.getCurrentUrl();
    	    		if(url.equalsIgnoreCase(pageUrl)) {
    	    			System.out.println("focused switched on window - it's URL is - "+pageUrl);
    	    			break;
    	    		}
    	    		
    	    		
    	    	}
    	
    }
    
    public void scrollToElement(WebElement we,String elementName) {
    	
    	 Actions act= new Actions(driver);
    	   act.scrollToElement(we).build().perform();
    	   System.out.println("scrolled on " +elementName+"element is successfully..");
    }
    
    
    public void scrollIntoView(WebElement we,String elementName) {
    	
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", we);
        System.out.println("scrolled on " +elementName+"element is successfully..");
    }
    // hear i am little bit confused how we will pass value in method.
    public void scrollToByjs(int x ,int y) {
     JavascriptExecutor jse =(JavascriptExecutor) driver;
      jse.executeScript("window.scrollTo("+x+","+y+")");
    	System.out.println("scrolled successfully..");
    }
    public void scrollToBottomJs() {
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	jse.executeScript("doucument.body.scrollHeight");
    	System.out.println("scrolled into bottom is successfully..");

    	
    }
    
    
    public void scrollByAmount(int x,int y) {
    	Actions act= new Actions(driver);
    	act.scrollByAmount(x, y).perform();
    	System.out.println("scrolled  by amount is successfully..");
    	
    }
   
    // mouse and keybord action
    public void rightClick(WebElement we,String elementName) {
    	Actions act = new Actions(driver);
    	act.contextClick(we).build().perform();
    	System.out.println(" right click on" +elementName+" element is successfully..");
    	
    }
      
    public void mouseHover(WebElement we,String elementName) {
    	
    	Actions act = new Actions(driver);
    	act.moveToElement(we).build().perform();
    	System.out.println(" mouse hover on " +elementName+"element is successfully..");
    	
    }
    
    public void dragAndDrop(WebElement sorce,WebElement target) {
    	Actions act = new Actions(driver);
    	act.dragAndDrop(sorce, target);
    	System.out.println("draged and droped is successfully..");
    	
    	
    }
    
     public void dragAndDropWithoutUsingMethod( WebElement sorce,WebElement target) {
       Actions act = new Actions(driver);
    	 act.clickAndHold(sorce).moveToElement(target).release().build().perform();
    	 System.out.println("draged and droped is successfully..");
    	
     }
     
      public void doubleClickOnElement(WebElement we,String elementName) {
    	  Actions act = new Actions(driver);
    	  act.doubleClick(we).build().perform();
    	  System.out.println("double click " +elementName+"on element is successfully");
    	  
      }
        //screenshot of full page.  
       // When we want want to take screen shot so we need to down casting and down casting is only possible when you firstly upcasting .
      
    
      public void takeScreeShotFullpage(String filePath) {
    		TakesScreenshot screenShot = (TakesScreenshot) driver;
   		 File srcFile= screenShot.getScreenshotAs(OutputType.FILE);
   		 File  targetFile=new File(filePath+"image.png");
   		 try {
   			Files.copy(srcFile.toPath(), targetFile.toPath());
   		} catch (IOException e) {
   			
   			e.printStackTrace();
   		} }
      
      public String takeScreenShot() {
    	  String imageCode =null;
    	  try {
    	 
    		  TakesScreenshot ts= (TakesScreenshot) driver;
    	     imageCode= ts.getScreenshotAs(OutputType.BASE64); 
    	  
    	  }catch(Exception e) {
    		  
    		 extTest.log(Status.FAIL, e.getMessage()); 
    	  }
    	   
    	  return imageCode;
    	   
    	  
      }
      
      
      
      // screenshot of specfic element.
      public void takeScreenShotElement(WebElement we,String filePath) {
    	File srcFile= we.getScreenshotAs(OutputType.FILE);
    	 File trgtFile = new File(filePath);
    	 
    	 try {
			Files.copy(srcFile.toPath(), trgtFile.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
      }
    	 
    	  
    // wait force fully means static wait it's provided by java
      public void staticWait(int timeInSecond) {
    	  
    	  try {
    	  Thread.sleep(timeInSecond*1000); 
    	  }catch(InterruptedException e) {
    		  e.printStackTrace();
    		  
    		  
    	  }
    	  
    	  
      }
      
      public void waitForVisibility(WebElement we,int timeOut) {
   	   
      	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
                 wait.until(ExpectedConditions.visibilityOf(we));
                 
                 
         }
    	  
       public void waitForEnabling(WebElement we,int timeOut) {
    	   
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
               wait.until(ExpectedConditions.elementToBeClickable(we));
               
               
       }
       
       public void waitForText(WebElement we,int timeOut,String text) {
    	   
       	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
                  wait.until(ExpectedConditions.textToBePresentInElement(we,text));
                  
                  
          }
       
      // it will wait until any element is invisibility.>  wait until ok = button disapper.
       public void waitForInVisibility(WebElement we,int timeOut) {
       	   
         	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
                    wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(we)));
                    
                    
            }
         // it will wait until an element will be disabled it means > you are clicking on next button so this method will wait next-button will be disabled.
       public void waitForDisabling(WebElement we , int timeOut) {
    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
           wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(we)));
       }
      
       // 
       public void pageLoadTimeOut(int timeOut) {
    	   
    	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
    	   
    	   
       }
       
       public boolean getElementDisplayedStatus(WebElement we) {
    	    
    	 Dimension dm =  we.getSize();
    	   boolean status=false;
    	 if(dm.getHeight()>0 && dm.getWidth()>0) {
    		  status=true;
    		   
    	   }
    	 return status;
    	   
    	   
       }
       
       public void validateInnerText(WebElement we,String expectedText) {
    	  String actualText = we.getText();
    	   if(actualText.equalsIgnoreCase(expectedText)) {
    		    System.out.println("Passed. actual - "+actualText+" && expeced - "+expectedText);
    		    
    	   }else {
    		   
    		   System.out.println("Failed. actual - "+actualText+" && expeced - "+expectedText);
    	   }
    	   
       }
       
       public void validateAttribute(WebElement we,String expectedAttribute,String attributeName) {
     	  
    	   String actualAttribute = we.getAttribute(attributeName);
     	   
     	  if(actualAttribute.equalsIgnoreCase(attributeName)) {
     		    System.out.println("Passed. actual - "+actualAttribute+" && expeced - "+expectedAttribute);
     		    
     	   }else {
     		   
     		   System.out.println("Failed. actual - "+actualAttribute+" && expeced - "+expectedAttribute);
     	   }
     	   
        }
       
       public void validateElementIsVisible(WebElement we) {
    	  boolean actualStatus = we.isDisplayed();
    	   
    	   if(actualStatus==true) {
    		    System.out.println("Passed. actual - "+actualStatus+" && expeced - true ");
    		    
    	   }else {
    		   
    		   System.out.println("Failedd. actual - "+actualStatus+" && expeced - false ");
    	   }
    	   
       }
       
       public void validateElementIsInVisible(WebElement we) {
     	  boolean actualStatus = we.isDisplayed();
     	   
     	   if(actualStatus==false) {
     		    System.out.println("Passed. actual - "+actualStatus+" && expeced - false ");
     		    
     	   }else {
     		   
     		   System.out.println("Failed. actual - "+actualStatus+" && expeced - false ");
     	   }
     	   
        }
       
       
       
       public void validateElementIsEnabled(WebElement we) {
      	  boolean actualStatus = we.isEnabled();
      	   
      	   if(actualStatus==true) {
      		    System.out.println("Passed. actual - "+actualStatus+" && expeced - true ");
      		    
      	   }else {
      		   
      		   System.out.println("Failed. actual - "+actualStatus+" && expeced - true ");
      		   
      	   }
      	   
         }
       
       
       public void validateElementIsDisabled(WebElement we) {
       	  boolean actualStatus = we.isEnabled();
       	   
       	   if(actualStatus==false) {
       		    System.out.println("Passed. actual - "+actualStatus+" && expeced - false ");
       		    
       	   }else {
       		   
       		   System.out.println("Failed. actual - "+actualStatus+" && expeced - false ");
       		   
       	   }
       	   
          }
       
       
       public void validatePageTitle(String expTitle) {
    	 String actualTitle = driver.getTitle();
    	   if(actualTitle.equalsIgnoreCase(expTitle)) {
    		   
    		   System.out.println("Passed. actual title- "+actualTitle+" && expected title - "+expTitle);
    	   }else {
    		   System.out.println("Failed. actual title- "+actualTitle+" && expected title - "+expTitle);
    	   }
    	   
       }
    
       
       public void validatePageUrl(String expUrl) {
      	 String actualUrl = driver.getCurrentUrl();
      	   if(actualUrl.equalsIgnoreCase(expUrl)) {
      		   
      		   System.out.println("Passed. actual Url - "+actualUrl+" && expected title - "+expUrl);
      	   }else {
      		   System.out.println("Failed. actual Url - "+actualUrl+" && expected title - "+expUrl);
      	   }
      	   
         }
       
       
       
       public void validateDropDownSelectedText(WebElement we) {
    	   
    	   Select sel = new Select(we);
    	   sel.getFirstSelectedOption();
    	   
       }
}
