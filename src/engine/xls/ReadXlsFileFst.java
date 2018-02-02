package engine.xls;


import javafx.scene.control.Alert;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReadXlsFileFst {
    public static ArrayList<String> whatSerchArrayList = new ArrayList<>();

    //TODO remake all
    // в конструктор передаем путь к файлу
    // read end whrit in arrayList search values



    public ReadXlsFileFst(String readWhatSerch) {

            try {
                FileInputStream fis = new FileInputStream(readWhatSerch);
                Workbook wb = new HSSFWorkbook(fis);

                // init arrayList serch Value
                for (Row row : wb.getSheetAt(0)) {
                    for (Cell cell : row) {
                        String tmpString = ParserXlsFile.parserXlsFile(cell.toString());
                        if (tmpString != null) {
                            whatSerchArrayList.add(tmpString);
                        }
                    }
                }
                fis.close();
                //JOptionPane.showMessageDialog(null, "Файл с искомыми значениями успешно загружен!");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Re re");
                //e.printStackTrace();
            }
        }
    /*
    public static String getCellText(Cell cell){

        String result = "";

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result = cell.getDateCellValue().toString();
                } else {
                    result = Double.toString(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                result = Boolean.toString(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                result =  cell.getCellFormula().toString();
                break;
            //case Cell.CELL_TYPE_BLANK:
            //break;
            default:
                System.out.println("Что то в Get ReaderXLS-2");
        }

        return result;
    }
*/
}
