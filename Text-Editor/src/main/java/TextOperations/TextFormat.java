package TextOperations;

import java.util.ArrayList;
import java.util.List;

public abstract class TextFormat {

    private final int LIMIT=40;

    private StringBuilder joinWords = new StringBuilder();

    private List<String> newLines = new ArrayList<>();

    public  List<String> FormatedLine(String lines){

        String[] words = lines.split("\\s+");





            for(String str : words){

                if(joinWords.length() + str.length()> LIMIT){

                    newLines.add(joinWords.toString().trim());
                    joinWords.setLength(0);

                }

                joinWords.append(str).append(" ");

            }

            if(!joinWords.isEmpty()){

                newLines.add(joinWords.toString().trim());


            }



        return newLines;


    }
    //testing part




}
