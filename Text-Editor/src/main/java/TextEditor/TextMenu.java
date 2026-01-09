package TextEditor;

import TextOperations.ConsoleLevel;
import TextOperations.TextFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextMenu extends TextFormat {

    private static TextFormat textAlign;
    private static final Scanner sc = new Scanner(System.in);
    private static List<String> wordList;
    private static final ConsoleLevel console = new ConsoleLevel();
    private static int rowNumber;



    public static void main(String[] args) throws Exception{



        try{

            System.out.println("Enter the texts:");

            String words = sc.nextLine();

            textAlign = new TextMenu();
            wordList=textAlign.FormatedLine(words);



            boolean flag=true;

            while(flag) {

                System.out.println("====Text Editor====");
                System.out.println("1.Insert");
                System.out.println("2.Search");
                System.out.println("3.Delete");
                System.out.println("4.Delete Line");
                System.out.println("5.Delete character in a range");
                System.out.println("6.Find and Replace");
                System.out.println("7.Print");
                System.out.println("8.Word count");
                System.out.println("9.Exit");





                System.out.println("Enter your choice:");
                int choice = sc.nextInt();

                sc.nextLine();


                switch (choice) {

                    case 1: //insert

                        System.out.println("Enter the word to insert:");
                        String wordInsert = sc.nextLine();
                        System.out.println("Enter the row number:");
                        rowNumber = sc.nextInt();
                        System.out.println("Enter the column number:");
                        int columnNumber = sc.nextInt();


                        String result = console.insert(wordInsert, wordList, rowNumber, columnNumber);
                        System.out.println(rowNumber +" "+ columnNumber);
                        System.out.println(result);
                        wordList = console.FormatedLine(result);

                        System.out.println("Word inserted successfully!");

                        break;

                    case 2:  //search

                        sc.nextLine();
                        System.out.println("Enter the word to search:");
                        String wordSearch = sc.nextLine();

                        if (console.search(wordSearch, wordList)) {

                            System.out.println("Word found!");

                        } else {

                            System.out.println("Word entered doesn't exist!");

                        }

                        break;

                    case 3:  //delete

                        System.out.println("Enter the word to delete");
                        String word = sc.nextLine();


                        System.out.println("Enter the row number:");
                        rowNumber = sc.nextInt();
                        console.delete(word, wordList, rowNumber);

                        wordList = textAlign.FormatedLine(console.listToString(wordList));

                        System.out.println("Word deleted successfully!");

                        break;

                    case 4:  //delete Lines

                        System.out.println("Enter the row number:");
                        rowNumber = sc.nextInt();

                        console.deleteLine(wordList, rowNumber);

                        System.out.println("Line " + rowNumber + " deleted successfully");

                        break;

                    case 5: //delete in range

                        System.out.println("Enter the row number:");
                        rowNumber = sc.nextInt();

                        System.out.println("Enter the starting point:");
                        int start = sc.nextInt();

                        System.out.println("Enter the ending point:");
                        int end = sc.nextInt();

                        console.deleteInRange(wordList, rowNumber, start, end);



                        System.out.println("Successfully deleted the characters between range!");

                        break;

                    case 6: //find and replace

                        sc.nextLine();

                        System.out.println("Enter the word to search:");
                        String searchWord = sc.nextLine();



                        System.out.println("Enter the row number:");
                        rowNumber = sc.nextInt();

                        sc.nextLine();

                        System.out.println("Enter the word to replace:");
                        String replaceWord = sc.nextLine();

                        console.findAndReplace(searchWord, wordList, rowNumber, replaceWord);

                        wordList=console.FormatedLine(console.listToString(wordList));

                        System.out.println("word replaced successfully!");

                        break;

                    case 7: //print

                        console.print(wordList);

                        break;

                    case 8: //word count

                        System.out.println("Enter the word for counting:");
                        String wordToCount = sc.nextLine();

                        int count = console.wordCount(wordToCount, wordList);
                        System.out.println("Count of \"" + wordToCount + "\": " + count);

                        break;

                    case 9: // exit

                        flag = false;
                        break;

                    default:

                        System.out.println("sorry wrong choice.. please enter a valid option");
                        break;


                }


            }



        }

        catch (Exception e) {

           throw new Exception(e.getMessage());

        }


    }

}
