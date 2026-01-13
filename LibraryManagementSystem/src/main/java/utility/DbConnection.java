package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String userName="postgres";
    private static final String passWord="root";

    public static Connection getConnection() throws SQLException {

        try{

            Class.forName("org.postgres.Driver");

        } catch (ClassNotFoundException e) {

            throw new RuntimeException("Driver not found!",e);

        }

        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/libraryManagement",userName,passWord);

    }


}
