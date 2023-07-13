package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegsiterPOM {
	 WebDriver driver;
	
	@FindBy(id="name")
	private WebElement Name;
	
	@FindBy(id="email")
	private WebElement Email;
	
	@FindBy(id="contact")
	private WebElement Contact;
	
	@FindBy(xpath = "//input[@id='address']")
	private WebElement Password;
	
	public RegsiterPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void EnterName(String Namee) {
		Name.sendKeys(Namee);
	}
	
	public void EnterEmail(String Emaill) {
		Email.sendKeys(Emaill);
	}
	
	public void EnterContact(String Contactt) {
		 Contact.sendKeys(Contactt);
	}
	
	public void EnterPasword(String paswordd) {
		Password.sendKeys(paswordd);
	}

}
