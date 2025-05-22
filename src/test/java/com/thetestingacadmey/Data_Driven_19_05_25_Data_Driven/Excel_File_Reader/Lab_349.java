package com.thetestingacadmey.Data_Driven_19_05_25_Data_Driven.Excel_File_Reader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Lab_349 {
   // File open
   // Read Data
   // Read the Excel file
   public static void main(String org[]) throws IOException {
       FileInputStream inputStream = new FileInputStream("CTD.xlsx");
       XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
       XSSFSheet sheet = workbook.getSheetAt(0);// main
       Iterator<Row> rowIterator = sheet.iterator();
       while(rowIterator.hasNext()){ // reading row in sheet
           Row row = rowIterator.next();
           Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext())  // reading  columns in the sheet
            {
            Cell cell = cellIterator.next();
            if(cell.getCellType() == CellType.NUMERIC){
            //   cell.getNumericCellValue();
                System.out.println( cell.getNumericCellValue());
            }
                if(cell.getCellType() == CellType.STRING){
                  //  cell.getStringCellValue();
                    System.out.println(cell.getStringCellValue());
                }
            }
       }
   }
}
