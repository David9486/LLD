package TextOperations;

import java.util.List;

public interface TextFunctions {

    //write operations

    String insert(String newWord, List<String> words, int rowNumber, int columnNumber);

    void delete(String deleteWord,List<String> words,int rowNumber);

    //void deleteCharacters();

    //void deleteLine();

    //void findAndReplace();

    //read operations

    void print(List<String> words);

    boolean search(String SearchWord,List<String> words);

   int wordCount(String word,List<String> words);

}
