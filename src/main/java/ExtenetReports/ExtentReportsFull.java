package ExtenetReports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsFull {

	
	public static ExtentReports generateReports() {
		ExtentReports ETR=new ExtentReports();
		ExtentSparkReporter ESR=new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\sparkReport.html");
		ESR.config().setTheme(Theme.DARK);
		ESR.config().setReportName("Abzal");
		ESR.config().setDocumentTitle("FLIGHT BOOKING TEST");
		ESR.config().setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
		ETR.attachReporter(ESR);
		
		Properties p=new Properties();
		File pf=new File("./src/main/java/Config/configuration.properties");
		FileInputStream FIS=null;
		try {
			FIS=new FileInputStream(pf);
			p.load(FIS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ETR.setSystemInfo("os", System.getProperty("os.name"));
		ETR.setSystemInfo("os", System.getProperty("java.version"));
		ETR.setSystemInfo("URL", p.getProperty("url"));
		return ETR;
		
	}
	
	

}
