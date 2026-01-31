package org.example.login;

import org.example.login.model.LoginModel;
import org.example.login.presenter.LoginPresenter;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("enter the user name:");
        String userName = sc.nextLine();

        System.out.println("enter the password:");
        String passWord = sc.nextLine();

        LoginPresenter loginPresenter = new LoginPresenter(new LoginModel(user),);

    }
}