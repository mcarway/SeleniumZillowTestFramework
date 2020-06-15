package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {

		String projectPath=System.getProperty("user.dir");
		ExcelUtils mmmm= new ExcelUtils(projectPath+"/excel/data.xls","Sheet1");

		try {
			mmmm.getRowcount();
			mmmm.getCellDataString(1,0);
			mmmm.getCellDataNumber(1,1);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
