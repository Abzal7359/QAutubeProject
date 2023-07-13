package Tests;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import base.Base1;

public class BookTicketTest extends Base1{
	public WebDriver driver;
	
	
	@BeforeClass
	public void setup() {
		driver= initialise();
		driver.findElement(By.xpath("//input[@placeholder='Email ID']")).sendKeys(data.getProperty("email"));
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(data.getProperty("password"));
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority = 0)
	public void SelectDateOfFlight() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='search-date']")).click();
		String BookingDateyear="September 2023";
		String BookingDate="26";
		while(true) {
			String currentDateYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			if(currentDateYear.equalsIgnoreCase(BookingDateyear)) {
				break;
			}else {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}
		
		List<WebElement> Dates=driver.findElements(By.xpath("//tr//td[@data-handler='selectDay']"));
		for (WebElement weebElement : Dates) {
			String d=weebElement.getText();
			if(BookingDate.equalsIgnoreCase(d)) {
				weebElement.click();
				break;
			}
			
		}
		
		String FromPlace="Hyderabad";
		WebElement from=driver.findElement(By.xpath("//select[contains(@class,'sf2')]"));
		Select Places=new Select(from);
		Places.selectByVisibleText(FromPlace);
		
		String ToPlace="Chennai";
		WebElement To=driver.findElement(By.xpath("//select[contains(@class,'sf3')]"));
		Select Placees=new Select(To);
		Placees.selectByVisibleText(ToPlace);
		
	}
	
	
	
	
	@Test(priority = 3)
	public void EnterDetailsOfPassenger() {
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(data.getProperty("name"));
		driver.findElement(By.xpath("//input[@value='First Class']")).click();
		driver.findElement(By.xpath("//input[@id='tickets']")).clear();
		driver.findElement(By.xpath("//input[@id='tickets']")).sendKeys("3");
		driver.findElement(By.xpath("//button[normalize-space()='Insert Order']")).click();
		
	}
	
	@Test(priority = 4)
	public void CheckTicketBookedOrNot() throws InterruptedException {
		driver.findElement(By.linkText("View Ticket")).click();
		assertTrue(driver.findElement(By.xpath("//div[3]//div[3]")).getText().endsWith(data.getProperty("name")));
		Thread.sleep(2000);
		logout();
		Thread.sleep(3000);
	
	}
	
	

}
