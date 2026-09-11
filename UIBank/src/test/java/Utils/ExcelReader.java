package Utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelReader {

    private static final String FILE_PATH =
            "src/test/java/TestData/RegistrationData.xlsx";

    public static String getCellData(int rowNum, int colNum) {

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            if (sheet == null) {
                return "";
            }

            Row row = sheet.getRow(rowNum);

            if (row == null) {
                return "";
            }

            Cell cell = row.getCell(colNum);

            if (cell == null) {
                return "";
            }

            DataFormatter formatter = new DataFormatter();

            return formatter.formatCellValue(cell).trim();

        } catch (Exception e) {

            e.printStackTrace();
            return "";
        }
    }

    public static int getRowCount() {

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            if (sheet == null) {
                return 0;
            }

            return sheet.getLastRowNum();

        } catch (Exception e) {

            e.printStackTrace();
            return 0;
        }
    }
}