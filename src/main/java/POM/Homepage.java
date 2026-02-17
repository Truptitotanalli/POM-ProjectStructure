package POM;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.BaseUtility;
import utilities.MouseEvents;
import utilities.ScreenshotUtil;
import utilities.Waits;
import utilities.scrolling;

public class Homepage extends BaseUtility{
	
	
	public Homepage(WebDriver driver) {
		super(driver);
		
	}


	
	
	By popup= By.xpath("//div[@id='onetrust-banner-sdk']");
	By acceptCookies = By.xpath("//button[contains(text(),'Accept') or contains(text(),'Continue')]");



	
	public void handlepopup_onHomeScreen() throws Exception {
	    try {
	        if (driver.findElement(popup).isDisplayed()) {
	            driver.findElement(acceptCookies).click();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            ScreenshotUtil.takeFullPageScreenshot(driver, "takenFullss");
	        }
	    }catch (Exception e) {
	        e.printStackTrace(); 
	        throw e; 
	    }
	}


	 By EnterZipcodeInput = By.xpath("(//input[contains(@placeholder,'Enter ZIP')])[3]");
	
	 By selectproductdropdown = By.xpath("(//button[contains(@class,'icon-dropdown__btn')])[2]");
	 By ClickOnGo = By.xpath("(//a[text()='go'])[2]");
	 By selectoptionfromdropdown = By.xpath("//div[contains(@class,'icon-dropdown__dropdown')]//li");

	 
	public void selectProduct() throws Exception  {
		
		handlepopup_onHomeScreen();
		
		WebElement zipcode = Waits.waitForVisibility(EnterZipcodeInput);
		scrolling.scrollToElement(zipcode);
		
		 zipcode.isDisplayed();
		  zipcode.clear();
		   Waits.waitForSeconds(4);
		   zipcode.sendKeys("45678");
		          
		            Waits.waitForVisibility(selectproductdropdown);
		           
		          
		            driver.findElement(selectproductdropdown).click();
		            
	   List<WebElement> productdrop = Waits.waitForVisibilityOfAll(selectoptionfromdropdown);
	   
	   System.out.println("Dropdown values count: " + productdrop.size());
	   for (WebElement product : productdrop) {

	        String text = product.getText().trim();
	        System.out.println("Checking: " + text);

	        if (text.equalsIgnoreCase("Travel insurance")) {

	            scrolling.scrollToElement(product);
	            product.click();

	            ScreenshotUtil.customizeScreenshot(driver, product, "Travel_Insurance_Selected");

	            break;
	        }
		}

	   
	}
			
	
	
	/*public By productByName(String productName) {
	    return By.xpath("//div[contains(normalize-space(text()),'" + productName + "')]");
	}

	By productElement = By.xpath("//h2[contains(text(),'Products') or contains(text(), 'services')]");
	
	
	By productlistarrow = By.xpath("//button[contains(@class,'slick-arrow')]//span[1]");  */ 
	By productNames = By.xpath("(//div[@class='slick-list'])[1]"); 
	
	By productSlides = By.xpath(
	    "(//div[@class='slick-list'])[1]//div[contains(@class,'slick-slide')]"
	);
	
	By combinedXpath = By.xpath(
		    "(//h2[contains(normalize-space(),'Products') or contains(normalize-space(),'services')]" +
		    "/following::button[contains(@class,'slick-arrow')])[1]"
		);

			
	public boolean scrollToProductElement() throws IOException {

	  
	    WebElement productSection = Waits.waitForVisibility(combinedXpath);
	    scrolling.scrollToElement(productSection);
	    
	    Waits.waitForSeconds(4);
	   
	  
	    Waits.waitForVisibility(productNames);
	    		List<WebElement> productSlides = driver.findElements(productNames);
	    System.out.println("Products found: " + productSlides.size());
	   
	    for (WebElement product : productSlides) {
 
	        if (product.getText().trim().contains("Homeowners insurance")) {

	        	Waits.elementToBeClickable(product).click(); 
	        	 
	            return true;
	        }
	      
	    }
	   
	    return false;
	   

	}

			}

	



	
