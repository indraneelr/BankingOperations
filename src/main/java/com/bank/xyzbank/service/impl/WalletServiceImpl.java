package com.bank.xyzbank.service.impl;

import com.bank.xyzbank.dao.WalletDao;
import com.bank.xyzbank.exception.InvalidOperationException;
import com.bank.xyzbank.factory.WalletOperationFactory;
import com.bank.xyzbank.model.BankWallet;
import com.bank.xyzbank.model.Transaction;
import com.bank.xyzbank.service.WalletOperation;
import com.bank.xyzbank.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class WalletServiceImpl implements WalletService {

    private static final Logger LOGGER = Logger.getLogger(WalletServiceImpl.class.getName());

    @Autowired
    private WalletOperationFactory operationFactory;

    @Autowired
    private WalletDao walletDao;

    public void doTransaction(Transaction transaction) {

        try {
            WalletOperation operation = operationFactory.generateWalletOperation(transaction.getOperation());
            BankWallet wallet = fetchWalletById(transaction.getWalletId());
            operation.performOperation(wallet, transaction.getTransactionAmount());
            walletDao.updateWallet(wallet);
        } catch (InvalidOperationException exception) {
            logExceptionMessage(exception);
        }
    }

    private BankWallet fetchWalletById(int walletId) {
        BankWallet wallet = walletDao.getWalletById(walletId);
        if (wallet.getWalletId() <= 0) {
           return null;
        }
        return wallet;
    }

    private void logExceptionMessage(Exception e) {
        LOGGER.info(e.getMessage());
    }

    private void updateWalletBalance(BankWallet bankWallet) {

    }
}
