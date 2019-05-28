package com.enigma.walletkurs.controller;

import com.enigma.walletkurs.dao.TransactionDao;
import com.enigma.walletkurs.exception.NotFoundException;
import com.enigma.walletkurs.helper.response.CommonResponse;
import com.enigma.walletkurs.models.TransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    public static final String URI_REQUEST_TRANSACTION_BY_ID = "transaction/{transactionId}";
    public static final String URI_REQUEST_TRANSACTION_TOPUP = "transaction/topup";
    public static final String URI_REQUEST_TRANSACTION_TRANSFER = "transaction/transfer";
    public static final String URI_REQUEST_TRANSACTION_WITHDRAW = "transaction/withdraw";

    @Autowired
    private TransactionDao transactionDao;

    @PostMapping(value = URI_REQUEST_TRANSACTION_TOPUP)
    public CommonResponse<TransactionEntity> topUp(@RequestBody TransactionEntity transaction) throws NotFoundException {
        CommonResponse<TransactionEntity> topUp = new CommonResponse<>();
        TransactionEntity cst = transactionDao.topUp(transaction);
        if (cst == null){
            throw new NotFoundException(44, "Transaction failed!");
        }else{
            topUp.setData(cst);
            System.out.println("Data : " + topUp);
        }
        return topUp;
    }
}
