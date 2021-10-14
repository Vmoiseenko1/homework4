package com.company;

import java.io.IOException;
public class Main {

    public static void main(String[] args) throws IOException {
        FileAccountManager manager = new FileAccountManager();
        //manager.register(new Account("MVd", "21.09.2001", "vm@gmail.com", "popit"));
        //manager.register(new Account("mvd", "21.09.2001", "v@gnail.com", "popit"));
        //manager.register(new Account("SAD", "06.04.2001", "sokol@yandex.ru", "sokpis"));

        manager.removeAccount("JJJ@gmail.com", "password");

        manager.login("vm@gmail.com", "123");
        manager.login("JJJ@gnail.com", "123");
        manager.login("vm@gmail.com", "123");
        manager.login("vm@gmail.com", "123");
        manager.login("vm@gmail.com", "123");
        manager.login("vm@gmail.com", "123");

    }
}