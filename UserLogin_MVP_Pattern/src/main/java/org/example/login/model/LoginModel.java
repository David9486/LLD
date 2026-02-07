package org.example.login.model;

import org.example.login.presenter.LoginPresenter;
import org.example.login.repository.UserRepoImplementation;
import org.example.login.repository.UserRepository;

public class LoginModel {

    private final UserRepository userRepository;
    private final LoginPresenter loginPresenter;

    public LoginModel(LoginPresenter loginPresenter){

        userRepository = new UserRepoImplementation();
        this.loginPresenter = loginPresenter;

    }//

    public void validateLogin(String userName,String password){

        if(userName == null || password == null){

            loginPresenter.loginFailed();

        }

        else if(userRepository.checkLogin(userName,password)){

            loginPresenter.loginSuccess();

        }

        else{

            System.out.println("something went wrong");

        }

    }

}
