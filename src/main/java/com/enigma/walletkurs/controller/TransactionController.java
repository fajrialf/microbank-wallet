package com.enigma.walletkurs.controller;
import com.enigma.walletkurs.dao.TransactionDao;
import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.InsufficientAmountException;
import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.helper.response.CommonResponse;
import com.enigma.walletkurs.models.TransactionEntity;
import com.enigma.walletkurs.models.dto.TransactionDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    public static final String URI_REQUEST_TRANSACTION_BY_ID = "transaction/{transactionId}";
    public static final String URI_REQUEST_TRANSACTION_TOPUP = "transaction/topup";
    public static final String URI_REQUEST_TRANSACTION_TRANSFER = "transaction/transfer";
    public static final String URI_REQUEST_TRANSACTION_WITHDRAW = "transaction/withdraw";
    public static final String URI_REQUEST_TRANSACTIONS_BY_ACCOUNT_NUMBER = "transactions/{accountNumber}";

    @Autowired
    private TransactionDao transactionDao;

    @GetMapping(value = URI_REQUEST_TRANSACTION_BY_ID)
    public CommonResponse<TransactionEntity> getTransactionById(@PathVariable(name = "transactionId") String transactionId) throws NotFoundException {
        TransactionEntity transaction = transactionDao.getTransactionById(transactionId);
        CommonResponse<TransactionEntity> resp = new CommonResponse<>();
        if (transaction == null) {
            throw new NotFoundException(44, String.format("Transaction ID %d not found", transactionId));
        } else {
            resp.setData(transaction);
        }
        return resp;
    }

    @GetMapping(value = URI_REQUEST_TRANSACTIONS_BY_ACCOUNT_NUMBER)
    public CommonResponse<List<TransactionEntity>> getTransactionsByAccountNumber(@PathVariable(name = "accountNumber") String accountNumber) throws NotFoundException {
        List<TransactionEntity> transactions = transactionDao.getTransactionsByAccountNumber(accountNumber);
        CommonResponse<List<TransactionEntity>> resp = new CommonResponse<>();
        if (transactions == null) {
            throw new NotFoundException(44, String.format("Transaction list %d doesn't exist.", accountNumber));
        } else {
            resp.setData(transactions);
        }
        return resp;
    }

    @PostMapping(value = URI_REQUEST_TRANSACTION_TOPUP)
    public CommonResponse<TransactionEntity> topUp(@RequestBody TransactionDto transaction) throws NotFoundException, EntityNotFoundException {
        CommonResponse<TransactionEntity> topUp = new CommonResponse<>();
        TransactionEntity cst = transactionDao.topUp(transaction);
        if (cst == null) {
            throw new NotFoundException(44, "Transaction failed!");
        } else {
            topUp.setData(cst);
        }
        return topUp;
    }

    @PostMapping(value = URI_REQUEST_TRANSACTION_TRANSFER)
    public CommonResponse<TransactionEntity> transfer(@RequestBody TransactionDto transaction) throws NotFoundException, EntityNotFoundException, InsufficientAmountException {
        CommonResponse<TransactionEntity> transfer = new CommonResponse<>();
        TransactionEntity cst = transactionDao.transfer(transaction);
        if (cst == null) {
            throw new NotFoundException(44, "Transaction failed!");
        } else {
            transfer.setData(cst);
        }
        return transfer;
    }

    @PostMapping(value = URI_REQUEST_TRANSACTION_WITHDRAW)
    public CommonResponse<TransactionEntity> withdraw(@RequestBody TransactionDto transaction) throws NotFoundException, EntityNotFoundException, InsufficientAmountException {
        CommonResponse<TransactionEntity> withdraw = new CommonResponse<>();
        TransactionEntity cst = transactionDao.withdraw(transaction);
        if (cst == null) {
            throw new NotFoundException(44, "Transaction failed!");
        }
        else {
            withdraw.setData(cst);
        }
        return withdraw;
    }
}
