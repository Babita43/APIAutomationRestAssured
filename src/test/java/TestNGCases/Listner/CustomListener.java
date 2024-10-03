package TestNGCases.Listner;

import org.testng.IExecutionListener;

public class CustomListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        long startTime = System.currentTimeMillis();
        System.out.println("Start execution time at " + startTime);
    }

    @Override
    public void onExecutionFinish() {
        long endTime = System.currentTimeMillis();
        System.out.println("End execution time at " + endTime);
    }
}
