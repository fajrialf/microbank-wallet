package com.enigma.walletkurs.dao;

import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.InsufficientAmountException;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.TradingEntity;
import com.enigma.walletkurs.models.TransactionEntity;
import com.enigma.walletkurs.models.dto.AccountDto;
import com.enigma.walletkurs.models.dto.TradingDto;
import com.enigma.walletkurs.models.dto.TransactionDto;

import java.util.List;

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
