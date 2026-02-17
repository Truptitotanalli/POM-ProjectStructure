package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Baseclass.BaseTest;

public class ListenersClass implements ITestListener {

	    ExtentReports extent = ExtentManager.getReportInstance();
	    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
	        test.set(extentTest);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.get().pass("Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	if (result.getStatus() == ITestResult.FAILURE && result.getMethod().getRetryAnalyzer(result) != null) {
	    		   // skip logging until final retry completed
	    		}
	    	Log.logger.info("failed tc are checked again");
	    	test.get().fail(result.getThrowable());

	        String screenshotPath = null;
			try {
				screenshotPath = ScreenshotUtil.takeFullPageScreenshot((WebDriver) BaseTest.getDriver(),
				        result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        try {
	            test.get().addScreenCaptureFromPath(screenshotPath);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.get().skip("Test Skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
	}

