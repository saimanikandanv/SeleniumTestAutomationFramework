package com.staf.util;

import com.staf.enums.PropertyFileEnums;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

/**
 * Created by Saimanikandan V on 27-04-2021
 */
public class ELKUtils {

    private ELKUtils()
    {

    }


    public static void sendReportstoELK(String testName,String status) throws Exception {
        if(PropertyUtils.readPropertyValue(PropertyFileEnums.SENDREPORTSTOELK.name().toLowerCase()).equalsIgnoreCase("yes"))
        {
            Map<String,String> elKParams =new HashMap<>();
            elKParams.put("Test Case Name",testName);
            elKParams.put("Test Case Status",status);
            elKParams.put("Execution Time", LocalDateTime.now().toString());
            Response response=given().header("Content-type","application/json")
                    .log()
                    .all()
                    .body(elKParams)
                    .post("http://localhost:9200/suite/results");
            Assert.assertEquals(response.statusCode(),201);
            response.prettyPrint();
        }


    }
}
