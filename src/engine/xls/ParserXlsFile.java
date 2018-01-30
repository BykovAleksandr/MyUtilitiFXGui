package engine.xls;

public class ParserXlsFile {


    public static String parserXlsFile(String inStrim){

        String result = null;

        if (inStrim.contains("=")){
            for (String inValueString : inStrim.split("=")){
                result = inValueString;
                //System.out.println(result);
                break;
            }
        }
        return result;
    }
}
