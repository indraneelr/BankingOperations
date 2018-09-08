package com.bank.xyzbank.service.impl;

import com.bank.xyzbank.model.BankWallet;
import com.bank.xyzbank.service.WalletOperation;

public class DebitOperation implements WalletOperation {

    public BankWallet performOperation(BankWallet wallet, double transactionAmount) {
        double currentBalance = wallet.getBalance();
        if (!isBalanceNegative(wallet) && canDebit(currentBalance, transactionAmount)) {
            wallet.setBalance(currentBalance - transactionAmount);
        }
        return wallet;
    }

    private boolean canDebit(double balanceAmount, double creditAmount) {

        return balanceAmount >= creditAmount;
    }
}
