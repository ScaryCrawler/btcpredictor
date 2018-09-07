package com.ilay.redditcrawler.services;

import com.ilay.redditcrawler.dao.BitcoinCurrencyRateRepository;
import com.ilay.redditcrawler.models.BitCoinCurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

@Service
public class BitCoinDataFetchServiceImpl implements BitCoinDataFetchService {

    @Autowired
    private BitcoinCurrencyRateRepository rateRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    @Value("${target.currency}")
    private String targetCurrency;

    @Override
    @Scheduled(fixedRate = 1000)
    public void fetchData() {
        Object currencyRate = restTemplate.getForObject(apiUrl, Object.class);

        LinkedHashMap usdRates = (LinkedHashMap) ((LinkedHashMap) currencyRate).get(targetCurrency);

        BitCoinCurrencyRate bitcoinCurrencyRate = BitCoinCurrencyRate.builder()
                .code(targetCurrency)
                .sell((Double) usdRates.get("sell"))
                .buy((Double) usdRates.get("buy"))
                .time(LocalDateTime.now().minusMinutes(15))
                .build();
        rateRepository.save(bitcoinCurrencyRate);
    }
}
