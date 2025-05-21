package com.akashicpay.example.controller;


import com.akashicpay.model.APCurrencySymbol;
import com.akashicpay.example.service.DepositUrlService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/deposit-url")
@CrossOrigin(origins = "*")
public class DepositUrlController {

    private final DepositUrlService depositUrlService;

    public DepositUrlController(DepositUrlService depositUrlService) {
        this.depositUrlService = depositUrlService;
    }

    // Example:
    // curl -X GET "http://127.0.0.1:8080/api/deposit-url/simple?identifier=test052101"
    @GetMapping("simple")
    public Object getDepositUrlSimple(@RequestParam String identifier) {
        try {
            return depositUrlService.getDepositUrlSimple(identifier);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    // Example:
    // curl -X GET "http://127.0.0.1:8080/api/deposit-url/with-referenceId?identifier=test052101&referenceId=helloref01"
    @GetMapping("with-referenceId")
    public Object getDepositUrlWithReferenceId(@RequestParam String identifier,
                                               @RequestParam String referenceId) {
        try {
            return depositUrlService.getDepositUrlWithReferenceId(identifier, referenceId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }


    // Example:
    // curl -X GET "http://127.0.0.1:8080/api/deposit-url/with-receiveCurrencies?identifier=test052102&referenceId=helloref02&receiveCurrencies=USDT,TRX"
    @GetMapping("with-receiveCurrencies")
    public Object getDepositUrlWithReceiveCurrencies(@RequestParam String identifier,
                                                     @RequestParam String referenceId,
                                                     @RequestParam List<APCurrencySymbol> receiveCurrencies) {
        try {
            return depositUrlService.getDepositUrlWithReceiveCurrencies(identifier, referenceId, receiveCurrencies);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    // Example:
    // curl -X GET "http://127.0.0.1:8080/api/deposit-url/extended-with-requestedValue?identifier=test052103&referenceId=helloref03&requestedCurrency=USDT&requestedAmount=100.5"
    @GetMapping("extended-with-requestedValue")
    public Object getDepositUrlWithRequestedValue(@RequestParam String identifier,
                                                  @RequestParam String referenceId,
                                                  @RequestParam APCurrencySymbol requestedCurrency,
                                                  @RequestParam Double requestedAmount) {
        try {
            return depositUrlService.getDepositUrlWithRequestedValue(identifier, referenceId, requestedCurrency, requestedAmount);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    // Example:
    // curl -X GET "http://127.0.0.1:8080/api/deposit-url/extended-with-requestedValue-receiveCurrencies?identifier=test052104&referenceId=helloref04&requestedCurrency=USDT&requestedAmount=100.5&receiveCurrencies=USDT"
    @GetMapping("extended-with-requestedValue-receiveCurrencies")
    public Object getDepositUrlWithRequestedValueReceiveCurrencies(@RequestParam String identifier,
                                                                   @RequestParam String referenceId,
                                                                   @RequestParam APCurrencySymbol requestedCurrency,
                                                                   @RequestParam Double requestedAmount,
                                                                   @RequestParam List<APCurrencySymbol> receiveCurrencies) {
        try {
            return depositUrlService.getDepositUrlWithRequestedValueReceiveCurrencies(identifier, referenceId, requestedCurrency, requestedAmount, receiveCurrencies);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }


}
