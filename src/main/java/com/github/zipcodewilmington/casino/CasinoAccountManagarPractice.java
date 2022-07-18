package com.github.zipcodewilmington.casino;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CasinoAccountManagarPractice {
    public List<CasinoAccountPractice> casAcc = new ArrayList<>();
    private Integer balance;
    String userName, passWord;
    Integer bal;

    private File newFile = new File("Login2.txt");

    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccountPractice getAccount(String accountName, String accountPassword) {
        for (CasinoAccountPractice casAccount : casAcc) {
            if (accountName.equals(casAccount.getAccountName()) && accountPassword.equals(casAccount.getAccountPassword())) {
                return casAccount;
            } else {
                System.out.println("Account or Password does not match! Please Try again");
            }
        }
        return null;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */

    public CasinoAccountPractice createAccount(String accountName, String accountPassword, Integer balance) {
        CasinoAccountPractice newAcc = new CasinoAccountPractice(accountName, accountPassword, balance);
        registerAccount(newAcc);
        return newAcc;
    }

    //
//    /**
//     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
//     *
//     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
//     */
    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     //* @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     * @param newAcc
     */
    public List<CasinoAccountPractice> registerAccount (CasinoAccountPractice newAcc){
//        casAcc.add(casinoAccount);
//        String accountName = casinoAccount.getAccountName();
        this.casAcc.add(newAcc);
        for(int i =0; i<this.casAcc.size(); i++) {
            System.out.println("Finished registering account " + this.casAcc.get(i).getAccountName());
        }
        writeToFile();
        return this.casAcc;
    }




    public void writeToFile(){
        if(newFile.length() == 0) {
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
                for(CasinoAccountPractice casinoAccount: this.casAcc){
                    writer.write("\n" + casinoAccount.getAccountName() + "," + casinoAccount.getAccountPassword() + "," + casinoAccount.getBalance());
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (newFile.length()!=0 && newFile.equals(casAcc.get(0))){
            System.out.println("Wrong");
        }
        }



    void readFile() {
        try{
            FileReader fr = new FileReader(newFile);
        } catch (FileNotFoundException ex){
            try {
                FileWriter fw = new FileWriter(newFile);
            } catch (IOException ex1){
                Logger.getLogger(CasinoAccountManager.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    void CheckData(String user, String pwd) {
        try {
            RandomAccessFile raf = new RandomAccessFile(newFile+"\\Login2.txt", "rw");
            String line = raf.readLine();
            userName = line.substring(7);
            passWord = raf.readLine().substring(7);
            if(user.equals(userName) & pwd.equals(passWord)){
                System.out.println("Password matched, welcome " + user);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CasinoAccountManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    }

