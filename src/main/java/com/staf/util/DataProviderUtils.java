package com.staf.util;

import com.staf.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Saimanikandan V on 22-04-2021
 */
public final class DataProviderUtils {

    @DataProvider(parallel = true)
    public static Object[] getData(Method m) throws IOException {
        String methodName=m.getName();
        List<Map<String,String>> list= ExcelUtils.getTestDetails(FrameworkConstants.getIterationSheetName());
        List<Map<String,String>> runList=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).get("TestName").equalsIgnoreCase(methodName) && list.get(i).get("RunFlag").equalsIgnoreCase("yes")){
                    runList.add(list.get(i));
            }
        }
        return runList.toArray();
    }
}
