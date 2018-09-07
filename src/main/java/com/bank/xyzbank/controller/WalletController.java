package com.bank.xyzbank.controller;

import com.bank.xyzbank.model.Transaction;
import com.bank.xyzbank.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @RequestMapping(value= "/transact", method = RequestMethod.POST)
    public void doTransaction(@RequestBody Transaction transaction) {
         walletService.doTransaction(transaction);
    }

}
