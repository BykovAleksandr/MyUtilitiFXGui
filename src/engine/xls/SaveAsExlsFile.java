package engine.xls;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SaveAsExlsFile {


    // Add in constructor arrayList with result
    public SaveAsExlsFile(String fileFolderName, ArrayList<String> equel, ArrayList<String> notEquel) {

            System.out.println("Путь к файлу сохранения: " + fileFolderName);
            System.out.println("Длинна equel: " + equel.size());
            System.out.println("Длинна NotEquel: " + notEquel.size());
            // Make exl book
            Workbook wb = new HSSFWorkbook();
            // Create sheet in xls book
            Sheet sheet = wb.createSheet("Equel");
            Sheet sheet1 = wb.createSheet("Not equel");

            // Create row end set position


            //Write Value in set pos, (row X cell)


        for (int i = 0; i < equel.size(); i++){
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(equel.get(i));
        }

        for (int i = 0; i < notEquel.size(); i++){
            Row row = sheet1.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(notEquel.get(i));
        }



            try {
                FileOutputStream fos = new FileOutputStream(fileFolderName);

                wb.write(fos);
                fos.close();
                //JOptionPane.showMessageDialog(null, "Файл создан!");

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }


    }
}
