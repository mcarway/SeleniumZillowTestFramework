package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("*****Test start: "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*****Test success: "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*****Test failure: "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*****Test skipped: "+result.getName());
	}

	public void onTestFinish(ITestResult result) {
		System.out.println("*****Test finish: "+result.getName());
	}

}
