package utility;

import java.sql.SQLException;
import java.util.Date;

public interface HelperMethods {

//book table related query methods

    //add a book

boolean addBook(String book_name,String author_name,int number_Of_page,String publisher,String category) throws SQLException;

//add a user

boolean addUser(String userName,int role) throws SQLException;

//issue book by admin
    //due date should be around 15 days from the date of lending the book

boolean issueBook() throws SQLException;



}
