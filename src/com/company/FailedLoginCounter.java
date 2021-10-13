package com.company;

public class FailedLoginCounter {

    private static FailedLoginCounter instance;
    private static int numberOfMistakes;

    public static synchronized FailedLoginCounter getInstance(){
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }
    private FailedLoginCounter(){

    }
    public static void increaseNumberOfMistakes(){
        numberOfMistakes += 1;
    }
    public int getNumberOfMistakes(){
        return numberOfMistakes;
    }
//    Дополнительно необходимо создать класс-синглтон
//    FailedLoginCounter, который будет считать количество неудачных
//    попыток залогиниться. В случае, если пользователь 5 раз подряд
//    неправильно вводит пароль, необходимо заблокировать этого
//    пользователя (поставить в поле blocked значение true).
}
