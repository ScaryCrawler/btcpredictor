package com.ilay.redditcrawler.controllers;

import com.ilay.redditcrawler.dao.BitcoinCurrencyRateRepository;
import com.ilay.redditcrawler.models.BitCoinCurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BitcoinController {
    @Autowired
    private BitcoinCurrencyRateRepository bitcoinRepository;

    @GetMapping("/rates")
    public List<BitCoinCurrencyRate> getRates() {
        return (List<BitCoinCurrencyRate>) bitcoinRepository.findAll();
    }
}
