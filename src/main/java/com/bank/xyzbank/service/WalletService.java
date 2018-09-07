package com.bank.xyzbank.service;

import com.bank.xyzbank.model.Transaction;

public interface WalletService {

    void doTransaction(Transaction transaction);
}
