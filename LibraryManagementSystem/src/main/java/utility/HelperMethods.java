package utility;

import java.sql.SQLException;

public interface HelperMethods {

//book table related query methods

    //add a book

boolean addBook(String book_name,String author_name,int number_Of_page,String publisher,String category) throws SQLException;

//add a user

boolean addUser(String userName,int role) throws SQLException;


}
