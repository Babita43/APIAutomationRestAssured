package Utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {
    //file input
static Workbook book;
static Sheet sheet;

public static String SheetName = System.getProperty("user.dir") + "src/main/java/Resources/Book1.xlsx";



@DataProvider
    public Object[][] getData(String sheetname) throws IOException {
    FileInputStream file = null;
    try {
        file = new FileInputStream(SheetName);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }

    book = WorkbookFactory.create(file);
    sheet = book.getSheet(sheetname);
    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    for(int i=0; i<sheet.getLastRowNum(); i++){
        for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
            data[i][j] = sheet.getRow(i+1).getCell(j).toString();
        }
    }
        return data;
    }

    @DataProvider
    public Object[][] getData1() throws IOException {
        return getData("Sheet1");
    }
}
