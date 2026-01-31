package org.example.login.repository;

public sealed interface UserRepository permits UserRepoImplementation {

    public boolean checkLogin(String userName, String password);

}
