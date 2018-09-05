package com.ilay.redditcrawler.controllers;

import com.ilay.redditcrawler.dao.BitcoinCurrencyRateRepository;
import com.ilay.redditcrawler.models.BitcoinCurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BitcoinController {
    @Autowired
    private BitcoinCurrencyRateRepository bitcoinRepository;

    @GetMapping("/rates")
    public List<BitcoinCurrencyRate> getRates() {
        return (List<BitcoinCurrencyRate>) bitcoinRepository.findAll();
    }
}
