package com.akashicpay.example.service;

import com.akashicpay.APSdkFactory;
import com.akashicpay.constants.APEnvironment;
import com.akashicpay.exception.APException;
import com.akashicpay.model.ACOtk;
import com.akashicpay.model.APCurrencySymbol;
import com.akashicpay.model.APNetworkSymbol;
import com.akashicpay.model.APTokenSymbol;
import com.akashicpay.sdk.IAPSdk;
import org.springframework.stereotype.Component;

import java.time.Instant;


@Component
public class AkashicPayService {

    ACOtk otk;
    IAPSdk akashicPay;


    public void init(String identity, String privateKey, String apiSecret) throws APException {
        otk = APSdkFactory.createOtkFromKeyPair(privateKey, identity);
        akashicPay = APSdkFactory.createSDK(APEnvironment.Development, otk, apiSecret);
    }

    public IAPSdk getSDK() {
        return this.akashicPay;
    }

}
