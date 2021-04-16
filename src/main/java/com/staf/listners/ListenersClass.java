package com.staf.listners;

import com.staf.reports.ExtentLogger;
import com.staf.reports.ExtentReporting;
import org.testng.*;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Saimanikandan V on 16-04-2021
 */
public class ListenersClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReporting.setupReports();

    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReporting.writeReports();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReporting.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() +" is passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() +" is failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() +" is skipped");
    }


}
