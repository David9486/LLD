package dao;

import utility.DbConnection;
import utility.HelperMethods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbMethods implements HelperMethods {






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
}
