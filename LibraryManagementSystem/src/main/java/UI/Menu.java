package UI;

import dao.DbMethods;
import model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu extends DbMethods {
    private final static DbMethods UI = new Menu();
    private static final Scanner sc = new Scanner(System.in);


    public void displayUserMenu(){

        System.out.println("=====USER MENU=====");
        System.out.println("1.Register");
        System.out.println("2.Available Books");
        System.out.println("3.Search A Book");
        System.out.println("3.Get A Book");
        System.out.println("4.Return Book");
        System.out.println("5.Exit");

        boolean flag=true;

        int choice=sc.nextInt();

        sc.nextLine();

        while(flag){

            try {
                switch (choice) {

                    case 1: //register

                        System.out.println("if your a user enter 1:");
                        int role = sc.nextInt();

                        sc.nextLine();

                        System.out.println("Enter your user name:");
                        String userName=sc.nextLine();

                        if(UI.addUser(userName,role)){

                            System.out.println("User successfully register!");

                        }
                        else{

                            System.out.println("something went wrong");

                        }

                    case 2: // list of books

                        List<Book> list = UI.showBooks();

                        if(!list.isEmpty()) {
                            int serialNo = 1;
                            for (Book b : list) {

                                System.out.println("----Record: " + serialNo + "----");
                                System.out.println("book name: " + b.getBookName());
                                System.out.println("author name: " + b.getAuthorName());
                                System.out.println("book id: " + b.getBookId());
                                System.out.println("number of pages: " + b.getNumberOfPages());
                                System.out.println("publisher: " + b.getPublisher());
                                System.out.println("category: " + b.getCategory());

                                serialNo++;

                            }
                        }
                        else{

                            System.out.println("something went wrong");

                        }

                    case 3: //search a book

                        System.out.println("enter the book name:");
                        String bookName=sc.nextLine();

                        if(UI.searchBook(bookName)){

                            System.out.println("The book "+bookName+" is available");

                        }
                        else{

                            System.out.println("The book "+bookName+" not available");

                        }





                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }

}
