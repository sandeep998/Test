package Com.Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Listeners implements ITestListener {
	
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("sandeep finishes");
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("sandeep start");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("sandeep failure");
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("sandeep skipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("The test case has been Started"+result.getName());
		System.out.println("sandeep started"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The test case has been success"+result.getName());
	}

}
