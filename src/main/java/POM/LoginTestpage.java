package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Baseclass.BaseUtility;
import utilities.Log;

public class LoginTestpage extends BaseUtility{

	
	public LoginTestpage(WebDriver driver) {
		super(driver);
		
	}


	
	
	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("login");
	public void login(String user, String pass) {
	    driver.findElement(username).sendKeys(user);
	    Log.logger.info("Entering username: " + username);
	    driver.findElement(password).sendKeys(pass);
	    Log.logger.info("Entering password");

	    driver.findElement(loginBtn).click();
	}

}
