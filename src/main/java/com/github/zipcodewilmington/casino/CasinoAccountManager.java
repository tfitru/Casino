package com.github.zipcodewilmington.casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    private static Logger logger = Logger.getLogger(CasinoAccountManager.class.getName());
    private HashMap<String, CasinoAccount> accountCasinoMap = new HashMap<>();
    private List<CasinoAccount> casAcc = new ArrayList<>();

    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        for (CasinoAccount casAccount : casAcc) {
            if (accountName.equals(casAccount.getAccountName()) && accountPassword.equals(casAccount.getAccountPassword())) {
                return casAccount;
            } else {
                System.out.println("Account and Password does not match! Please Try again");
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
    public CasinoAccount createAccount(String accountName, String accountPassword) {
        CasinoAccount newAcc = new CasinoAccount(accountName,accountPassword);
        registerAccount(newAcc);
        return newAcc;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
        casAcc.add(casinoAccount);
        String accountName = casinoAccount.getAccountName();
        accountCasinoMap.put(accountName,casinoAccount);
        System.out.println("Finished registering account " +accountName);
    }
}
