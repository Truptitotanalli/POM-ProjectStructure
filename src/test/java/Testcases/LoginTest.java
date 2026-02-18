package Testcases;

import org.testng.annotations.Test;


import Baseclass.BaseTest;
import POM.LoginTestpage;
import utilities.DataProviderClass;
import utilities.Log;

public class LoginTest extends BaseTest{

	
	@Test(dataProvider = "excelData", dataProviderClass = DataProviderClass.class,retryAnalyzer = utilities.RetryAnalyzer.class)
	public void loginTest(String user, String pass) {
	    LoginTestpage loginPage = new LoginTestpage(getDriver());
	   
	    loginPage.login(user, pass);
	    Log.logger.info("checking jenkins job");
	    Log.logger.info("connection between github and jenkins");
	}
	
}
