package com.staf.constants;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public class FrameworkConstants {

    private static final String RESOURCESPATH=System.getProperty("user.dir")+"/src/test/resources";

    private static final String CHROMEDRIVERPATH =RESOURCESPATH+"/browserExecutables/chromedriver.exe";
    private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
    private static final String EXTENTREPORTSPATH=System.getProperty("user.home")+"/LocalExecution/reports_";
    private static String EXTENTREPORTSFILEPATH="";

    private FrameworkConstants(){

    }

    public static String getExtentReportFilePath() {
        if(EXTENTREPORTSFILEPATH.isEmpty())
        {
            EXTENTREPORTSFILEPATH=getExtentReportsPath();
        }
        return EXTENTREPORTSFILEPATH+"/"+"index.html";
    }

    public static String getExtentReportsPath() {
        File createFolder=new File(EXTENTREPORTSPATH+getCurrentTimestamp());
        if(!createFolder.exists())
        {
            try
            {
                createFolder.mkdir();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return createFolder.getAbsolutePath();
    }

    public static String getChromeDriverPath()
    {
        return CHROMEDRIVERPATH;
    }

    public static String getConfigFilePath()
    {
        return CONFIGFILEPATH;
    }

    public static String getCurrentTimestamp()
    {
        Date d =new Date();
        DateFormat formatter=new SimpleDateFormat("MMddyyyy_HHmmss");
        return formatter.format(d);
    }

}
