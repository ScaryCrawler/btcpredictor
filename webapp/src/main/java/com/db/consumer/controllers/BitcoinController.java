package com.db.consumer.controllers;

import com.db.consumer.dao.BitCoinCurrencyRepository;
import com.db.consumer.models.BitCoinCurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BitcoinController {
//    @Autowired
//    @LoadBalanced
//    private RestTemplate restTemplate;

    @Autowired
    private BitCoinCurrencyRepository bitCoinCurrencyRepository;

    @GetMapping("/rates")
    public List<BitCoinCurrencyRate> getAllRates() {
        return bitCoinCurrencyRepository.findAll();
    }
}
