package com.thetestingacadmey.Data_Driven_19_05_25_Data_Driven.Create_Excel_File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab_350 {
    public static void main(String[] args) throws IOException {
        // Create cell at specific position

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        Row row = sheet.createRow(1);
        Cell cell = row.createCell(1);
        cell.setCellValue("Pramod Dutta");


        FileOutputStream outputStream = new FileOutputStream(new File("SELLSPECIPIC.xlsx"));
        workbook.write(outputStream);
        outputStream.close();
    }
}
