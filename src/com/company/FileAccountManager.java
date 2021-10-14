package com.company;

import java.io.IOException;
import java.util.List;

import static com.company.FileService.getInstance;
import static com.company.FileService.write;

public class FileAccountManager implements AccountManager {
    @Override
    public void register(Account account) {
        try {
            List<Account> accounts = getInstance().read();
            for (Account acc : accounts) {
                if (acc.getEmail().equals(account.getEmail())) {
                    throw new AccountAlreadyExistsException();
                }
            }
            write(account, true);
        } catch (AccountAlreadyExistsException | IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    @Override
    public Account login(String email, String password) {
        try {
            List<Account> accounts = getInstance().read();
            try {
                for (Account acc : accounts) {
                    if (acc.getEmail().equals(email) && acc.getPass().equals(password) && !acc.getBlocked()) {
                        System.out.println("Logged");
                        return acc;
                    } else if (acc.getEmail().equals(email) && acc.getPass().equals(password) && acc.getBlocked()) {
                        throw new AccountBlockedException();
                    }
                }
                throw new WrongCredentialsException();
            } catch (AccountBlockedException e) {
                System.out.println("Exception: " + e);
            } catch (WrongCredentialsException e) {
                System.out.println("Exception: " + e);
                for (Account account : accounts){
                    if(account.getEmail().equals(email)){
                        FailedLoginCounter.increaseNumberOfMistakes(account);
                        return null;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        System.out.println("Exit");
        return null;
    }

    @Override
    public void removeAccount(String email, String password) {
        try {
            List<Account> accounts = getInstance().read();
            for (Account acc : accounts) {
                if (acc.getEmail().equals(email) || acc.getPass().equals(password)) {
                    accounts.remove(acc);
                    break;

                }
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}

