package Testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.BaseTest;
import POM.Homepage;

@Test(priority=1)
public class HomepageTest extends BaseTest {
	
	
	@Test
	public void naviagteToHomeScreen() throws Exception {

	    Homepage home = new Homepage(getDriver());

	    home.handlepopup_onHomeScreen();
	}
	    
	@Test(priority=2)
	public void clickOnProduct() throws IOException {

	    Homepage home = new Homepage(getDriver());

	    boolean isProductFound = home.scrollToProductElement();

	    Assert.assertTrue(isProductFound,
	            "Auto insurance product not found on Home page");
	}
	
	    
	    @Test(priority=3)
	    public void selectTheProduct() throws Exception {
	    	
	    	 Homepage h = new Homepage(getDriver());
	    
	    h.selectProduct();
	}
	}


	

