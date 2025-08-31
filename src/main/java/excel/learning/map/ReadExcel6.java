package excel.learning.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel6 {
	
	public static void getCallValue(String sheetName) throws Exception
	{
		File file = new File (".\\src\\main\\resources\\InputData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		
		for(int i =0; i<8; i++)
		{
			Row row = sheet.getRow(i);
			Cell cell=row.getCell(0);
			System.out.print(cell.getStringCellValue());
		}
		
		
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<2; j++)
			{
				Row row = sheet.getRow(i);
				Cell cell=row.getCell(j);
				System.out.print(cell.getStringCellValue());
				System.out.print("\t");
				
			}
			System.out.println();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
