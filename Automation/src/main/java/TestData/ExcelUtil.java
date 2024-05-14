package TestData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtil {
	static DataFormatter formatter=new DataFormatter();
	
	 public static Object[][] readExcelData(String filepath, String sheetname) throws IOException {
	        FileInputStream fis = new FileInputStream(filepath);
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheet(sheetname);
	        int rowCount = sheet.getLastRowNum() + 1; // Include header row
	        int cellCount = sheet.getRow(0).getLastCellNum();
	        Object[][] data = new Object[rowCount - 1][cellCount]; // Exclude header row

	        for (int i = 1; i < rowCount; i++) {
	            XSSFRow row = sheet.getRow(i);
	            for (int j = 0; j < cellCount; j++) {
	                XSSFCell cell = row.getCell(j);
	                data[i - 1][j] = formatCellValue(cell);
	            }
	        }

	        workbook.close();
	        fis.close();
	        return data;
	    }

	    private static String formatCellValue(Cell cell) {
	        DataFormatter formatter = new DataFormatter();
	        return formatter.formatCellValue(cell);
	    }
	 

}
