package com.staf.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by Saimanikandan V on 22-04-2021
 */
public class RetryListener implements IRetryAnalyzer {

    private int count=0;
    private int retries=1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value= count<retries;
        count++;
        return value;
    }
}
