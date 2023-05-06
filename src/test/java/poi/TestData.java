package poi;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestData {
    XSSFSheet sheet;

    @Before
    public void setup() throws IOException {
        File excelFile = new File("src/test/resources/TestData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheetAt(0);
    }

    @Test
    public void test() {

        int regionColumIndex = 0;
        XSSFRow firstRow = sheet.getRow(0); // find out index of Region column
        for (int i = firstRow.getFirstCellNum(); i < firstRow.getLastCellNum(); i++) {
            if (firstRow.getCell(i).toString().equals("Region")) {
                regionColumIndex = i;
            }
        }
        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            XSSFRow currentRow = sheet.getRow(i);
            System.out.println(currentRow.getCell(regionColumIndex));
        }
    }
    @Test
    public void test2(){
        XSSFRow row = sheet.getRow(0);
        int rowsCount = sheet.getPhysicalNumberOfRows();
        int colCounts = row.getPhysicalNumberOfCells();
        String [][] pages = new String[rowsCount][colCounts];
        for (int i = 0; i < pages.length; i++) {
            for (int j = 0; j < pages[i].length; j++) {
                row = sheet.getRow(i);
                XSSFCell cell = row.getCell(j);
                pages[i][j] = cell.toString();
                if (j == 4){ //Region
                    System.out.println(pages[i][j]);
                }
            }
        }
    }

}








