package com.staf.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.staf.constants.*;
import com.staf.enums.CategoryType;

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
    private static ExtentSparkReporter reporter;

    public static void setupReports() throws Exception {
        if(Objects.isNull(reports)){
            reports=new ExtentReports();
            reporter=new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
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

    public static void writeReports() throws Exception {
        if(Objects.nonNull(reports))
        {
            reports.flush();
        }
        ExtentTestManager.removeExtentTest();
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
   }

   public static void addAuthors(String[] authors){
        for(String s: authors){
            ExtentTestManager.getExtentTest().assignAuthor(s);
        }
   }

    public static void addCategory(CategoryType[] category){
        for(CategoryType c: category){
            ExtentTestManager.getExtentTest().assignCategory(c.toString());
        }
    }
}
