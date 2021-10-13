package com.company;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileService {
    private static File file;
    private static FileService instance;

    public static synchronized FileService getInstance(){
        if (instance == null) {
            instance = new FileService();
        }
        return instance;

//    Вся работа с файлом (создание потоков, чтение и запись в файл,
//    закрытие потоков) должна производиться в специальном
//    классе-синглтоне FileService.
    }
    private FileService(){}

    public static void write(Account account, boolean b){
        File file= new File("data.csv");
        FileWriter fw = null;
        String bl;
        try{
            fw = new FileWriter(file, true);
            if(account.getBlocked()){
                bl = "true";
            }else{
                bl = "false";
            }
            fw.append(account.getFio()+";"+account.getBirthday()+";"+account.getEmail()+";"+account.getPass()+";"+bl+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public List read() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("data.csv"));

        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Account> accList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            Account acc = new Account();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    acc.setFio(data);
                else if (index == 1)
                    acc.setBirthday(data);
                else if (index == 2)
                    acc.setEmail(data);
                else if (index == 3)
                    acc.setPass(data);
                else if (index == 4)
                    acc.setBlocked(Boolean.parseBoolean(data));
                else
                    System.out.println("Некорректные данные::" + data);
                index++;
            }
            index = 0;
            accList.add(acc);
        }

        //закрываем наш ридер
        reader.close();
        return accList;
    }


}
