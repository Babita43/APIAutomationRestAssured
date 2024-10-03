package TestNGCases.Listner;

import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.sql.SQLOutput;

public class CustomListenerITest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("result - inform to MOM");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("start - inform to MOM");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Finish - inform to MOM");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("timeout Failed - inform to MOM");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("timeout Failed with succes - inform to MOM");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("test skipped - inform to MOM for skip");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed- inform to MOM");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("hurray test pass - inform to mom");
    }
}
