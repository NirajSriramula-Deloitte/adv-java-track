package com.hashedin.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MyController {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("currency-conversion-service");
    }

    @GetMapping("/conversion/{from}/to/{to}/amount/{amount}")
    public ResponseEntity<String> convert(@PathVariable String from, @PathVariable String to, @PathVariable float amount){
        try{
            String url = "http://localhost:8082/currency/getcurrency/";
            LOGGER.info("Before Calling the Currency API for the first time for FROM");
            Currency from1 = restTemplate.getForObject(url+from,Currency.class);
            LOGGER.info("Before Calling the Currency API for the second time for TO");
            Currency to1 = restTemplate.getForObject(url+to,Currency.class);
            LOGGER.info("After Calling the Currency API for the second time");
            Float res = from1.getExchange_rate()*amount/to1.getExchange_rate();
            return ResponseEntity.ok(amount + " " + from1.getCur_name() + " = " + res.toString() +" " + to1.getCur_name());
        }
        catch (Exception e){
            return ResponseEntity.status(207).body("Invalid arguments check once");
        }
    }
}
