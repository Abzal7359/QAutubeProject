package ListenersFull;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtenetReports.ExtentReportsFull;

public class Listener implements ITestListener {
	ExtentReports extent;
	ExtentTest extenttest ;
	
	@Override
	public void onStart(ITestContext context) {
		extent=ExtentReportsFull.generateReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		extenttest = extent.createTest(result.getName());
		extenttest.log(Status.INFO, result.getName()+"  Test is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.log(Status.PASS, result.getName()+"Test Succes");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extenttest.log(Status.FAIL, result.getName()+"Test Failed");
	}

	

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		try {
			Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\sparkReport.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
