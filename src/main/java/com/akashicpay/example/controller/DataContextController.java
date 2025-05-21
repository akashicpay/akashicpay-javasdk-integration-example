package com.akashicpay.example.controller;

import com.akashicpay.model.APCurrencySymbol;
import com.akashicpay.example.service.DataContextService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/data-context")
@CrossOrigin(origins = "*")
public class DataContextController {

    private final DataContextService dataContextService;

    public DataContextController(DataContextService dataContextService) {
        this.dataContextService = dataContextService;
    }

    // Example:
    // curl -X GET http://127.0.0.1:8080/api/data-context/getBalance
    @GetMapping("getBalance")
    public Object getBalance() {
        try {
            return dataContextService.getBalance();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    // Example:
    // curl -X GET http://127.0.0.1:8080/api/data-context/getTransfers
    @GetMapping("getTransfers")
    public Object getTransfers() {
        try {
            return dataContextService.getTransfers();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    // Example:
    // curl -X GET "http://127.0.0.1:8080/api/data-context/getTransactionDetails?txHash=AS92a6e3c4b42ac1431666dc2ef180553e07288f1e81c7cd6672bc59b22dc527fa"
    @GetMapping("getTransactionDetails")
    public Object getTransactionDetails(@RequestParam String txHash) {
        try {
            return dataContextService.getTransactionDetails(txHash);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    // Example:
    // curl -X GET "http://127.0.0.1:8080/api/data-context/exchangeRates?currencySymbol=USDT"
    @GetMapping("exchangeRates")
    public Object getExchangeRates(@RequestParam APCurrencySymbol currencySymbol){
        try {
            return dataContextService.getExchangeRates(currencySymbol);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }
}
