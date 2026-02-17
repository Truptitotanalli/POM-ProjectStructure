package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Object[][] getExceldata(String filepath, String sheetName) throws IOException{
		
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		  XSSFSheet sheet = book.getSheet(sheetName);
		  
		  int rowcount = sheet.getPhysicalNumberOfRows();
		  int colcount = sheet.getRow(0).getLastCellNum();
		  
		  Object[][] data=new Object[rowcount-1][colcount];
		  
		  for(int i=1;i<rowcount;i++) {
			  for(int j=0;j<colcount;j++) {
				  data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			  }
		  }
		  book.close();
		  fis.close();
		  return data;
	
		  }
}
