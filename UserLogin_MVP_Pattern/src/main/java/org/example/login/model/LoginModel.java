package org.example.login.model;

import org.example.login.repository.UserRepository;

public class LoginModel {

    private final UserRepository userRepository;

    public LoginModel(UserRepository userRepository){

        this.userRepository = userRepository;

    }

    public boolean validateLogin(String userName,String password){

        if(userName == null || password == null){

            return false;

        }

        return userRepository.checkLogin(userName,password);

    }

}
