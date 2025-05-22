package com.thetestingacadmey.Data_Driven_19_05_25_Data_Driven.Create_Excel_File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Lab_348_create_Excel_File {
    public static void main(String[] args) throws IOException {

        // 1. Data Setup
        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"LoginID", "Email", "Password"});
        data.put("2", new Object[]{"1", "Abhishe@live.com", "Admin@123"});
        data.put("3", new Object[]{"2", "test@gmail.com", "Admin@123"});

        // 2. Workbook and Sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        // 3. Writing Data to Sheet
        int rownum = 0;
        for (String key : data.keySet()) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                cell.setCellValue(obj.toString());
            }
        }
        // 4. Writing to File
        try (FileOutputStream out = new FileOutputStream(new File("CTD.xlsx"))) {
            workbook.write(out);
            System.out.println("Excel file written successfully.");
        }

        workbook.close(); // Close the workbook
    }


}

