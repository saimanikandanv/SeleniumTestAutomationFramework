package com.staf.util;

import com.staf.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public class Utils {

    private Utils(){

    }
    private static Properties property=new Properties();
    static {
        try{
            FileInputStream file=new FileInputStream(FrameworkConstants.getConfigFilePath());
            property.load(file);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) throws Exception {
       if(Objects.isNull(property.getProperty(key)) || Objects.isNull(key))
        {
            throw new Exception("The entered key is not found in config.properties");
        }
        return property.getProperty(key);
    }
}
