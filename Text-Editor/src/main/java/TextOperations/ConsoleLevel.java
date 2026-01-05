package TextOperations;

import java.util.ArrayList;
import java.util.List;

public class ConsoleLevel implements TextFunctions{



    List<String> containsWord = new ArrayList<>();

    private StringBuilder build = new StringBuilder();

    @Override

    public String insert(String newWord,List<String> words, int rowNumber, int columnNumber){

        for(int i=0;i< words.size();i++){

            String lines=words.get(i);

            if(rowNumber-1==i) {

                String formedWord = lines.substring(0, columnNumber) + newWord + lines.substring(columnNumber);
                build.append(formedWord);

            }
            else{

                build.append(lines).append(" ");

            }

        }

        return build.toString();

    }

    @Override

    public void delete(String deleteWord,List<String> words,int rowNumber){
        
        StringBuilder tempBuild = new StringBuilder();

        for(int i=0;i<words.size();i++){

            if(rowNumber-1 == i){

                String[] word = words.get(i).split(" ");

                for(int j=0;j<word.length;j++){

                    if(word[i].equals(deleteWord)){

                        word[i]="";      //removing words that matches.

                    }

                }

                for(int n=0;n<word.length-1;n++){

                    tempBuild.append(word[n]).append(" ");
                                                             //loop for building the string back
                }
                tempBuild.append(word[word.length-1]);

            }

        }

        words.remove(rowNumber);
        words.add(rowNumber,tempBuild.toString());

    }

    //printing method

    @Override

    public void print(List<String> words){

        for(String word : words){

            System.out.println(word);

        }

    }

    public boolean search(String searchWord,List<String> words){

        for(int i=0;i<words.size();i++) {


            String[] word = words.get(i).split(" ");

            for (int j = 0; j < word.length; j++) {

                if (word[i].equals(searchWord)) {

                    return true;

                }

            }
        }

        return false;
    }

    public int wordCount(String newWord,List<String> words){

        int count=0;

        for(int i=0;i<words.size();i++) {


            String[] word = words.get(i).split(" ");

            for (int j = 0; j < word.length; j++) {

                if (word[i].equals(newWord)) {

                    count++;

                }

            }
        }
        return count;

    }

}
