package datProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	 XSSFWorkbook book;
	 
	 
	public ExcelDataProvider() {
		
		
		File src=new File("./ApplicationTestData/AppData.xlsx");
		
		try {
			FileInputStream file=new FileInputStream(src);
			
			  book=new XSSFWorkbook(file);
			 
		} catch (Exception e) {
			
			System.out.println("Exception is "+e.getMessage());
			
		}
		
	}
	
	
	public String getData(int sheetIndex, int row,int column){
		
		String data=book.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		
		
		return data;
		
	}
	
	
	
public String getData(String sheetName, int row,int column){
		
		String data=book.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
		return data;
		
	}



public double getData1(int sheetNumber, int row,int column){
	
	double data1=book.getSheetAt(sheetNumber).getRow(row).getCell(column).getNumericCellValue();	
	
	
	return data1;
}
	

}
