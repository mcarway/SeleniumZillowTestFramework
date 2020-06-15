package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//Use XSSF for xlsx. Use HSSF for xls.
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectPath;
	static FileInputStream file;
	static HSSFWorkbook workbook;
	static HSSFSheet sheet;
	static String pathm;
	static String sheetm;
	

	public ExcelUtils(String excelPath, String sheetName) {
		
		try {
		//Only use fileinputstream with HSSF.
		file = new FileInputStream(new File(excelPath));
		workbook = new HSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		
		this.pathm=excelPath;
		this.sheetm=sheetName;

		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public static void main(String[] args) {
		//getRowcount();
		//getCellDataString(0,0);
		//getCellDataNumber(1,1);
	}

	public static int getRowcount() {
		
		int rowCount=0;

		try {
			/*projectPath=System.getProperty("user.dir");
			file = new FileInputStream(new File(projectPath+"/excel/data.xls"));
			workbook = new HSSFWorkbook(file);
			sheet = workbook.getSheet("Sheet1");
*/
			rowCount=sheet.getPhysicalNumberOfRows();

			//System.out.println("path:"+pathm);
			//System.out.println("Num of rows: "+rowCount);
			//System.out.println("sheet:"+sheetm);
			
		}catch(Exception exp){
			System.out.println(exp.getMessage());
		}
		return rowCount;

	}

	public static int getColcount() {
		
		int colCount=0;

		try {

			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
			//System.out.println("path:"+pathm);
			//System.out.println("Num of rows: "+colCount);
			//System.out.println("sheet:"+sheetm);
			
		}catch(Exception exp){
			System.out.println(exp.getMessage());
		}
		return colCount;

	}

	public static String getCellDataString(int rowNum, int colNum) {
		
		String cellData=null;

		try {

			cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println("DataString value: "+cellData);

		}catch(Exception exp){
			System.out.println(exp.getMessage());
		}
		return cellData;
	}

		public static Double getCellDataNumber(int rowNum, int colNum) {
			
			Double cellData=null;

			try {
				cellData=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
				//System.out.println("DataNumber value: "+cellData);

			}catch(Exception exp){
				System.out.println(exp.getMessage());
			}
			return cellData;

	}

}
