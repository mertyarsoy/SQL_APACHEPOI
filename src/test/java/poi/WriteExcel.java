package poi;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void writeTest() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(
                new File("src/test/resources/SmokeTestSetup.xlsx")));

        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(0);
        XSSFCell newCell = row.createCell(6);
        newCell.setCellValue("Owner");

        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/test/resources/SmokeTestSetup.xlsx"));
        workbook.write(fileOutputStream);

    }

}
