package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.BaseTest;
import POM.QuotePage;

public class GetQuoteTest extends BaseTest {
	

	@Test
public void verifyQuotepage() throws InterruptedException {
	
	
	QuotePage qp = new QuotePage(getDriver());
	Assert.assertTrue(qp.QuotehearderisDisplayed(),"quotepage is displayed");
	Thread.sleep(5000);
	String heardermsg = qp.Quotepagenaviagtion();
	System.out.println("hearder msg :" + heardermsg);
	
}
}


