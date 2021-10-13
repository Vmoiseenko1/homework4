package com.company;

public class AccountAlreadyExistsException extends Exception{
    public String toString(){
        return "Аккаунт с таким email уже существует";
    }
}

