package com.akashicpay.example.service;

import com.akashicpay.exception.APException;
import com.akashicpay.model.*;
import com.akashicpay.sdk.IAPSdk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositUrlService {

    @Autowired
    private final AkashicPayService akashicPayService;

    public DepositUrlService(AkashicPayService akashicPayService) {

        this.akashicPayService = akashicPayService;
    }


    public Object getDepositUrlSimple(String identifier) throws APException {
        return this.akashicPayService.getSDK().getDepositUrl(identifier);
    }

    public Object getDepositUrlWithReferenceId(String identifier, String referenceId) throws APException {
        return this.akashicPayService.getSDK().getDepositUrl(identifier, referenceId);
    }

    public Object getDepositUrlWithReceiveCurrencies(String identifier,
                                                     String referenceId,
                                                     List<APCurrencySymbol> receiveCurrencies) throws APException {
        APDepositUrlRequest request = APDepositUrlRequest.builder()
                .identifier(identifier)
                .referenceId(referenceId)
                .receiveCurrencies(receiveCurrencies)
                .build();

        return this.akashicPayService.getSDK().getDepositUrl(request);
    }

    public Object getDepositUrlWithRequestedValue(String identifier,
                                                  String referenceId,
                                                  APCurrencySymbol requestedCurrency,
                                                  Double requestedAmount) throws APException {
        return this.akashicPayService.getSDK().getDepositUrlWithRequestedValue(identifier, referenceId, requestedCurrency, requestedAmount);
    }

    public Object getDepositUrlWithRequestedValueReceiveCurrencies(String identifier,
                                                                    String referenceId,
                                                                   APCurrencySymbol requestedCurrency,
                                                                   Double requestedAmount,
                                                                   List<APCurrencySymbol> receiveCurrencies) throws APException {
        APDepositUrlWithRequestedValueRequest request = APDepositUrlWithRequestedValueRequest.builder()
                .identifier(identifier)
                .referenceId(referenceId)
                .requestedCurrency(requestedCurrency)
                .requestedAmount(requestedAmount)
                .receiveCurrencies(receiveCurrencies)
                .build();

        return this.akashicPayService.getSDK().getDepositUrlWithRequestedValue(request);
    }
}
