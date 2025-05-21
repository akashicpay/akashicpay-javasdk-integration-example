package com.akashicpay.example.controller;


import com.akashicpay.example.service.CallbackHandlerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/callback")
@CrossOrigin(origins = "*")
public class CallbackHandlerController {

    private final CallbackHandlerService callbackHandlerService;

    public CallbackHandlerController(CallbackHandlerService callbackHandlerService) {
        this.callbackHandlerService = callbackHandlerService;
    }

    @PostMapping("pending-payout")
    public Object pendingPayoutCallback(@RequestBody String rawBody,
                           @RequestHeader(value = "Signature", required = false) String signature) {

        try {
            if (signature == null || signature.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Signature header is empty!");
            }

            if (rawBody == null || rawBody.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "body is empty!");
            }

            return callbackHandlerService.handlePendingPayoutCallback(rawBody, signature);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    @PostMapping("payout")
    public Object payoutCallback(@RequestBody String rawBody,
                                        @RequestHeader(value = "Signature", required = false) String signature) {

        try {
            if (signature == null || signature.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Signature header is empty!");
            }

            if (rawBody == null || rawBody.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "body is empty!");
            }
            return callbackHandlerService.handlePayoutCallback(rawBody, signature);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    @PostMapping("failed-payout")
    public Object failedPayoutCallback(@RequestBody String rawBody,
                                        @RequestHeader(value = "Signature", required = false) String signature) {

        try {
            if (signature == null || signature.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Signature header is empty!");
            }

            if (rawBody == null || rawBody.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "body is empty!");
            }
            return callbackHandlerService.handleFailedPayoutCallback(rawBody, signature);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    @PostMapping("pending-deposit")
    public Object pendingDepositCallback(@RequestBody String rawBody,
                                        @RequestHeader(value = "Signature", required = false) String signature) {

        try {
            if (signature == null || signature.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Signature header is empty!");
            }

            if (rawBody == null || rawBody.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "body is empty!");
            }
            return callbackHandlerService.handlePendingDepositCallback(rawBody, signature);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    @PostMapping("deposit")
    public Object depositCallback(@RequestBody String rawBody,
                                        @RequestHeader(value = "Signature", required = false) String signature) {

        try {
            if (signature == null || signature.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Signature header is empty!");
            }

            if (rawBody == null || rawBody.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "body is empty!");
            }
            return callbackHandlerService.handleDepositCallback(rawBody, signature);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    @PostMapping("failed-deposit")
    public Object failedDepositCallback(@RequestBody String rawBody,
                                        @RequestHeader(value = "Signature", required = false) String signature) {

        try {
            if (signature == null || signature.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Signature header is empty!");
            }

            if (rawBody == null || rawBody.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "body is empty!");
            }

            return callbackHandlerService.handleFailedDepositCallback(rawBody, signature);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }
}
