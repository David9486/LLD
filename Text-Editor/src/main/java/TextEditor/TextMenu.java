package TextEditor;

import TextOperations.TextFormat;

import java.util.List;

public class TextMenu extends TextFormat {

    public static void main(String[] args){

        //testing part

        TextFormat tx = new TextMenu();

        String res = "Zoho interviews test LLD. LLD tests design, not syntax! hello im david happy new year all!";

        List<String> list = tx.FormatedLine(res);

        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i));

        }

        //testing part over...

    }

}
