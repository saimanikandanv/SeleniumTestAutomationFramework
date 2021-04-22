package com.staf.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import com.staf.constants.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by Saimanikandan V on 18-04-2021
 */
public final class ExcelUtils {

    private ExcelUtils()
    {

    }

    static FileInputStream fs;

    public static List<Map<String,String>> getTestDetails(String sheetName) throws IOException {
        List<Map<String,String>> list=null;
        try
        {
            fs=new FileInputStream(FrameworkConstants.getExcelTestDataPath());
            XSSFWorkbook workbook=new XSSFWorkbook(fs);
            XSSFSheet sheet=workbook.getSheet(sheetName);

            int lastrownum=sheet.getLastRowNum();
            int lastcolnum=sheet.getRow(0).getLastCellNum();

            Map<String, String> map=null;
            list=new ArrayList<>();

            for(int i=1;i<=lastrownum;i++)
            {
                map=new HashMap<>();
                for(int j=0;j<lastcolnum;j++)
                {
                    String key=sheet.getRow(0).getCell(j).getStringCellValue();
                    String value=sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key,value);
                }
                list.add(map);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try{
                if(Objects.nonNull(fs)){
                    fs.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return list;
    }
}
