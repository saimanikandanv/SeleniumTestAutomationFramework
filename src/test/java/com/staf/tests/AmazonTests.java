package com.staf.tests;

import com.staf.annotations.FrameworkAnnotations;
import com.staf.enums.CategoryType;
import com.staf.pages.AmazonHomePage;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by Saimanikandan V on 26-04-2021
 */
public class AmazonTests extends BaseTest{

    @FrameworkAnnotations(authors = {"SAI"}, category = {CategoryType.REGRESSION,CategoryType.SMOKE})
    @Test
    public void searchProductTest1(Map<String,String> data) throws Exception {

        AmazonHomePage amazonHomePage =new AmazonHomePage();
        amazonHomePage.searchProduct(data.get("productName"));

    }

    @FrameworkAnnotations(authors = {"SAI"}, category = {CategoryType.REGRESSION,CategoryType.SMOKE})
    @Test
    public void searchProductTest2(Map<String,String> data) throws Exception {

        AmazonHomePage amazonHomePage =new AmazonHomePage();
        amazonHomePage.searchProduct(data.get("productName"));

    }
}
