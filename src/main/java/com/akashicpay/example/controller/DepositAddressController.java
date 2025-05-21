package com.akashicpay.example.controller;


import com.akashicpay.model.APCurrencySymbol;
import com.akashicpay.model.APNetworkSymbol;
import com.akashicpay.model.APTokenSymbol;
import com.akashicpay.example.service.DepositAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/deposit-address")
@CrossOrigin(origins = "*")
public class DepositAddressController {

    private final DepositAddressService depositAddressService;

    public DepositAddressController(DepositAddressService depositAddressService) {
        this.depositAddressService = depositAddressService;
    }

    // Example:
    // curl -X GET "http://127.0.0.1:8080/api/deposit-address/simple?network=TRX_SHASTA&identifier=052101"
    @GetMapping("simple")
    public Object getDepositAddressSimple(@RequestParam APNetworkSymbol network,
                                          @RequestParam String identifier) {
        try {
            return depositAddressService.getDepositAddressSimple(network, identifier);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    // Example:
    // curl -X GET "http://127.0.0.1:8080/api/deposit-address/with-referenceId?network=TRX_SHASTA&identifier=052101&referenceId=sample-ref01"
    @GetMapping("with-referenceId")
    public Object getDepositAddressWithReferenceId(@RequestParam APNetworkSymbol network,
                                                         @RequestParam String identifier,
                                                         @RequestParam String referenceId) {
        try {
            return depositAddressService.getDepositAddressWithReferenceId(network, identifier, referenceId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    // Example:
    // curl -X GET "http://127.0.0.1:8080/api/deposit-address/extended-with-requestedValue?network=TRX_SHASTA&identifier=052101&referenceId=sample-ref01&requestedCurrency=CNY&requestedAmount=100&token=USDT"
    @GetMapping("extended-with-requestedValue")
    public Object getDepositAddressWithRequestValue(@RequestParam APNetworkSymbol network,
                                                    @RequestParam String identifier,
                                                    @RequestParam String referenceId,
                                                    @RequestParam APCurrencySymbol requestedCurrency,
                                                    @RequestParam double requestedAmount,
                                                    @RequestParam APTokenSymbol token) {
        try {
            return depositAddressService.getDepositAddressWithRequestValue(network, identifier, referenceId, requestedCurrency, requestedAmount, token);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
    }

}
