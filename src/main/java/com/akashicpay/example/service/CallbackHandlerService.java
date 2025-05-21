package com.akashicpay.example.service;

import com.akashicpay.exception.APException;
import com.akashicpay.sdk.IAPSdk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CallbackHandlerService {

    @Autowired
    private final AkashicPayService akashicPayService;

    public CallbackHandlerService(Environment environment, AkashicPayService akashicPayService) {
        this.akashicPayService = akashicPayService;
    }

    @PostConstruct
    public void init() throws Exception {

    }

    private boolean verifyCallbackSignature(String rawBody, String signature) throws APException {
        return this.akashicPayService.getSDK().verifySignature(rawBody, signature);
    }

    public String handlePendingPayoutCallback(String rawBody, String signature) {

        try {
            if (!this.verifyCallbackSignature(rawBody, signature)) {
                throw new Exception("Invalid Signature with body: " + rawBody + " signature: " + signature);
            }

            return "ok";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String handlePayoutCallback(String rawBody, String signature) {

        try {

            if (!this.verifyCallbackSignature(rawBody, signature)) {
                throw new Exception("Invalid Signature with body: " + rawBody + " signature: " + signature);
            }
            //do Something
            return "ok";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String handleFailedPayoutCallback(String rawBody, String signature) {

        try {
            if (!this.verifyCallbackSignature(rawBody, signature)) {
                throw new Exception("Invalid Signature with body: " + rawBody + " signature: " + signature);
            }
            //do Something
            return "ok";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String handlePendingDepositCallback(String rawBody, String signature) {

        try {
            if (!this.verifyCallbackSignature(rawBody, signature)) {
                throw new Exception("Invalid Signature with body: " + rawBody + " signature: " + signature);
            }
            //do Something
            return "ok";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String handleDepositCallback(String rawBody, String signature) {

        try {
            if (!this.verifyCallbackSignature(rawBody, signature)) {
                throw new Exception("Invalid Signature with body: " + rawBody + " signature: " + signature);
            }
            //do Something
            return "ok";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String handleFailedDepositCallback(String rawBody, String signature) {

        try {
            if (!this.verifyCallbackSignature(rawBody, signature)) {
                throw new Exception("Invalid Signature with body: " + rawBody + " signature: " + signature);
            }
            //do Something
            return "ok";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
