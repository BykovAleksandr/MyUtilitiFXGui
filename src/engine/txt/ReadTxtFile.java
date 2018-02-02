package engine.txt;

import java.io.*;
import java.util.ArrayList;

public class ReadTxtFile {


    public static ArrayList<String> whearSerchCsvArrayList = new ArrayList<>();

    public ReadTxtFile(String readWherSerch) throws IOException {
        FileInputStream fsReader = new FileInputStream(readWherSerch);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fsReader));

        String strInLine;

        while ((strInLine = reader.readLine()) != null){
            String tmpSting = ParserTxtFile.ParserCsvFile(strInLine);

            //System.out.println(tmpSting);
            //whearSerchCsvArrayList.add(tmpSting);
        }
/*
        for (String print : whearSerchCsvArrayList){
            System.out.println(print);
        }
        */
    }

}
