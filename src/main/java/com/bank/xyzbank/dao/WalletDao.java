package com.bank.xyzbank.dao;

import com.bank.xyzbank.model.BankWallet;

public interface WalletDao {

    void updateWallet(BankWallet wallet);

    BankWallet getWalletById(int walletId);

}
