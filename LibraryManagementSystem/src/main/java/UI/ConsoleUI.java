package UI;

import dao.DbMethods;
import org.example.Main;

import java.sql.SQLException;

public class ConsoleUI extends DbMethods {
    public static void main(String[] args) throws SQLException {

        DbMethods db = new Main();

        try{

            db.addBook("Programming in java","David",250,"Java docx","Technology");
            System.out.println("data inserted into db!");
        }
        catch(Exception e){

            System.out.println(e.getMessage());

        }


    }
}
