package engine.xls;

import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
                for (org.apache.poi.ss.usermodel.Cell cell : row) {
                    String tmpString = ParserXlsFile.parserXlsFile(cell.toString());
                    if (tmpString != null){
                        whatSerchArrayList.add(tmpString);
                    }
                }
            }

            fis.close();
            JOptionPane.showMessageDialog(null, "Файл с искомыми значениями успешно загружен!");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
}
