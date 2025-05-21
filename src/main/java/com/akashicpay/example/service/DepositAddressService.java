package com.akashicpay.example.service;

import com.akashicpay.exception.APException;
import com.akashicpay.model.APCurrencySymbol;
import com.akashicpay.model.APNetworkSymbol;
import com.akashicpay.model.APTokenSymbol;
import com.akashicpay.sdk.IAPSdk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositAddressService {

    @Autowired
    private final AkashicPayService akashicPayService;


    public DepositAddressService(AkashicPayService akashicPayService) {
        this.akashicPayService = akashicPayService;
    }


    public Object getDepositAddressSimple(APNetworkSymbol network, String identifier) throws APException {
        return this.akashicPayService.getSDK().getDepositAddress(network, identifier);
    }

    public Object getDepositAddressWithReferenceId(APNetworkSymbol network, String identifier, String referenceId) throws APException {
        return this.akashicPayService.getSDK().getDepositAddress(network, identifier, referenceId);
    }

    public Object getDepositAddressWithRequestValue(APNetworkSymbol network,
                                                    String identifier,
                                                    String referenceId,
                                                    APCurrencySymbol requestedCurrency,
                                                    double requestedAmount,
                                                    APTokenSymbol token) throws APException {
        return this.akashicPayService.getSDK().getDepositAddressWithRequestedValue(network, identifier, referenceId, requestedCurrency, requestedAmount, token);
    }

    public Object payout(String recipientId,
                         String toAddress,
                         double amount,
                         APNetworkSymbol network,
                         APTokenSymbol token) {

        try {

            return akashicPayService.getSDK().payout(recipientId, toAddress, amount, network, token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
