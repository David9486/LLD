package utility;

import model.Book;
import model.User;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface HelperMethods {

//book table related query methods

    //add a book

boolean addBook(String book_name,String author_name,int number_Of_page,String publisher,String category) throws SQLException;

//add a user

boolean addUser(String userName,int role) throws SQLException;

//issue book by admin
    //due date should be around 15 days from the date of lending the book

boolean issueBook(int bookId,int userId) throws SQLException;

//return book
    //calculate fine amount if any -> if return date exceeds due date then per day 20rs fine

boolean returnBook(int bookId, int userId, java.sql.Date dueDate, java.sql.Date returnDate) throws SQLException;

//to display list of books
List<Book> showBooks() throws SQLException;

//to search for a book by title or author

boolean searchBook(String bookName) throws SQLException;

//to view all users only for admin access level

List<User> viewAllUser() throws SQLException;

User searchUserById(int userId) throws SQLException;

//to check if the user is blocked or not

boolean

}
