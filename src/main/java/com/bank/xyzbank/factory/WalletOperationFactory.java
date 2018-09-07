package com.bank.xyzbank.factory;

import com.bank.xyzbank.exception.InvalidOperationException;
import com.bank.xyzbank.service.WalletOperation;
import com.bank.xyzbank.service.impl.CreditOperation;
import com.bank.xyzbank.service.impl.DebitOperation;
import org.springframework.stereotype.Component;

@Component
public class WalletOperationFactory {

    public static final String CREDIT_OPERATION_TYPE = "Credit";
    public static final String DEBIT_OPERATION_TYPE = "Debit";

    public WalletOperation generateWalletOperation(String operationType) throws InvalidOperationException {
        switch (operationType) {
            case CREDIT_OPERATION_TYPE:
                return new CreditOperation();
            case DEBIT_OPERATION_TYPE:
                return new DebitOperation();
            default:
                throw new InvalidOperationException("Please provide valid operation to perform in wallet !");
        }
    }
}
