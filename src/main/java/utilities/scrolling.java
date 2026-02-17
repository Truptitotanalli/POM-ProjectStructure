package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class scrolling {

   static WebDriver driver;
  static scrolling scroll;

    public scrolling(WebDriver driver) {
    	scrolling.driver = driver;
    }


    public static WebElement scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
        	    "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
        	    element
        	);
		return element;
    }
    
 
}
