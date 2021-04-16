package com.staf.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * Created by Saimanikandan V on 16-04-2021
 */
public final class ExtentTestManager {
    private static ThreadLocal<ExtentTest> extTest=new ThreadLocal<>();

    private ExtentTestManager(){

    }


    static ExtentTest getExtentTest() {
        return extTest.get();
    }

    static void setExtentTest(ExtentTest test) {
        extTest.set(test);
    }

    static void removeExtentTest(){
        extTest.remove();
    }

}
