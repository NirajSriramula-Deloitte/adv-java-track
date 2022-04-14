package com.hashedin.currencyexchangeservice.controllers;

import com.hashedin.currencyexchangeservice.entities.Currency;
import com.hashedin.currencyexchangeservice.repos.CurrencyRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CurrencyController {

    @Autowired
    private CurrencyRepo repo;


    private static final Logger log = LoggerFactory.getLogger(CurrencyController.class);

    @GetMapping("/Currency/getAllCurrencies")
    public List<Currency> getAllCurrencies() {
        return repo.findAll();
    }

    @PutMapping("/Currency/updateCur")
    public ResponseEntity<Object> updatePrefs(@RequestBody Currency currency){

        try {
            Currency Currency =  repo.findCurrencyByCurname(currency.getCur_name());
            Currency.setExchange_rate(currency.getExchange_rate());
            Currency res = repo.save(Currency);
            return BaseResponse.generateResponse("Update Successful",HttpStatus.OK,res);
        }
        catch (Exception e){
            e.printStackTrace();
            return BaseResponse.generateResponse("Update failed", HttpStatus.MULTI_STATUS, e);
        }
    }

    //Getting Currency based on the Phone Number
    @GetMapping("currency/getcurrency/{curname}")
    public Currency getCurrency(@PathVariable String curname) throws Exception {

        log.info("In server");
        return repo.findCurrencyByCurname(curname);
    }



    @PostMapping("currency/add")
    public ResponseEntity<Object> postCurrency(@RequestBody Currency currency) {
        try {
            Currency  result = repo.save(currency);
            return BaseResponse.generateResponse("Successfully added data!", HttpStatus.OK, result);
        }
        catch (Exception e){
            return BaseResponse.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
class BaseResponse {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map,status);
    }
}
