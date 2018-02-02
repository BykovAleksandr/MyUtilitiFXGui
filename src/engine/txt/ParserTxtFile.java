package engine.txt;

public class ParserTxtFile {



    public static String ParserCsvFile(String inStrim){
        String result = null;

        if (inStrim.contains(";")){
            for (String inValue : inStrim.split(";")){
                String tmp = inValue;
                        System.out.println(tmp);
                if (inValue.contains("=")){
                    for (String finalValue : inValue.split("=")){
                        result = finalValue;
                    }
                }
            }
        }
        return result;
    }
}
