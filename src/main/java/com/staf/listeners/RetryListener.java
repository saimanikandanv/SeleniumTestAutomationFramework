package com.staf.listeners;

import com.staf.util.PropertyUtils;
import lombok.SneakyThrows;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by Saimanikandan V on 22-04-2021
 */
public class RetryListener implements IRetryAnalyzer {

    private int count=0;
    private int retries=1;
    boolean value=false;

    @SneakyThrows
    @Override
    public boolean retry(ITestResult iTestResult) {

        if(PropertyUtils.readPropertyValue("retryfailedtest").equalsIgnoreCase("yes"))
        {
            value= count<retries;
            count++;
        }
        return value;
    }
}
