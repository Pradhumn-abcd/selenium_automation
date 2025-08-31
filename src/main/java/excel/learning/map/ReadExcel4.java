package excel.learning.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel4 {
	
	
	
	public static void getCellValue(String sheetName) throws Exception
	{
		File file=new File(".\\src\\main\\resources\\InputData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		/*
		 * Row row=sheet.getRow(0); Cell cell=row.getCell(0);
		 * System.out.println(cell.getStringCellValue());
		 * 
		 * Row row1=sheet.getRow(1); Cell cell1=row1.getCell(0);
		 * System.out.println(cell1.getStringCellValue());
		 * 
		 * Row row2=sheet.getRow(2); Cell cell2=row2.getCell(0);
		 * System.out.println(cell2.getStringCellValue());
		 */
		
		
		for (int i = 0; i < 8; i++) {
			Row row=sheet.getRow(i);
			Cell cell=row.getCell(0);		
			System.out.println(cell.getStringCellValue());
		}
		
		for (int i = 0; i < 8; i++) {
			
			for (int j = 0; j < 2; j++) {
				Row row=sheet.getRow(i);
				Cell cell=row.getCell(j);		
				System.out.print(cell.getStringCellValue());
				System.out.print("\t");
			}
			System.out.println();
			
		}
		
	
		
		
		
	}

	public static void main(String[] args) throws Exception {
		getCellValue("Login");

	}

}
