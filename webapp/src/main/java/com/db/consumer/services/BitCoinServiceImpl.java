package com.db.consumer.services;

import com.db.consumer.dao.BitCoinCurrencyRepository;
import com.db.consumer.models.BitCoinCurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BitCoinServiceImpl implements BitCoinService {
    private static final int CRAWLED_DATA_DELAY = 15;

    @Autowired
    private BitCoinCurrencyRepository bitCoinCurrencyRepository;

    @Override
    public List<BitCoinCurrencyRate> getAllRates() {
        return bitCoinCurrencyRepository.findAll();
    }

    @Override
    public List<BitCoinCurrencyRate> getTodayRates() {
        return bitCoinCurrencyRepository.findByTimeAfterOrderByTime(LocalDateTime.now().minusDays(1));
    }

    @Override
    public List<BitCoinCurrencyRate> getLastHourRates() {
        return bitCoinCurrencyRepository.findByTimeAfterOrderByTime(LocalDateTime.now().minusHours(1));
    }

    @Override
    public List<BitCoinCurrencyRate> getLastFiveMinutesRates() {
        return bitCoinCurrencyRepository.findByTimeAfterOrderByTime(LocalDateTime.now().minusMinutes(5 + CRAWLED_DATA_DELAY));
    }

    @Override
    public List<BitCoinCurrencyRate> getLastMinuteRates() {
        return bitCoinCurrencyRepository.findByTimeAfterOrderByTime(LocalDateTime.now().minusMinutes(1 + CRAWLED_DATA_DELAY));
    }
}
