package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='Email ID']")
	private WebElement Email;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement Password;
	
	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	private WebElement LoginButton;
	
	public LoginPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void EnterEmail(String emaill) {
		Email.sendKeys(emaill);
	}
	
	public void EnterPassword(String passwordd) {
		Password.sendKeys(passwordd);
	}
	
	public void LoginClick() {
		LoginButton.click();
	}

}
