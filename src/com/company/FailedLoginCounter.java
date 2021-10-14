package com.company;

import java.util.ArrayList;

public class FailedLoginCounter {

    private static FailedLoginCounter instance;
    private static int numberOfMistakes;
    ArrayList<Account> accounts = new ArrayList<Account>();


    public static synchronized FailedLoginCounter getInstance() {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    private FailedLoginCounter() {

    }

    public static void increaseNumberOfMistakes(Account account) {
        numberOfMistakes += 1;
        if (numberOfMistakes >= 5) {
            account.setBlocked(true);

            System.out.println("Account is blocked");
            numberOfMistakes = 0;
        }
    }

    public int getNumberOfMistakes() {
        return numberOfMistakes;
    }

    public static void blocked() {
        for (Account account : getInstance().accounts) {
            if (numberOfMistakes >= 5) {
                account.setBlocked(false);

                numberOfMistakes = 0;
            }
        }
    }
//    Дополнительно необходимо создать класс-синглтон
//    FailedLoginCounter, который будет считать количество неудачных
//    попыток залогиниться. В случае, если пользователь 5 раз подряд
//    неправильно вводит пароль, необходимо заблокировать этого
//    пользователя (поставить в поле blocked значение true).
}
