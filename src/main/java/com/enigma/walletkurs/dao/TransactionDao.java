package com.enigma.walletkurs.dao;

import java.util.List;

import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.InsufficientAmountException;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.TransactionEntity;
import com.enigma.walletkurs.models.dto.TransactionDto;

public interface TransactionDao {
    TransactionEntity topUp(TransactionDto transaction) throws EntityNotFoundException;
    TransactionEntity transfer(TransactionDto transaction) throws EntityNotFoundException, InsufficientAmountException;
    TransactionEntity withdraw(TransactionDto transaction) throws EntityNotFoundException, InsufficientAmountException;
    TransactionEntity getTransactionById(String transactionID);
    TransactionEntity buyAsset(String account,Double amount);
    TransactionEntity sellAsset(String account,Double amount);
    List<TransactionEntity> getTransactionsByAccountNumber(String accountNumber);
	TransactionEntity openaccount(AccountEntity transaction);
}
