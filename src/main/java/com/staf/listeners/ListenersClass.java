package com.staf.listeners;

import com.staf.annotations.FrameworkAnnotations;
import com.staf.enums.PropertyFileEnums;
import com.staf.reports.ExtentLogger;
import com.staf.reports.*;
import com.staf.util.ELKUtils;
import lombok.SneakyThrows;
import org.testng.*;

import java.io.IOException;
import java.util.Arrays;
import static com.staf.util.PropertyUtils.readPropertyValue;

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
        try {
            ExtentLogger.info("Launching URL "+readPropertyValue(PropertyFileEnums.URL.name().toLowerCase()));
            ExtentReporting.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).authors());
            ExtentReporting.addCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() +" is passed");
        ELKUtils.sendReportstoELK(result.getMethod().getMethodName(),"Pass");

    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() +" is failed");
        ELKUtils.sendReportstoELK(result.getMethod().getMethodName(),"Fail");
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @SneakyThrows
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() +" is skipped");
        ELKUtils.sendReportstoELK(result.getMethod().getMethodName(),"Skip");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }


}
