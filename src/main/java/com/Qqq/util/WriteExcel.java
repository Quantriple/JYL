package com.Qqq.util;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/4.
 */
public class WriteExcel {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    public static void main(String[] args) {
        writeExcel("test");
    }
    /**
     * 输出excel
     * @param
     * @param
     * @return
     * @throws IOException
     */
    public static void writeExcel(String FileName) {
        String pathName="d://"+FileName+".xls";
        //定义表头
        String[] title = {"序号", "班级", "姓名","总分"};
        //创建excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表sheet
        HSSFSheet sheet = workbook.createSheet();
        //创建第一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = null;
        //插入第一行数据的表头
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        //写入数据
        for (int i = 1; i <= 10; i++) {
            HSSFRow nrow = sheet.createRow(i);
            HSSFCell ncell = nrow.createCell(0);
            ncell.setCellValue("" + i);
            ncell = nrow.createCell(1);
            ncell.setCellValue("user" + i);
            ncell = nrow.createCell(2);
            ncell.setCellValue("24");
        }
        //创建excel文件
        File file = new File(pathName);
        try {
            file.createNewFile();
            //将excel写入
            FileOutputStream stream = FileUtils.openOutputStream(file);
            workbook.write(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 判断Excel的版本,获取Workbook
         * @param in
         * @param filename
         * @return
         * @throws IOException
         */

   /* public static Workbook getWorkbok(File file) throws IOException {
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        if (file.getName().endsWith(EXCEL_XLS)) {     //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {    // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }*/

    }


}
