package Com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class HomePageFirstSheet extends Com.Excute.Base_Tool{
	
	static WebDriver driver;
	
	public static final By Bay_area1=By.xpath("//p[@class='country-name-text']");
	public static final By LivingUSA=By.xpath("//i[@class='icon toolkit-country-usa']");
	public static final By Community=By.xpath("//a[text()='Community']");
	public static final By ComEmergency=By.xpath("//*[@id='root']/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div/div[1]/div/a/i");
	public static final By EditArrow=By.xpath("//i[@class='fa fa-long-arrow-down']");
	public static final By ComEditEmergency=By.xpath("//input[@class='form-control text-color-living-usa']");
	public static final By FunFacts=By.xpath("//*[@id='root']/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/div/a/span");
	public static final By EditFunFacts=By.xpath("//input[@class='form-control text-color-living-usa']");
	public static final By Geography=By.xpath("//span[text()='Geography']");
	public static final By EditGeography=By.xpath("//input[@class='form-control text-color-living-usa']");
	
	
	public HomePageFirstSheet(WebDriver driver) {
		
		HomePageFirstSheet.driver=driver;
		
	}
	public static void firstSheet(WebDriver driver) {
		visibilityOfElement(driver, Bay_area1);
	WebElement sheet=	driver.findElement(Bay_area1);
	sheet.click();

	}
	public static void livingInUsa(WebDriver driver) {
		visibilityOfElement(driver, LivingUSA);
	WebElement usa=	driver.findElement(LivingUSA);
	System.out.println("clicked");
	usa.click();
	
	}
	public static void communityClick(WebDriver driver) {
		visibilityOfElement(driver, Community);
		WebElement lang=driver.findElement(Community);
		System.out.println("clicked"+lang.getText());
		lang.click();
		
		}
	
	public static void comEmergency(WebDriver driver) {
		
		visibilityOfElement(driver, ComEmergency);
		driver.findElement(ComEmergency).click();
	}
	public static void editArrow(WebDriver driver) {
		
		visibilityOfElement(driver, EditArrow);
WebElement arrow=driver.findElement(EditArrow);
((JavascriptExecutor) driver).executeScript("arguments[0].click()", arrow);
	}
	
   public static String comEditEmergency(WebDriver driver) {
		
		visibilityOfElement(driver, ComEditEmergency);
     WebElement Edit=		driver.findElement(ComEditEmergency);
    String str= Edit.getAttribute("value");
	return str;
  
		
	}
   public static String funFacts(WebDriver driver) throws Exception {
		
		visibilityOfElement(driver, FunFacts);
		
	WebElement fact=driver.findElement(FunFacts);
	fact.click();
	Thread.sleep(4000);
	editArrow(driver);
	WebElement str1=driver.findElement(EditFunFacts);
	String fac=str1.getAttribute("value");
	return fac;
		
	}
   public static String geogRaphy(WebDriver driver) throws Exception {
		
 		visibilityOfElement(driver, Geography);
 		
 	WebElement fact=driver.findElement(Geography);
 	fact.click();
 	Thread.sleep(5000);
 	editArrow(driver);
 	WebElement editgeo=driver.findElement(EditGeography);
 	String geo=editgeo.getAttribute("value");
 	return geo;
 		
 	}
	
	//Using page Factory 
/*	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div/div/div[2]/div/div/div/div[1]/div/div[1]/div/div[1]/div/a/i")	
	private WebElement	Language;
	public void fillINPUTEmailAddress() {
		visibilityOfElement(driver, Language, 120);
		Language.click();
	}*/
	
}
