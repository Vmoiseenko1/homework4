package com.company;

public class WrongCredentialsException extends Exception{
    public String toString(){
        return "Неверно введены email и/или пароль";
    }
}
