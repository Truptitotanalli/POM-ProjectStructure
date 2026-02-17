package Baseclass;

import org.openqa.selenium.WebDriver;

import POM.LoginTestpage;
import utilities.MouseEvents;
import utilities.ScreenshotUtil;
import utilities.Waits;
import utilities.scrolling;

public class BaseUtility {

	
    protected WebDriver driver;

    protected Waits waits;
    protected scrolling scroll;
    protected MouseEvents mouse;
    protected ScreenshotUtil screenshot;
    protected LoginTestpage logintest;

    public BaseUtility(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
        this.scroll = new scrolling(driver);
        this.mouse = new MouseEvents(driver);
        this.screenshot = new ScreenshotUtil(driver);
        this.logintest = new LoginTestpage(driver);
    }
}

