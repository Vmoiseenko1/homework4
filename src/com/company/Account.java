package com.company;

public class Account {
    private String fio;
    private String birthday;
    private String email;
    private String pass;
    private boolean blocked;

    public Account(String fio, String birthday, String email, String pass){
        this.fio = fio;
        this.birthday = birthday;
        this.email = email;
        this.pass = pass;
        this.blocked = false;
    }
    public Account(){}
    public String getFio(){
        return this.fio;
    }
    public String getBirthday(){
        return this.birthday;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPass(){
        return this.pass;
    }
    public boolean getBlocked(){
        return this.blocked;
    }
    public void setFio(String value){
        this.fio = value;
    }
    public void setBirthday(String value){
        this.birthday = value;
    }
    public void setEmail(String value){
        this.email = value;
    }
    public void setPass(String value){
        this.pass = value;
    }
    public void setBlocked(boolean value){
        this.blocked = value;
    }
}
