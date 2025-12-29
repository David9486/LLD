package TextOperations;

import java.util.ArrayList;
import java.util.List;

public abstract class TextFormat {

    private final int LIMIT=40;

    private StringBuilder joinWords = new StringBuilder();

    private List<String> newLines = new ArrayList<>();

    public List<String> FormatedLine(String lines){

        for(int i=0;i<lines.length();i++){

            String[] words = lines.split("\\s+");

            for(String str : words){

            }

        }



    }

}
