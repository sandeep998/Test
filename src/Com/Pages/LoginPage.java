package Com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.Utility.Base_Tool;

public class LoginPage extends Base_Tool{
	WebDriver driver;
	
	public static final By username=By.xpath("//input[@placeholder='Email']");
	public static final By password=By.xpath("//input[@placeholder='Password']");
	public static final By submit=By.xpath("//button[text()='Submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public static void userName(WebDriver driver,String user) {
		visibilityOfElement(driver, username);
   WebElement usere=		driver.findElement(username);
   usere.clear();
   usere.sendKeys(user);
	}
	public static void passWord(WebDriver driver,String passsend) {
		visibilityOfElement(driver, password);
	WebElement pass=driver.findElement(password);
	pass.clear();
	pass.sendKeys(passsend);
	}
	public static void Submit(WebDriver driver) {
	visibilityOfElement(driver, submit);
	WebElement submit1=	driver.findElement(submit);
	submit1.click();
	}
}
