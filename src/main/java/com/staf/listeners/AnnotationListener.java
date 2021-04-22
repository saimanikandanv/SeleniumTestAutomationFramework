package com.staf.listeners;

import com.staf.util.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Saimanikandan V on 22-04-2021
 */
public class AnnotationListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setDataProvider("getData");
        iTestAnnotation.setDataProviderClass(DataProviderUtils.class);
        iTestAnnotation.setRetryAnalyzer(RetryListener.class);
    }
}
