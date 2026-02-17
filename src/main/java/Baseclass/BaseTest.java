package Baseclass;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Log;

public class BaseTest {

	

	    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    public static WebDriver getDriver() {
	        return driver.get();
	    }

	    public static void setDriver(WebDriver driverRef) {
	        driver.set(driverRef);
	    }

	    @BeforeMethod
	   
	    public void setup() {
	    	Log.logger.info("Browser setup started");
	    	  WebDriver driverInstance = null; 
	    	  String browser = System.getProperty("browser", "chrome");
	    	  boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
	    	
	    	
	          // chrome is default if not provided


	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            ChromeOptions options = new ChromeOptions();
	            Log.logger.info("Browser selected: " + browser);

	            if (headless) {
	                options.addArguments("--headless=new");
	                options.addArguments("--window-size=1920,1080");
	                Log.logger.info("Headless mode: " + headless);
	            }
	            driverInstance  = new ChromeDriver(options);
	        } 
	        else if (browser.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            FirefoxOptions options = new FirefoxOptions();
	            Log.logger.info("Browser selected: " + browser);

	            if (headless) {
	                options.addArguments("-headless");
	                Log.logger.info("Headless mode: " + headless);
	            }
	            driverInstance = new FirefoxDriver(options);
	        } 
	        else if (browser.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            EdgeOptions options = new EdgeOptions();
	            Log.logger.info("Browser selected: " + browser);

	            if (headless) {
	                options.addArguments("--headless");
	                Log.logger.info("Headless mode: " + headless);
	                
	            }
	            driverInstance = new EdgeDriver(options);
	        }
	        setDriver(driverInstance);
	        Log.logger.info("Launching browser");

	        getDriver().manage().window().maximize();
	        getDriver().get("https://www.allstate.com/");
	        Log.logger.info("Navigated to URL: https://www.allstate.com");
	    }

	    @AfterMethod
	    public void tearDown() {
	        getDriver().quit();
	        Log.logger.info("Closing browser");
	        driver.remove();
	    }
	}
