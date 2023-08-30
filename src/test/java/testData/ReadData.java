package testData;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//This class is to read data from Excel sheet using the apache poi library

public class ReadData {


    //This path locates project location and concatenate  file path inside project with it.
    String filePath = System.getProperty("user.dir") + "/src/test/java/testData/TestData.xlsx";

    public Object[][] read_data() throws IOException {


            // You must change the file path with yours before running this class
            XSSFWorkbook wb = new XSSFWorkbook(filePath);
            XSSFSheet sheet = wb.getSheet("SearchData");
            int rowNumber = sheet.getPhysicalNumberOfRows();
            int columnsNumber = sheet.getRow(0).getLastCellNum();
            String[][] data = new String[rowNumber - 1][columnsNumber];

            for (int r = 1; r < rowNumber; r++) {
                for (int c = 0; c < columnsNumber; c++) {
                    XSSFRow row = sheet.getRow(r);
                    data[r - 1][c] = row.getCell(c).getStringCellValue();
                }
            }
            return data;
    }
}


