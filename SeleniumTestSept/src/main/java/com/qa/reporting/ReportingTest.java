package com.qa.reporting;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportingTest implements ITestListener{

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent ;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("on test start");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success");
		 test =extent.createTest(result.getName());
		 test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("on test failure");
		test =extent.createTest(result.getName());
		 test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			try {
				String screenshot=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
				File file=new File(screenshot);
				if (file.exists()) {
					test.fail("screenshot"+test.addScreenCaptureFromPath(screenshot));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("on test skipped");
		test =extent.createTest(result.getName());
		 test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on test failure");
		
	}

	@Override
	public void onStart(ITestContext context) {
		String timeStamp =new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date(0));
		String repName="Test-Report"+timeStamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlReporter.config().setDocumentTitle("Automation Reporting");
		htmlReporter.config().setReportName("Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("OS", "Windows11");
		extent.setSystemInfo("user", "Pranitha");
		extent.setSystemInfo("Browser", "Chrome");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on test finish");
		extent.flush();
		
	}
	
	
	

}
