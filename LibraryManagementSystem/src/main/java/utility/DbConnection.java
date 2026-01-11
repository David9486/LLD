package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection getConnection(String userName,String passWord) throws SQLException {

        try{

            Class.forName("org.postgres.Driver");

        } catch (ClassNotFoundException e) {

            throw new RuntimeException("Driver not found!",e);

        }

        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/libraryManagement",userName,passWord);

    }


}
