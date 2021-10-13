package com.company;

import java.io.IOException;
public class Main {

    public static void main(String[] args) throws IOException {
        FileAccountManager manager = new FileAccountManager();
        manager.register(new Account("МВД", "21.09.2001", "JJJ@gmail.com", "popit"));
        manager.register(new Account("МВД", "21.09.2001", "JJJ@gnail.com", "popit"));

        manager.removeAccount("JJJ@gnail.com", "password");

    }
}