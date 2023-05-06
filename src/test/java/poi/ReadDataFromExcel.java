package poi;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;

public class ReadDataFromExcel {
    @Test
    public void readFileTest() throws IOException {
        File excelFile = new File("src/test/resources/SmokeTestSetup.xlsx");
        FileInputStream fileInputStream = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(0);
        XSSFCell cell = row.getCell(0);

        System.out.println(cell);
    }

    @Test
    public void getRowValuesTest() throws IOException {
        File excelFile = new File("src/test/resources/SmokeTestSetup.xlsx");
        FileInputStream fileInputStream = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(0);
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            if (i == 0) System.out.print("| ");
            XSSFCell currentCell = row.getCell(i);
            System.out.print(currentCell + " | ");
        }
    }

    @Test
    public void getAllRowValuesTest() throws IOException{
        File excelFile = new File("src/test/resources/SmokeTestSetup.xlsx");
        FileInputStream fileInputStream = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) { // getting rows
            XSSFRow currentRow = sheet.getRow(i);
            for (int j = currentRow.getFirstCellNum(); j < currentRow.getLastCellNum(); j++) { // getting cells
                if (j == 0) System.out.print("| ");
                XSSFCell currentCell = currentRow.getCell(j);
                System.out.print(currentCell+ " | ");
            }
            System.out.println();
        }
    }
}
