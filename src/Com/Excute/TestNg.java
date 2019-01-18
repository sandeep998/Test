package Com.Excute;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import Com.Pages.LoginPage;
import Com.Pages.HomePageFirstSheet;
import Com.Utility.Base_Tool;
import Com.Utility.Config_data;

@Listeners(Com.Utility.Listeners.class)
public class TestNg extends Base_Tool {
	
	public static	ExtentReports reports;
	static ExtentTest logger;
    public Config_data cong;
    
	@BeforeClass
	public  void launch_browser() throws Exception {
		
		reports = new ExtentReports("C:\\Users\\sandeep.mandhala\\eclipse-workspace\\Tool_Tip\\Extent_report_results.html", true);
		 logger=reports.startTest("verify test");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sandeep.mandhala\\Downloads\\All Jar files selenium\\chromedriver.exe");
				driver =new ChromeDriver();
				cong=new Config_data();
				cong.conFig();
				
				try {
					driver.get(cong.getProperty("URL"));
					logger.log(LogStatus.INFO, "Open Browser successfully");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.log(LogStatus.ERROR, e.getLocalizedMessage()+"Not able to open Browser");
					captureScreenshot(driver, "Not able to open browser");
				
				}
				driver.manage().window().maximize();
				
	}
	
	@Test
	public void homeScreenTest() throws Exception {
		loginScreenTest();
		
		
		HomePageFirstSheet.firstSheet(driver);
		logger.log(LogStatus.INFO, "Clicked on First sheer USA");
		
		HomePageFirstSheet.livingInUsa(driver);
		logger.log(LogStatus.INFO, "Clicked on LivingInUSA");
		
		HomePageFirstSheet.communityClick(driver);
		logger.log(LogStatus.INFO, "Clicked on Community");
		HomePageFirstSheet.comEmergency(driver);
		logger.log(LogStatus.INFO, "Clicked on Community Emergency");
		Thread.sleep(4000);
		
		HomePageFirstSheet.editArrow(driver);
		logger.log(LogStatus.INFO, "Clicked Edit Arrow");
		
		HomePageFirstSheet.comEditEmergency(driver);
       String Emer=HomePageFirstSheet.comEditEmergency(driver);
     System.out.println("value"+Emer);
		
	try {
		Assert.assertEquals("Emergency ", Emer);
	} catch (AssertionError  e) {
		// TODO Auto-generated catch block
		logger.log(LogStatus.ERROR, "Error:::::::" +e);
		throw e;
	}
	
    String fun=	HomePageFirstSheet.funFacts(driver);
	logger.log(LogStatus.INFO, "Clicked Funfacts and Edit Arrow");
	 System.out.println("value::::::::::"+fun);
	try {
		Assert.assertEquals("Fun Facts",fun );
	} catch (AssertionError  e) {
		// TODO Auto-generated catch block
		logger.log(LogStatus.ERROR, "Error:::::::" +e);
		throw e;
	}
	
String raphy=	HomePageFirstSheet.geogRaphy(driver);
System.out.println("geography::"+raphy);
Assert.assertEquals("Geography", raphy);
		Thread.sleep(5000);
		
		//Using pagefactory @findby
		/*HomePageFirstSheet home=PageFactory.initElements(driver, HomePageFirstSheet.class);
		home.fillINPUTEmailAddress();*/
	}
	
	
	
  public  void loginScreenTest() {
	
		
		try {
			LoginPage.userName(driver, cong.getProperty("username"));
			LoginPage.passWord(driver, cong.getProperty("password"));
			LoginPage.Submit(driver);
			logger.log(LogStatus.INFO, "Entered Password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, e.getLocalizedMessage()+"got error while login the app");
			captureScreenshot(driver, "Error Screenshot");
		}
		
		
		
  }
	@AfterTest
	public static void tearDown() {
		reports.flush();
		reports.endTest(logger);
		driver.quit();
		
	}
}
