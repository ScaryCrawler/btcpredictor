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
}
