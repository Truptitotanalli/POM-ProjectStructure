package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuotePage {

	WebDriver driver;
	public  QuotePage(WebDriver driver) {
		this.driver=driver;
	}
	By QuoteHeader = By.xpath("//div[@class='hero']");
	
	
	public String Quotepagenaviagtion() {
	WebElement errormsg =	driver.findElement(QuoteHeader);
	if(errormsg.isDisplayed()) {
		errormsg.getText();
	}
	return null;
	}
	
	
	public boolean QuotehearderisDisplayed() {
		return driver.findElement(QuoteHeader).isDisplayed();
	}
}
