package org.example.login.presenter;

import org.example.login.model.LoginModel;
import org.example.login.repository.UserRepoImplementation;
import org.example.login.repository.UserRepository;
import org.example.login.view.LoginView;

public class LoginPresenter {

    private final LoginView loginView;
    private final LoginModel loginModel;

    public void loginSuccess(){

        loginView.showLoginSuccess();

    }
    public void loginFailed(){

        loginView.showLoginError();

    }

    public LoginPresenter(LoginView loginView){

        this.loginView = loginView;

        //UserRepository userRepository = new UserRepoImplementation();

        this.loginModel = new LoginModel(this);

    }

    public void login(String userName,String password){

        loginModel.validateLogin(userName,password);

    }


}
