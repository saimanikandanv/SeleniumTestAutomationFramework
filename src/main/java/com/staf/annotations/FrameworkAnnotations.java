package com.staf.annotations;

import com.staf.enums.CategoryType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;

/**
 * Created by Saimanikandan V on 23-04-2021
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotations {

    public String[] authors();
    public CategoryType[] category();



}
