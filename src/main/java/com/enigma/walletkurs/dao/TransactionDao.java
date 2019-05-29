package com.enigma.walletkurs.dao;

import com.enigma.walletkurs.models.TransactionEntity;

public interface TransactionDao {
    TransactionEntity topUp(TransactionEntity transaction);

    TransactionEntity transfer(TransactionEntity transaction);

    TransactionEntity withdraw(TransactionEntity transaction);

    TransactionEntity getTransactionById(String transactionID);

    TransactionEntity getTransactionsByAccountNumber(String accountNumber);

    TransactionEntity getTransactionsByCustomerNumber(String customerNumber);
}
