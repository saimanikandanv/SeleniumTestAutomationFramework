package com.staf.listeners;

import com.staf.constants.FrameworkConstants;
import com.staf.util.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Saimanikandan V on 18-04-2021
 */
public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        List<Map<String,String>> list= null;
        try {
            list = ExcelUtils.getTestDetails(FrameworkConstants.getRunManagerSheetName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<IMethodInstance> result= new ArrayList<IMethodInstance>();

        for(int i=0;i<methods.size();i++)
        {
            for(int j=0;j<list.size();j++)
            {
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("TestName")) && list.get(j).get("RunFlag").equalsIgnoreCase("yes"))
                {
                    methods.get(i).getMethod().setDescription((list.get(j).get("TestDescription")));
                    methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
                    methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
                    result.add(methods.get(i));
                }
            }
        }
        return result;
    }
}
