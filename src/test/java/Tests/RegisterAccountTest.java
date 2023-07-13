package Tests;

import pageObjectModel.RegsiterPOM;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base1;

public class RegisterAccountTest extends Base1 {
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver=initialise();
		driver.findElement(By.linkText("Register")).click();
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void registerAccount() throws InterruptedException {
		RegsiterPOM RG=new RegsiterPOM(driver);
		
//		driver.findElement(By.id("name")).sendKeys(data.getProperty("name"));
		RG.EnterName(data.getProperty("name"));
//		driver.findElement(By.id("email")).sendKeys(data.getProperty("email"));
		RG.EnterEmail(data.getProperty("email"));
		RG.EnterContact(data.getProperty("contact"));
		RG.EnterPasword(data.getProperty("password"));
		WebElement Dropdown=driver.findElement(By.xpath("//select[@name='gender']"));
		Select DP=new Select(Dropdown);
		DP.selectByVisibleText(data.getProperty("Gender"));
		

		driver.findElement(By.xpath("//input[@id='popupDatepicker']")).click();
		WebElement monthSelection=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select MOSELECT=new Select(monthSelection);
		MOSELECT.selectByVisibleText(data.getProperty("DOBmonth"));
		
		WebElement yearSelection=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select YRSELECT=new Select(yearSelection);
		YRSELECT.selectByVisibleText(data.getProperty("DOByear"));
		
		List<WebElement> dates=driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		for (WebElement day : dates) {
			String Datee=day.getText();
			if(data.getProperty("DOBdate").equalsIgnoreCase(Datee)) {
				driver.findElement(By.linkText(Datee)).click();
				break;
				
			}
			
		}
		driver.findElement(By.id("flexCheckChecked")).click();
		driver.findElement(By.xpath("//input[contains(@class,'btn-register')]")).click();
		
	}
	
//	@Test(priority = 1)
//	public void CheckRegisteredORnot() {
//		
//		String actuall=(driver.findElement(By.xpath("//h4[1]")).getText());
//		String Expect="Congratulations, You have successfully Registered. Please login below.";
//		assertEquals(actuall,Expect,"already registerd");
//	}

}
