package com.staf.reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by Saimanikandan V on 16-04-2021
 */
public final class ExtentReporting {

    private ExtentReporting(){}

    private static ExtentReports reports;
    public static ExtentTest test;

    public static void setupReports()
    {
        if(Objects.isNull(reports)){
            reports=new ExtentReports();
            ExtentSparkReporter reporter=new ExtentSparkReporter("index.html");
            reports.attachReporter(reporter);
            reporter.config().setTheme(Theme.DARK);
            reporter.config().setDocumentTitle("Automation report");
            reporter.config().setReportName("Automation Reports");
        }

    }

    public static void createTest(String testCaseName)
    {
        ExtentTestManager.setExtentTest(reports.createTest(testCaseName));
    }

    public static void writeReports() throws  IOException {
        if(Objects.nonNull(reports))
        {
            reports.flush();
        }
        Desktop.getDesktop().browse(new File("index.html").toURI());

    }



}
