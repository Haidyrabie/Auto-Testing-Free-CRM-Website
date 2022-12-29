package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    @Override
    public void onFinish(ITestContext contextFinish) {
        System.out.println("Test finished");

    }

    @Override
    public void onStart(ITestContext contextStart) {
        System.out.println("Test started");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Method failed with certain success percentage");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Method failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Method skipped");

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Method started");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Method passed");

    }

}