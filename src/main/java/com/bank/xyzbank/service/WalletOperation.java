package com.bank.xyzbank.service;

import com.bank.xyzbank.model.BankWallet;

public interface WalletOperation {

    BankWallet performOperation(BankWallet wallet, double transactionAmount);

    default boolean isBalanceNegative(BankWallet wallet) {
        return wallet.getBalance() < 0;
    }
}
