package com.demowebshop.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibClass {
	
	public static String readXlsData(String sheetName, int row, int column) {		
		try {
			File file=new File("./resources/userData/testdata.xlsx");
			DataFormatter df=new DataFormatter();
			FileInputStream fis=new FileInputStream(file);
			Workbook workbook=WorkbookFactory.create(fis);
			return df.formatCellValue(workbook.getSheet(sheetName).getRow(row).getCell(column)).toString();
			//return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return "wrong input";
		}		
	}
	
	public static void writeXlsData(String sheetName, int row, int column, String sValueToAdd) {
		try {
			File file=new File("./resources/userData/testdata.xlsx");
			FileInputStream fis=new FileInputStream(file);
			Workbook workbook=WorkbookFactory.create(fis);
			workbook.getSheet(sheetName).getRow(row).getCell(column).setCellValue(sValueToAdd);
			
			FileOutputStream fos=new FileOutputStream(file);
			workbook.write(fos);		
			
		}catch (Exception ex) {
			ex.printStackTrace();			
		}
	}
}
