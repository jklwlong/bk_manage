package com.poi;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class PoiTest {
    public static void main(String[] args) throws Exception {
        //创建输入流
        FileInputStream fis = new FileInputStream(new File("E:\\metric_code.xlsx"));
        //通过构造函数传参
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        //获取工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //获得总行数
        int rowNum = sheet.getLastRowNum();
        int count = 0;
        for (int i = 0; i <= rowNum; i++) {
            StringBuffer sql = new StringBuffer("UPDATE rc_metric_code SET explains=");
            XSSFRow row = sheet.getRow(i);
            XSSFCell cell = row.getCell(4);
            XSSFCell cell1 = row.getCell(0);
            if (cell != null && cell1 != null
                    && StringUtils.isNotEmpty(cell.getStringCellValue())
                    && StringUtils.isNotEmpty(cell1.getStringCellValue())) {

                sql.append("'").append(cell.getStringCellValue()).append("'").append("\0").append("WHERE del_flag=0 AND rc_metric_code_uuid=")
                        .append("'").append(cell1.getStringCellValue()).append("'").append(";").append("\r\n");
                Fwrite(sql.toString());
            } else {
                count++;
                System.out.println("数据为空--------------" + (row.getRowNum() + 1));
            }
        }
        System.out.println(count);
        fis.close();
    }


    private static void Fwrite(String content) throws Exception {
        FileWriter wr = new FileWriter("E:\\4.txt", true);
        wr.write(content);
        wr.flush();
        wr.close();
    }
}
