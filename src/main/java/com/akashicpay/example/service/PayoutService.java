package com.akashicpay.example.service;

import com.akashicpay.model.APNetworkSymbol;
import com.akashicpay.model.APTokenSymbol;
import com.akashicpay.sdk.IAPSdk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayoutService {

    @Autowired
    private final AkashicPayService akashicPayService;

    public PayoutService(AkashicPayService akashicPayService) {
        this.akashicPayService = akashicPayService;
    }


    public Object payout(String recipientId,
                         String toAddress,
                         double amount,
                         APNetworkSymbol network,
                         APTokenSymbol token) {

        try {

            return this.akashicPayService.getSDK().payout(recipientId, toAddress, amount, network, token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
