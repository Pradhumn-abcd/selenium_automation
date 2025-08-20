package excel.learning.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	
public static void main(String[] args) throws Exception {
		
		File file=new File("C:\\Users\\USER\\Downloads\\InputData.xlsx");
		//Creating object and keep the file path.
		FileInputStream fis=new FileInputStream(file);
		//FileInputStream is stream that raw byte from files, it is stablished the connection to that file. 
		//And create the object.
		Workbook workbook =new XSSFWorkbook(fis);
		//Workbook allows to the going inside and read the excel.
		Sheet sheet=workbook.getSheetAt(1);
		//workbook   -----   Represent the entire excel file. 
		//getSheetAt(0)   ---- point the sheet (According to the index)
		Row row=sheet.getRow(0);
		//Row represents all cell in horizental line  
		Cell cell=row.getCell(0);
		//get first column of that raw
		System.out.println(cell.getStringCellValue());

	}

public static String getCellValue(String string, int i, int j) {
	// TODO Auto-generated method stub
	return null;
}

}

	
	
	
	

