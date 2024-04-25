package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	
	public static String  getExcelSheetData(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		String filePath = " ";
		FileInputStream file = new FileInputStream(filePath);
		String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

}
