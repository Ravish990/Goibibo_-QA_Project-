package utilities;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataReader {

    private static Properties prop;

    static {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }

@DataProvider(name = "excelDataProvider") 
public Object[] [] excelDataProvider() {
List<Object[]> data = new ArrayList<>();
try {
FileInputStream file = new FileInputStream("src/main/resources/testData.xlsx"); 
XSSFWorkbook workbook = new XSSFWorkbook(file); 
XSSFSheet sheet=workbook.getSheetAt(0);
for (int i = 0; i <= sheet.getLastRowNum(); i++) { 
	Row row = sheet.getRow(i);
	String username = getCellValue(row.getCell(0));
    String password = getCellValue(row.getCell(1));
     data.add(new Object[] {username, password});
}
 
workbook.close();
} catch (IOException e) {
e.printStackTrace();
}
return data.toArray(new Object[0][]);
}

private String getCellValue(Cell cell) {
	if(cell==null) {
		return "";
	}
	switch(cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf((long) cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case BLANK:
			return "";
		default:
			throw new IllegalArgumentException("unsupported cell type");
	}
}

//@Test(dataProvider = "excelDataProvider")
//public void testreader(String username, String password) {
//	System.out.println("Username " + username + " Password " + password);
//}


@DataProvider(name = "csvDataProvider")
public Object[][] csvDataProvider() {
	String csvFile = "src/main/resources/test.csv";
			List<Object[]> data = new ArrayList<>();
			String line;

			// read characters(next data)
			
	try(BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
		
		while((line = br.readLine()) != null) {
			String[] values = line.split(",");
		
		data.add(values);
		
		}
	}catch(IOException e) {
		e.printStackTrace();
	}
	
	return data.toArray(new Object[0][]);
}
//@Test(dataProvider = "csvDataProvider")
//public void test2(String username , String password) {
//	System.out.println("username " + username + " password " + password);
//}
}
