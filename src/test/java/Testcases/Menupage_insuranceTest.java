package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import Baseclass.BaseTest;
import POM.Menupage_insurance;

public class Menupage_insuranceTest extends BaseTest{
	 
	
	@Test
	public void Menupage_insurancetab() throws IOException, InterruptedException {
		Menupage_insurance in = new Menupage_insurance(getDriver());
		in.Insurance_menu();
		
		
	}

	
	
}
