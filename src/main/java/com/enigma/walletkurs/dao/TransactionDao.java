package com.enigma.walletkurs.dao;

import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.InsufficientAmountException;
import com.enigma.walletkurs.models.TransactionEntity;
import com.enigma.walletkurs.models.dto.TransactionDto;

import java.util.List;

public interface TransactionDao {
    TransactionEntity topUp(TransactionDto transaction) throws EntityNotFoundException;
    TransactionEntity transfer(TransactionDto transaction) throws EntityNotFoundException, InsufficientAmountException;
    TransactionEntity withdraw(TransactionDto transaction) throws EntityNotFoundException, InsufficientAmountException;
    TransactionEntity getTransactionById(String transactionID);
    TransactionEntity openaccount(TransactionDto transaction);
    TransactionEntity buyAsset(TransactionDto transaction);
    TransactionEntity sellAsset(TransactionDto transaction);
    List<TransactionEntity> getTransactionsByAccountNumber(String accountNumber);
}
