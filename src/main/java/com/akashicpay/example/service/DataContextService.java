package com.akashicpay.example.service;

import com.akashicpay.exception.APException;
import com.akashicpay.model.APCurrencySymbol;
import com.akashicpay.model.APTransactionsParam;
import com.akashicpay.sdk.IAPSdk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataContextService {

    @Autowired
    private final AkashicPayService akashicPayService;

    public DataContextService(AkashicPayService akashicPayService) {
        this.akashicPayService = akashicPayService;
    }


    public Object getBalance() throws APException {
        return this.akashicPayService.getSDK().getBalance();
    }

    public Object getTransfers() throws APException {
        APTransactionsParam param = APTransactionsParam.builder()
                .page(0)
                .limit(10)
                .build();

        return this.akashicPayService.getSDK().getTransfers(param);
    }

    public Object getTransactionDetails(String txHash) throws APException {
        return this.akashicPayService.getSDK().getTransactionDetail(txHash);
    }

    public Object getExchangeRates(APCurrencySymbol currencySymbol) throws APException {
        return this.akashicPayService.getSDK().getExchangeRates(currencySymbol);
    }
}



