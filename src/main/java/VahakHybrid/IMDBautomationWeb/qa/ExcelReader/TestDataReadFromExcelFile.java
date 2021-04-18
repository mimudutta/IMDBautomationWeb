package VahakHybrid.IMDBautomationWeb.qa.ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestDataReadFromExcelFile {
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+
						"/src/test/resource/VahakHybrid/IMDBautomationWeb/qa/TestData/UserTestData.xlsx";

	static Workbook imdbBook;
	static Sheet imdbSheet;
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			imdbBook = WorkbookFactory.create(file);   
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		imdbSheet = imdbBook.getSheet(sheetName);
		System.out.println(imdbSheet.getLastRowNum() + "--------" +
				 imdbSheet.getRow(imdbSheet.getLastRowNum()).getLastCellNum());
		Object[][] data = new Object[imdbSheet.getLastRowNum()][imdbSheet.getRow(0).getLastCellNum()];
		 
		
		for (int i = 0; i < imdbSheet.getLastRowNum(); i++) {
			for (int k = 0; k < imdbSheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = imdbSheet.getRow(i + 1).getCell(k).toString();
				 System.out.println(data[i][k]);
			}
		}
		return data;
	}

}
