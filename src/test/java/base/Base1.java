package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Base1 {
	WebDriver driver;
	public Properties prop;
	public Properties data;
	
	
	public  Base1() {
		prop= new Properties();
		File IF=new File("./src/main/java/Config/configuration.properties");
		FileInputStream FIS;
		try {
			FIS = new FileInputStream(IF);
			try {
				prop.load(FIS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		data=new Properties();
		File IFL=new File("./src/main/java/Config/RegisterDetails.properties");
		FileInputStream FISL;
		try {
			FISL = new FileInputStream(IFL);
			try {
				data.load(FISL);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public  WebDriver initialise() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public void logout() {
		Actions act=new Actions(driver);
		act
		.moveToElement(driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[3]/ul/li[2]/div/a/i")))
		.moveToElement(driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[3]/ul/li[2]/div/ul/li[5]/a/i")))
		.click()
		.perform();
	}
	
	

}
