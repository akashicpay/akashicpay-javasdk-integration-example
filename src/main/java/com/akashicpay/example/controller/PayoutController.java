package com.akashicpay.example.controller;


import com.akashicpay.model.APNetworkSymbol;
import com.akashicpay.model.APTokenSymbol;
import com.akashicpay.example.service.PayoutService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/payout")
@CrossOrigin(origins = "*")
public class PayoutController {

    private final PayoutService payoutService;

    public PayoutController(PayoutService payoutService) {
        this.payoutService = payoutService;
    }

    // Example:
    //ex) http://127.0.0.1:8080/api/payout?recipientId=skynet&toAddress=TF97xibDz9ba4bGm6SNBYDSXA4mbeBK6JW&amount=10.5&network=TRX_SHASTA&token=USDT
    @GetMapping()
    public Object payout(@RequestParam String recipientId,
                         @RequestParam String toAddress,
                         @RequestParam double amount,
                         @RequestParam APNetworkSymbol network,
                         @RequestParam APTokenSymbol token) {

        try {
            return payoutService.payout(recipientId, toAddress, amount, network, token);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }


}
