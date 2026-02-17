package utilities;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	  static WebDriver driver;
	
	public Waits(WebDriver driver) {
		Waits.driver=driver;
	}
	
public static void ImplicitWait() {
	try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static void waitForSeconds(int seconds) {
    try {
        Thread.sleep(seconds * 1000L);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}



public static WebElement waitForVisibility(By locator) {
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
	return w.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}



public static WebElement elementToBeClickable(WebElement product) {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

return wait.until(ExpectedConditions.elementToBeClickable(product));
}



public static List<WebElement> waitForVisibilityLocatedBy(By locator) {
	WebDriverWait wa = new WebDriverWait(driver, Duration.ofSeconds(30));
	return wa.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}


public static WebElement waitForVisibility(WebElement e) {
	WebDriverWait wa = new WebDriverWait(driver, Duration.ofSeconds(600));
	return wa.until(ExpectedConditions.visibilityOf(e));

	}

public static List<WebElement> waitForVisibilityOfAll(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
}

public static WebElement elementToBeClickable(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
}
	

}


