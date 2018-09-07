package com.db.consumer.dao;

import com.db.consumer.models.BitCoinCurrencyRate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BitCoinCurrencyRepository extends MongoRepository<BitCoinCurrencyRate, String> {

    List<BitCoinCurrencyRate> findByTimeAfterOrderByTime(LocalDateTime startTime);
}
