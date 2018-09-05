package com.ilay.redditcrawler.services;

import com.ilay.redditcrawler.dao.BitcoinCurrencyRateRepository;
import com.ilay.redditcrawler.models.BitcoinCurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;

@Service
public class BitcoinDataFetchServiceImpl implements BitcoinDataFetchService {

    @Autowired
    private BitcoinCurrencyRateRepository rateRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Scheduled(fixedRate = 4000)
    public void fetchData() {
        Object currencyRate = restTemplate.getForObject("https://blockchain.info/ticker",
                Object.class);

        LinkedHashMap usdRates = (LinkedHashMap) ((LinkedHashMap) currencyRate).get("USD");

        BitcoinCurrencyRate bitcoinCurrencyRate = BitcoinCurrencyRate.builder()
                .code("USD")
                .sell((Double) usdRates.get("sell"))
                .buy((Double) usdRates.get("buy"))
                .build();
        rateRepository.save(bitcoinCurrencyRate);
    }
}
