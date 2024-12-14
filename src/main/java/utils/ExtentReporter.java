package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;

public class ExtentReporter {
	public ExtentHtmlReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;
	public AppiumDriver driver;
	
	public ExtentReporter(AppiumDriver driver)
	{
		this.driver = driver;
	}
	
	public void GenerateReports(String ReportName)
	{
		 reporter = new ExtentHtmlReporter(".//Reports//"+ReportName+".html");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
	}
	
	public void FlushReports()
	{
		reports.flush();
		
	}
	public void CreateTest(String testname, String testdesc)
	{
		test = reports.createTest(testname, testdesc).assignAuthor("Venky").assignDevice("Windows 11");
	}
	
	public void TestPASS(String msg)
	{
		try
		{
		LogManager.logger.info(TakeScreenshotForReports().toString());
		test.pass(msg, MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenshotForReports()).build());
		LogManager.logger.info("Report Written for PASS");
		}
		catch(Exception e)
		{
			LogManager.logger.info("Failure in Writing Report for PASS");
			e.printStackTrace();
		}
	}
	public void TestFAIL(String msg)
	{
		try
		{
		test.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenshotForReports()).build());
		LogManager.logger.info("Report Written for FAIL");
		}
		catch(Exception e)
		{
			LogManager.logger.info("Report Written for FAIL");
			e.printStackTrace();
		}
	}
	public static double GenerateRandomNum()
	{
		double random = Math.random();
		random = random * 999999;
		return random;
	}
	public String TakeScreenshotForReports()
	{
		try
		{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
	    File target = new File (".\\RepScn\\"+GenerateRandomNum()+".png");
	    String targetpath = target.getAbsolutePath();
	    FileUtils.copyFile(Source, target);
	    LogManager.logger.info("Screenshot is success");
	    return targetpath;
	    
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			LogManager.logger.error("Failed to take screenshot");
			return null;
		}
		
	}

}
