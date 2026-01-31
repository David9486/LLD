package org.example.login.presenter;

import org.example.login.model.LoginModel;
import org.example.login.repository.UserRepoImplementation;
import org.example.login.repository.UserRepository;
import org.example.login.view.LoginView;

public class LoginPresenter {

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenter(LoginModel loginModel, LoginView loginView){

        this.loginView = loginView;

        UserRepository userRepository = new UserRepoImplementation();

        this.loginModel = new LoginModel(userRepository);

    }

    public void logic(String userName,String password){

        if(loginModel.validateLogin(userName,password)){

            loginView.showLoginSuccess();

        }

        else{

            loginView.showLoginError();

        }

    }


}
