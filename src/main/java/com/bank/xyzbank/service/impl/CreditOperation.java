package com.bank.xyzbank.service.impl;

import com.bank.xyzbank.model.BankWallet;
import com.bank.xyzbank.service.WalletOperation;

public class CreditOperation implements WalletOperation {

    public BankWallet performOperation(BankWallet wallet, double transactionAmount) {
        wallet.setBalance(wallet.getBalance() + transactionAmount);
        return wallet;
    }

}
