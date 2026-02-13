package dao;

import model.Book;
import utility.DbConnection;
import utility.HelperMethods;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DbMethods implements HelperMethods {


 private Book book;



    @Override
    public boolean addBook(String bookName, String authorName, int numberOfPage, String publisher, String category) throws SQLException {

        String query="INSERT INTO book(book_name,author_name,number_of_pages,publisher,category)VALUES(?,?,?,?,?)";
        try(Connection connection = DbConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1,bookName);
            preparedStatement.setString(2,authorName);
            preparedStatement.setInt(3,numberOfPage);
            preparedStatement.setString(4,publisher);
            preparedStatement.setString(5,category);

            return preparedStatement.executeUpdate()>0;

        }

    }
    @Override

    public boolean addUser(String userName,int role) throws SQLException{

        String query = "INSERT INTO users(user_name,role) VALUES(?,?)";
        try(Connection connection = DbConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1,userName);
            preparedStatement.setInt(2,role);

            return preparedStatement.executeUpdate()>0;

        }

    }

    //issue book


    @Override
    public boolean issueBook() throws SQLException{

        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = currentDate.plusDays(15);

        String query = "INSERT INTO issuedbook(issue_date,due_date) VALUES(?,?)";

        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setDate(1,Date.valueOf(currentDate));
            preparedStatement.setDate(2, Date.valueOf(dueDate));

            return preparedStatement.executeUpdate()>0;

        }

    }



    //return book
    @Override
    public boolean returnBook(int bookId,int userId,Date dueDate,Date returnDate,Date issueDate) throws SQLException{

        int fine=payFine(dueDate,returnDate);
        String query = "INSERT INTO issuedbook(user_id,book_id,issue_date,due_date,return_date,fine) VALUES(?,?,?,?,?,?)";
        if(fine>0){

            displayFine(fine);

        }
        try(Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query) ){

            preparedStatement.setInt(1,userId);
            preparedStatement.setInt(2,bookId);
            preparedStatement.setDate(3,issueDate);
            preparedStatement.setDate(4,dueDate);
            preparedStatement.setDate(5,returnDate);
            preparedStatement.setInt(6,fine);

            return preparedStatement.executeUpdate()>0;

        }



    }

    //per day fine rs.20 after due date
    private int payFine(Date dueDate,Date returnDate){

        int fine=0;

        if(returnDate.before(dueDate) || returnDate.equals(dueDate)){

            return fine;

        }
        else{

            long days = ChronoUnit.DAYS.between(convertToLocalDate(returnDate),convertToLocalDate(dueDate));
            fine = (int) days*20;

        }

        return fine;

    }

    private LocalDate convertToLocalDate(Date date){

        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

    }

    private void displayFine(int fine){

        System.out.println("fine to be paid: "+fine);

    }

    //method to display the books which are available.


    @Override
    public List<Book> showBooks() throws SQLException{

        String query = "SELECT * FROM book";
        List<Book> list = new ArrayList<>();



        try(Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){

                this.book = new Book();

                this.book.setBookId(rs.getInt("book_id"));
                this.book.setBookName(rs.getString("book_name"));
                this.book.setAuthorName(rs.getString("author_name"));
                this.book.setNumberOfPages(rs.getInt("number_of_pages"));
                this.book.setPublisher(rs.getString("publisher"));
                this.book.setCategory(rs.getString("category"));
                list.add(book);

            }

        }
        return list;
    }
}
