package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name = "excelData")
	public Object[][] getData() throws IOException {

	    String path = System.getProperty("user.dir") +
	            "/src/test/resources/TestData.xlsx";

	    System.out.println("USER DIR = " + System.getProperty("user.dir"));
	    System.out.println("EXCEL PATH = " + path);

	    return ExcelUtility.getExceldata(path, "Sheet1");
	}


}
