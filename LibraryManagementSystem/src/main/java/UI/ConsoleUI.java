package UI;

import dao.DbMethods;
import org.example.Main;

import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleUI extends DbMethods {

    private final static DbMethods UI = new ConsoleUI();

    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {

        System.out.println("Enter 1 if your a user or Enter 2 if your admin");
        int decision = sc.nextInt();


    }
}
