package com.bank.xyzbank.service;

import com.bank.xyzbank.model.BankUser;

public interface UserService {

    int addUserToBank(BankUser anUser);

    int updateUserDetails(BankUser theUser);

    int deleteUserFromBank(BankUser theUser);

    BankUser fetchUserDetails(int userId);
}
