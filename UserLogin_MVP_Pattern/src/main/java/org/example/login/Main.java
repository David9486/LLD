package org.example.login;

import org.example.login.model.LoginModel;
import org.example.login.presenter.LoginPresenter;
import org.example.login.view.LoginView;
import org.example.login.view.LoginViewImplementation;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        LoginViewImplementation loginView = new LoginViewImplementation();


        LoginPresenter loginPresenter = new LoginPresenter(loginView);

        loginView.setLoginPresenter(loginPresenter);

        loginView.loginDetails();

    }
}