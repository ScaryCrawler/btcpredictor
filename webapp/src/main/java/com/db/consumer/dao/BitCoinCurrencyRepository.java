package com.db.consumer.dao;


import com.db.consumer.models.BitCoinCurrencyRate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public interface BitCoinCurrencyRepository extends MongoRepository<BitCoinCurrencyRate, String> {
    default List<BitCoinCurrencyRate> getTodayRates() {
        return this.findAll()
                .stream()
                .filter(x -> x.getTime().isAfter(LocalDateTime.now().minusDays(1)))
                .collect(Collectors.toList());
    }

    default List<BitCoinCurrencyRate> getLashHourRates() {
        return this.findAll()
                .stream()
                .filter(x -> x.getTime().isAfter(LocalDateTime.now().minusHours(1)))
                .collect(Collectors.toList());
    }

    default List<BitCoinCurrencyRate> getLastFiveMinutesRates() {
        return this.findAll()
                .stream()
                .filter(x -> x.getTime().isAfter(LocalDateTime.now().minusMinutes(20)))
                .collect(Collectors.toList());
    }
}
