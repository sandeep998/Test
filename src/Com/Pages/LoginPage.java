package Com.Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class LoginPage extends Com.Excute.Base_Tool{
	static WebDriver driver;
	
	//WebDriverWait wait;
	
	
	public LoginPage(WebDriver driver) {
	
		LoginPage.driver=driver;
		PageFactory.initElements(driver, this);
		//wait=new WebDriverWait(driver, 30);
			
		}
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement Tuser;
	
	public  void userName(String user1) {
		//wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		//visibilityOfElement(driver,(By) Tuser);
		Tuser.sendKeys(user1);
	}
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement Tpassword;
	
	public  void passWord(String Pass1) {
		
		Tpassword.sendKeys(Pass1);
	}
	
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement Tsubmit;
	
	public  void submit() {
		
		Tsubmit.click();
	}

}
