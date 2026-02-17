package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	


	    private static ExtentReports extent;

	    public static ExtentReports getReportInstance() {

	        if (extent == null) {

	            ExtentSparkReporter reporter =
	                    new ExtentSparkReporter("./test-output/ExtentReport.html");

	            reporter.config().setReportName("Automation Test Report");
	            reporter.config().setDocumentTitle("Execution Report");

	            extent = new ExtentReports();
	            extent.attachReporter(reporter);

	            extent.setSystemInfo("OS", "Windows");
	            extent.setSystemInfo("Tester", "Trupti");
	            extent.setSystemInfo("Framework", "Selenium + TestNG");
	        }

	        return extent;
	    }
	}


