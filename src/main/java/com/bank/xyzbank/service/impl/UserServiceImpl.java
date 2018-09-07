package com.bank.xyzbank.service.impl;

import com.bank.xyzbank.dao.UsersDao;
import com.bank.xyzbank.model.BankUser;
import com.bank.xyzbank.model.BankWallet;
import com.bank.xyzbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

@Component
public class UserServiceImpl implements UserService {

    public static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    @Autowired
    private UsersDao userDao;

    public int addUserToBank(BankUser anUser) {
        int userId = 0;
        if (mandatoryParamsPresent(anUser)) {
            setWalletToUser(anUser);
            userId = userDao.createUser(anUser);
        }
        return userId;
    }

    public int updateUserDetails(BankUser theUser) {

        return 1;
    }

    public int deleteUserFromBank(BankUser theUser) {

        return 1;
    }

    public BankUser fetchUserDetails(int userId) {

        return null;
    }

    private BankUser setWalletToUser(BankUser anUser) {
        Set<BankWallet> linkedWallets = new HashSet<BankWallet>();

        if (linkedWallets.isEmpty()) {
            BankWallet newWallet = new BankWallet();
            newWallet.setLinkedUser(anUser);
            linkedWallets.add(newWallet);
        }
        anUser.setLinkedWallets(linkedWallets);
        return anUser;
    }

    private boolean mandatoryParamsPresent(BankUser bankUser) {
        return !(bankUser.getUserName() != null && bankUser.getEmail() != null && !isValidEmail(bankUser.getEmail()));
    }

    private boolean isValidEmail(String email) {
        Pattern pat = Pattern.compile(EMAIL_VALIDATION_REGEX);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
