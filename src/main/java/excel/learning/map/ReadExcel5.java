package excel.learning.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel5 {

	public static void readExcelValue(String sheetName) throws Exception {
		File file = new File(".\\src\\main\\resources\\InputData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
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

		System.out.println("Last row number-->" + sheet.getLastRowNum());

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			Row row1 = sheet.getRow(i);
			// System.out.println("Last column number:----"+row1.getLastCellNum());

			for (int j = 0; j < row1.getLastCellNum(); j++) {
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(j);
				//System.out.println("Cell Type: " + cell.getCellType());

				CellType cellType=cell.getCellType();
				switch (cellType) {
				case BOOLEAN:
				{
					System.out.print(cell.getBooleanCellValue());
					break;	
				}	
				case NUMERIC:
				{
					System.out.print(cell.getNumericCellValue());
					break;
				}
				case STRING:
				{
					System.out.print(cell.getStringCellValue());
					break;
				}
				default:
				{
					System.out.println("Please handle the cell type:--->"+cellType);
					break;
				}
				}

				

				System.out.print("\t");
			}
			System.out.println();

		}

	}

	public static void main(String[] args) throws Exception {
		readExcelValue("Login");

	}

}
