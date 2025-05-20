package com.thetestingacadmey.Data_Driven_19_05_25_Data_Driven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class TaskExcel01 {
    public static void main(String[] args) throws IOException {
        // Create a workbook and a sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");
        // create  a Xls
        // add dependency maven  apache poi
        // workbook
        // sheet
        // row cell
        // XSSFWorkBook --> xslx 2008
        //HSSFWorkBook --> xls < 2004
        // Task -1 - create  Excel fill and Sdd data
        // Data to be written
        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"LoginID", "Email", "Password"});
        data.put("2", new Object[]{"1", "Abhishekpy55@mail.com", "Abhishek@123"});
        data.put("3", new Object[]{"2", "Abhishekpy55@mail.com", "Abhishek123"});

        // Iterate and write data to sheet
        int rownum = 0;
        for (String key : data.keySet()) {
            Row row = sheet.createRow(rownum++);
            Object[] rowData = data.get(key);
            int cellnum = 0;
            for (Object obj : rowData) {
                Cell cell = row.createCell(cellnum++);
                cell.setCellValue(obj.toString());
            }
        }

        // Write the output to file
        try (FileOutputStream out = new FileOutputStream(new File("demo.xls"))) {
            workbook.write(out);
        }

        // Closing the workbook
        workbook.close();

        System.out.println("Excel file written successfully.");
    }
}
