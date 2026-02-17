package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseEvents {
	
	public WebDriver driver;
	  static Actions a;
	
	public MouseEvents(WebDriver driver){
		this.driver=driver;
		 MouseEvents.a = new Actions(driver); 
	}
	
	
	
	   public static WebElement moveToElement(WebElement ele) {
		    
	       a .moveToElement(ele)
	        .pause(Duration.ofMillis(300))
	        .perform();
		   return ele;
	    }
	

}
