package com.db.consumer.services;

import com.db.consumer.models.BitCoinCurrencyRate;

import java.util.List;

public interface BitCoinService {
    List<BitCoinCurrencyRate> getAllRates();
    List<BitCoinCurrencyRate> getTodayRates();
    List<BitCoinCurrencyRate> getLastHourRates();
    List<BitCoinCurrencyRate> getLastFiveMinutesRates();
    List<BitCoinCurrencyRate> getLastMinuteRates();
}
