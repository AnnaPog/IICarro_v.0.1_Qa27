package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenerTestNG implements ITestListener {
    Logger logger = LoggerFactory.getLogger(MyListenerTestNG.class);
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("Listener TestNG start "+result.getTestName()+result.getName());
        logger.info("Listener TestNG start "+result.getTestName()+result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        System.out.println("Listener TestNG finish"+context.getName());
        logger.info("Listener TestNG finish"+context.getName());
    }
}
