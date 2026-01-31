package org.example.login.repository;

import org.example.login.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public non-sealed class UserRepoImplementation implements UserRepository{

    @Override
    public boolean checkLogin(String userName, String password){

        String query = "SELECT 1 FROM USER WHERE user_name=? AND password=?";

        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ){

            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
