package TextOperations;

import java.util.List;

public interface TextFunctions {

    //write operations

    String insert(String newWord, List<String> words, int rowNumber, int columnNumber);

    void delete(String deleteWord,List<String> words,int rowNumber);

    void deleteInRange(List<String> words , int rowNumber, int start, int end);

    void deleteLine(List<String> words, int rowNumber);

    void findAndReplace(String searchWord,List<String> words, int rowNumber ,String replaceWord);

    //read operations

    void print(List<String> words);

    boolean search(String SearchWord,List<String> words);

   int wordCount(String word,List<String> words);

}
