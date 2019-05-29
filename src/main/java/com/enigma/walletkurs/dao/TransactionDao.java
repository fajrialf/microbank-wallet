package com.enigma.walletkurs.dao;

import com.enigma.walletkurs.models.TransactionEntity;

import java.util.List;

public interface TransactionDao {
    TransactionEntity topUp(TransactionEntity transaction);

    TransactionEntity transfer(TransactionEntity transaction);

    TransactionEntity withdraw(TransactionEntity transaction);

    TransactionEntity getTransactionById(String transactionID);

    List<TransactionEntity> getTransactionsByAccountNumber(String accountNumber);
}
