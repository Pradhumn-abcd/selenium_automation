package excel.learning.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel2 {
	
	
	public static String getCellValue(int sheetIndex, int rowNumber, int columnNumber) throws Exception {
		
		
	   File file=new File(".\\src\\main\\resources\\InputData.xlsx");
		
		FileInputStream fis=new FileInputStream(file);
		
		Workbook workbook =new XSSFWorkbook(fis);
		
		Sheet sheet=workbook.getSheetAt(sheetIndex);
		
		Row row=sheet.getRow(rowNumber);
		
		Cell cell=row.getCell(columnNumber);
		
		return cell.getStringCellValue();
		
	}
	
	

	public static void main(String[] args) throws Exception {
		
	System.out.println(getCellValue(0, 1, 1));

	}

}
