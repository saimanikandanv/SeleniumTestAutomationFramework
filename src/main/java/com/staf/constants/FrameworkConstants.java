package com.staf.constants;

import com.staf.enums.PropertyFileEnums;
import com.staf.util.PropertyUtils;
import org.apache.poi.hpsf.ClassID;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public final class FrameworkConstants {

    private static final String RESOURCESPATH=System.getProperty("user.dir")+"/src/test/resources";

    private static final String CHROMEDRIVERPATH =RESOURCESPATH+"/browserExecutables/chromedriver.exe";
    private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
    private static final String EXTENTREPORTSPATH=System.getProperty("user.home")+"/LocalExecution/reports_";
    private static final String EXTENTREPORTSPATHCICD=System.getProperty("user.dir")+"/reports";
    private static String EXTENTREPORTSFILEPATH="";
    private static final String EXCELTESTDATAPATH=RESOURCESPATH+"/TestData/TestData.xlsx";

    private static final String RUNMANAGERSHEETNAME="RunManager";
    private static final String ITERATIONSHEETNAME="Data";

    public static String getRunManagerSheetName() {
        return RUNMANAGERSHEETNAME;
    }

    public static String getIterationSheetName() {
        return ITERATIONSHEETNAME;
    }


    public static String getExcelTestDataPath() {
        return EXCELTESTDATAPATH;
    }


    private FrameworkConstants(){

    }

    public static String getExtentReportFilePath() throws Exception {
        if(EXTENTREPORTSFILEPATH.isEmpty())
        {
            EXTENTREPORTSFILEPATH=getExtentReportsPath();
        }
        return EXTENTREPORTSFILEPATH+"/"+"index.html";
    }

    public static String getExtentReportsPath() throws Exception {
        String CICDFlag= PropertyUtils.readPropertyValue(PropertyFileEnums.CICDFLAG.name().toLowerCase());
        File createFolder;
        if(CICDFlag.equalsIgnoreCase("yes"))
        {
            createFolder=new File(EXTENTREPORTSPATHCICD);
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
        }
        else
        {
            createFolder=new File(EXTENTREPORTSPATH+getCurrentTimestamp());
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
