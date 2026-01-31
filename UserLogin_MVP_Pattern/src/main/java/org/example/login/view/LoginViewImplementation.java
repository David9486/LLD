package org.example.login.view;

public class LoginViewImplementation implements LoginView{

    @Override
    public void showLoginSuccess(){

        System.out.println("login successfully!");

    }

    @Override
    public void showLoginError(){

        System.out.println("login error!");

    }
}
