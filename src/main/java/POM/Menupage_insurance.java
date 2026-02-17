package POM;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Baseclass.BaseUtility;
import utilities.ScreenshotUtil;
import utilities.Waits;

public class Menupage_insurance extends BaseUtility{

	
	By popup= By.xpath("//div[@id='onetrust-banner-sdk']");
	By acceptCookies = By.xpath("//button[contains(text(),'Accept') or contains(text(),'Continue')]");
	//By insuranceMenu = By.xpath("//a[normalize-space()='Insurance & more']");
	By insuranceMenu = By.xpath("(//a[contains(@aria-label,'Insurance & more')])[1]");
	By vehicleMenu = By.xpath("//a[normalize-space()='Vehicle']");
	By BoatMenu = By.xpath("//ul[contains(@class,'nav-list level-1')]//a[contains(text(),'Boat')]");
	
	
	public Menupage_insurance(WebDriver driver) {
		super(driver);
	}
	
	public void Insurance_menu() throws IOException, InterruptedException {
	try {
        if (driver.findElement(popup).isDisplayed()) {
            driver.findElement(acceptCookies).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }
    }catch (Exception e) {
        e.printStackTrace(); 
        throw e; 
    }

	
	WebElement insuranceAndmore = Waits.waitForVisibility(insuranceMenu);
	insuranceAndmore.click();
	WebElement vehicle = Waits.waitForVisibility(vehicleMenu);
	vehicle.click();
	WebElement selectboat = Waits.waitForVisibility(BoatMenu);
	
	ScreenshotUtil.customizeScreenshot(driver, selectboat, "css");
	Thread.sleep(4000);
	ScreenshotUtil.captureScreenshot(driver, "BoatMenu");
	selectboat.click();
			
	}
	
	       
	    }
	

	
	
	
	
	

