package com.enigma.walletkurs.dao;

import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.models.TransactionEntity;

public interface TransactionDao {
    TransactionEntity topUp(TransactionEntity transaction);
    TransactionEntity transfer(TransactionEntity transaction);
    TransactionEntity widthraw(TransactionEntity transaction);
    TransactionEntity getTransactionById(String transactionID);
}
