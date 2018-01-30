package engine.xls;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReadXlsFileSec {
    //Serch value array list

    public static ArrayList<String> whearSerchArrayList = new ArrayList<>();

    public ReadXlsFileSec(String readWherSerch){

        // read and write values in arrayList for the search
        // Читаем/парсим/проверяем вернувшиеся данные на "null"

        try {
            FileInputStream fis = new FileInputStream(readWherSerch);
            Workbook wb = new HSSFWorkbook(fis);

            for (Row row : wb.getSheetAt(0)){

                for (Cell cell : row){
                    String tmpString = ParserXlsFile.parserXlsFile(cell.toString());
                    if (tmpString != null){
                        whearSerchArrayList.add(tmpString);
                    }
                }

            }

            JOptionPane.showMessageDialog(null, "Файл Где ищем успешно загружен!");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
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
