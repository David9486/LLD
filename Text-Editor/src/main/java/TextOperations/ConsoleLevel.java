package TextOperations;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ConsoleLevel extends TextFormat implements TextFunctions{







    @Override

    public String insert(String newWord,List<String> words, int rowNumber, int columnNumber){

        StringBuilder build = new StringBuilder();
        for(int i=0;i<words.size();i++){

            String lines=words.get(i);

            if(rowNumber-1==i) {

                String formedWord = lines.substring(0, columnNumber) +" "+ newWord +" "+ lines.substring(columnNumber);
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

        String line = words.get(rowNumber-1);

        String[] wordList = line.split("\\s+");

        for(String word : wordList){

            String cleanWord = word.replaceAll("[^a-zA-Z]","");

            if(!cleanWord.equalsIgnoreCase(deleteWord)){

                tempBuild.append(word).append(" ");

            }

        }
        words.set(rowNumber-1,tempBuild.toString());

    }

    @Override

    public void deleteInRange(List<String> words , int rowNumber, int start, int end ){

        StringBuilder tempBuild = new StringBuilder();

        if (rowNumber < 1 || rowNumber > words.size()) {
            return;
        }

        String line = words.get(rowNumber-1);



        if((start>=0 && start<end) && (end<=line.length())){



            tempBuild.append(line,0,start-1).append(" ").append(line,end,line.length()).append(" ");



        }

        words.set(rowNumber-1,tempBuild.toString());



    }
@Override
    public void deleteLine(List<String> words, int rowNumber){

        words.remove(rowNumber-1);

    }

    @Override

    public void findAndReplace(String searchWord,List<String> words, int rowNumber ,String replaceWord){

        StringBuilder tempBuild = new StringBuilder();

        String line = words.get(rowNumber-1);

        String[] wordList = line.split("\\s+");

        for(String word : wordList){

            String cleanWord = word.replaceAll("[^a-zA-Z]","");

            if(cleanWord.equalsIgnoreCase(searchWord)){


                tempBuild.append(replaceWord).append(" ");

            }
            else{

                tempBuild.append(word).append(" ");

            }






        }
        words.set(rowNumber-1,tempBuild.toString());


    }

    //printing method

    @Override

    public void print(List<String> words){

        for(String word : words){

            System.out.println(word);

        }

    }





    @Override

    public int wordCount(String newWord,List<String> words){

        int count=0;

        for(int i=0;i<words.size();i++) {


            String[] word = words.get(i).split("\\s+");

            for (int j = 0; j < word.length; j++) {

                String clearWord = word[j].replaceAll("[^a-zA-Z]","");

                if (clearWord.equalsIgnoreCase(newWord)) {

                    count++;

                }

            }
        }
        return count;

    }

    @Override
    public boolean search(String searchWord,List<String> wordList){

        for(String word : wordList){

            String[] tempWordList = word.split("\\s+");

            for(int i=0;i< tempWordList.length;i++){

                String cleanWord = tempWordList[i].replaceAll("[^a-zA-Z]","");

                if(cleanWord.equalsIgnoreCase(searchWord)){

                    return true;

                }

            }

        }

        return false;

    }
    public String listToString(List<String> wordList){

        StringBuilder build = new StringBuilder();

        for(String word : wordList){

            build.append(word).append(" ");

        }

        return build.toString();

    }

    public static void main(String[] args) {

        TextFunctions tfu = new ConsoleLevel();

        TextFormat tf = new ConsoleLevel();

        List<String> words = new ArrayList<>();

        List<String> wd;

        words.add("Independence day, observed annually on 15 August, is a national holiday in India commemorating the nations Independence from british rule on 15 August 1947");

        String word = "Independence day, observed annually on 15 August, is a national holiday in India commemorating the nations Independence from british rule on 15 August 1947";

        words = tf.FormatedLine(word);



        //System.out.println(words);

        wd = tf.FormatedLine(tfu.insert("Davi",words,2,5));



        tfu.print(wd);

    }

}
