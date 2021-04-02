package com.staf.constants;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public final class FrameworkConstants {

    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir")+"/src/test/resources/browserExecutables/chromedriver.exe";

    private FrameworkConstants(){

    }

    public static String getChromeDriverPath()
    {
        return CHROMEDRIVERPATH;
    }



}
