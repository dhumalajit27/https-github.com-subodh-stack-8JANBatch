package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static String getdata(int row,int cell,String sheetname) throws EncryptedDocumentException, IOException {
		
		

		FileInputStream file=new FileInputStream("E:\\JAVA\\zeroda\\src\\test\\resources\\testdata.xlsx");
		
		String value=WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		
		return value;
		
		
	}
}
