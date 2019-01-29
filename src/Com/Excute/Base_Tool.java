package Com.Excute;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Tool {
	
public static WebDriver driver;


public static  WebElement visibilityOfElement(WebDriver driver,By locator) {
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
	//wait for page load
/*public  static  void waitForPageLoaded() {
	ExpectedCondition<Boolean> expected = new ExpectedCondition<Boolean>() {
	
            public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
          
            
            }
	};
    try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
	
}*/
public static WebElement presenceOfElement(WebDriver driver,final By locator) {

WebDriverWait wait=new WebDriverWait(driver, 30);
return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

}

public static WebElement elementToClick(WebDriver driver,final By locator) {

WebDriverWait wait=new WebDriverWait(driver, 30);
return wait.until(ExpectedConditions.elementToBeClickable(locator));

}

 public static WebElement waitForExpectedElement(WebDriver driver, final By locator) {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
   //Explicit wait method
	/*public static WebElement visibilityOfElement(WebDriver driver,int time,By loc) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	
		
	}*/
	// Explicit wait method
/*	public static WebElement visibilityOfElement1(WebDriver driver, WebElement element,int time) {
		
		WebDriverWait wait=new WebDriverWait(driver, 120);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}*/
	
	/*
	// Explicit wait method
	public static WebElement waitForExpectedElement(WebDriver driver, final By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}*/
	
	
	
   public String captureScreenshot(WebDriver driver, String screenShotName) {
		  String path = "";
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt = new Date();
			String html = "";
			try {
				System.out.println(dateFormat.format(dt));
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				// html = covertScreenshotToBase64(source , screenShotName);
				path = System.getProperty("user.dir") + File.separator + "screenshots";
				createDirectory(path);
				FileUtils.copyFile(source,
						new File(path + File.separator + dateFormat.format(dt) + "_" + screenShotName + ".png"));
				System.out.println("screenshot is taken");

			} catch (Exception e) {
				System.out.println("exception while taking screenshot" + e.getMessage());
			}

			return html;
		}
		public static boolean createDirectory(String directory) {
			File fileDirectory = new File(directory);
			if (!fileDirectory.exists()) {
				fileDirectory.mkdir();
				return true;
			}
			return false;

		}

}
