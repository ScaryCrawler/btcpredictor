package com.db.consumer.controllers;

import com.db.consumer.dao.BitCoinCurrencyRepository;
import com.db.consumer.models.BitCoinCurrencyRate;
import com.db.consumer.services.BitCoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
public class BitCoinController {
    @Autowired
    private BitCoinService bitCoinService;

    @GetMapping("/rates")
    public List<BitCoinCurrencyRate> getAllRates() {
        return bitCoinService.getAllRates();
    }

    @GetMapping("/todayRates")
    public List<BitCoinCurrencyRate> getTodayRates() {
        return bitCoinService.getTodayRates();
    }

    @GetMapping("/lastHourRates")
    public List<BitCoinCurrencyRate> getLastHourRates() {
        return bitCoinService.getLastHourRates();
    }

    @GetMapping("/lastFiveMinutesRates")
    public List<BitCoinCurrencyRate> getLastFiveMinutesRates() {
        return bitCoinService.getLastFiveMinutesRates();
    }

    @GetMapping("/lastMinuteRates")
    public List<BitCoinCurrencyRate> getLastMinuteRates() {
        return bitCoinService.getLastMinuteRates();
    }
}
