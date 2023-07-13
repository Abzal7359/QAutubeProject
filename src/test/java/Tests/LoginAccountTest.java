package Tests;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base1;
import pageObjectModel.LoginPOM;

public class LoginAccountTest extends Base1 {
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		driver=initialise();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public  void loginResgisterdAccount() throws InterruptedException {
		LoginPOM LN=new LoginPOM(driver);
		LN.EnterEmail(data.getProperty("email"));
		LN.EnterPassword(data.getProperty("password"));
		LN.LoginClick();
		String Expected="Welcome Abzal hussain";
		String actuall=driver.findElement(By.xpath("//ul//li[text()=' Welcome ']")).getText();
		assertEquals(actuall, Expected);
		
		
		
		logout();
		Thread.sleep(3000);
		
	}
	
	

}
