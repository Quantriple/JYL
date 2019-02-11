package com.Qqq.util;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/4.
 */
public class ReadExcel {
    public static void main(String[] args) {
        //  ReadExcel obj = new ReadExcel();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File("D://201801.xls");
        List excelList = ReadExcel.readExcel(file);
        System.out.println("list中的数据打印出来");
        for (int i = 0; i < excelList.size(); i++) {
            List list = (List) excelList.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j));
            }
            System.out.println();
        }

    }

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public static List readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            String[] sheetNames = wb.getSheetNames();
            List<List> outerList = new ArrayList<List>();
            for (int index = 0; index < sheetNames.length; index++) {
                // 每个页签创建一个Sheet对象


                if ("L3".equalsIgnoreCase(sheetNames[index])) {
                    //获取到了L3的表格
                    Sheet sheet = wb.getSheet(index);
                    //sheet.getCell("calss").
                    sheet.getRows();//返回该页的总行数
                    for (int i = 3; i < sheet.getColumns(); i++) {
                        List innerList = new ArrayList();
                        sheet.getColumns();//返回该页的总列数
                        for (int j = 0; j < sheet.getRows(); j++) {
                            String cellinfo = sheet.getCell(i, j).getContents();
                            if (cellinfo.isEmpty()) {
                                // continue;
                                break;
                            }
                            if (cellinfo.equalsIgnoreCase("Student Number") || cellinfo.equalsIgnoreCase("class") || cellinfo.equalsIgnoreCase("Chinese Name") || cellinfo.equalsIgnoreCase("Original")) {

                                // innerList.add(cellinfo);
                                Cell[] column = sheet.getColumn(j);

                                innerList.add(column);
                                System.out.print(cellinfo);

                                continue;

                            }
                            //每一行所有的值
                            // innerList.add(cellinfo);

                        }
                        //outerList.add(i, innerList);//整一页的值
                        System.out.println();
                    }
                    return outerList;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public static List<Cell[]> readExcel2(File file) {
        List<Cell[]> outerList = new ArrayList<>();
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            String[] sheetNames = wb.getSheetNames();

            for (int index = 0; index < sheetNames.length; index++) {
                // 每个页签创建一个Sheet对象
                if ("L3".equalsIgnoreCase(sheetNames[index])) {
                    //获取到了L3的表格
                    Sheet sheet = wb.getSheet(index);
                    //int[] row=new int[3];

                    Cell[] stu_number = sheet.getColumn(1);
                    Cell[] stu_class = sheet.getColumn(2);
                    Cell[] stu_name = sheet.getColumn(3);
                    Cell[] stu_core = sheet.getColumn(14);
                    outerList.add(stu_number);
                    outerList.add(stu_class);
                    outerList.add(stu_name);
                    outerList.add(stu_core);

                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return outerList;
    }
}
