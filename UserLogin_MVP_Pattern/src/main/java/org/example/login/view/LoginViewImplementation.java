package org.example.login.view;

import org.example.login.presenter.LoginPresenter;

import java.util.Scanner;

public class LoginViewImplementation implements LoginView{

    private final LoginPresenter loginPresenter;

    public LoginViewImplementation(){

        this.loginPresenter = new LoginPresenter(this);

    }



    public void loginDetails(){

        Scanner sc = new Scanner(System.in);

        System.out.println("enter the user name:");
        String userName = sc.nextLine();

        System.out.println("enter the password:");
        String passWord = sc.nextLine();

        loginPresenter.login(userName,passWord);

    }

    @Override
    public void showLoginSuccess(){

        System.out.println("login successfully!");

    }

    @Override
    public void showLoginError(){

        System.out.println("login error!");

    }
}
